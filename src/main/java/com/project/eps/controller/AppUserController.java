package com.project.eps.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.common.constant.CommonEnum;
import com.common.util.BaseResultHelper;
import com.project.app.exception.CustomException;
import com.project.app.model.common.BaseDto;
import com.project.app.model.common.Constant;
import com.project.app.model.common.ResponseBean;
import com.project.app.util.AesCipherUtil;
import com.project.app.util.JedisUtil;
import com.project.app.util.JwtUtil;
import com.project.app.util.PhoneUtil;
import com.project.common.config.BootdoConfig;
import com.project.eps.domain.AppUserDO;
import com.project.eps.domain.AppUserVO;
import com.project.eps.service.AppUserService;

import net.sf.json.JSONObject;

/**
 * UserController
 * @author Wang926454
 * @date 2018/8/29 15:45
 */
@RestController
@RequestMapping("/app/user")
@PropertySource("classpath:config.properties")
public class AppUserController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
    /**
     * RefreshToken过期时间
     */
    @Value("${refreshTokenExpireTime}")
    private String refreshTokenExpireTime;
    @Autowired
	private BootdoConfig bootdoConfig;
    
    @Autowired
	private AppUserService appUserService;

/*    private final IUserService userService;

    @Autowired
    public AppUserController(IUserService userService) {
        this.userService = userService;
    }*/

    /**
     * 获取用户列表
     * @param 
     * @return java.util.Map<java.lang.String,java.lang.Object>
     * @author Wang926454
     * @date 2018/8/30 10:41
     */
    @GetMapping
    //@RequiresPermissions(logical = Logical.AND, value = {"user:view"})
    public ResponseBean user(@Validated BaseDto baseDto) {
        /*if (baseDto.getPage() == null || baseDto.getRows() == null) {
            baseDto.setPage(1);
            baseDto.setRows(10);
        }
        PageHelper.startPage(baseDto.getPage(), baseDto.getRows());
        List<UserDto> userDtos = userService.selectAll();
        PageInfo<UserDto> selectPage = new PageInfo<UserDto>(userDtos);
        if (userDtos == null || userDtos.size() <= 0) {
            throw new CustomException("查询失败(Query Failure)");
        }
        Map<String, Object> result = new HashMap<String, Object>(16);
        result.put("count", selectPage.getTotal());
        result.put("data", selectPage.getList());
        return new ResponseBean(HttpStatus.OK.value(), "查询成功(Query was successful)", result);*/
    	return null;
    }

    /**
     * 获取在线用户(查询Redis中的RefreshToken)
     * @param 
     * @return com.wang.model.common.ResponseBean
     * @author Wang926454
     * @date 2018/9/6 9:58
     */
    @GetMapping("/online")
    @RequiresPermissions(logical = Logical.AND, value = {"user:view"})
    public ResponseBean online() {
        List<Object> userDtos = new ArrayList<Object>();
        // 查询所有Redis键
        Set<String> keys = JedisUtil.keysS(Constant.PREFIX_SHIRO_REFRESH_TOKEN + "*");
        for (String key : keys) {
            if (JedisUtil.exists(key)) {
                // 根据:分割key，获取最后一个字符(帐号)
                String[] strArray = key.split(":");
                /*UserDto userDto = new UserDto();
                userDto.setAccount(strArray[strArray.length - 1]);
                userDto = userService.selectOne(userDto);
                // 设置登录时间
                userDto.setLoginTime(new Date(Long.parseLong(JedisUtil.getObject(key).toString())));
                userDtos.add(userDto);*/
            }
        }
        if (userDtos == null || userDtos.size() <= 0) {
            throw new CustomException("查询失败(Query Failure)");
        }
        return new ResponseBean(HttpStatus.OK.value(), "查询成功(Query was successful)", userDtos);
    }
    
    /**
	 * App注册 （替换原 手机号注册v2/app/user）
	 * 
	 * @param body
	 *            style
	 *            {"countryCode":"+86","userName":"13241111111","code":"验证码",
	 *            "password":"123456"}
	 * 
	 */
	/*@RequestMapping(value = "register", method = RequestMethod.POST)
	@ResponseBody*/
    @PostMapping("/register")
	public Object registerAppUser(@RequestBody JSONObject body, HttpServletRequest request,
			HttpServletResponse response) {

		if (!body.containsKey("username") || !body.containsKey("password") || !body.containsKey("code")) {
			return BaseResultHelper.error(CommonEnum.CODE.PARAM_MISSING.description);
		}

		// 验证参数
		String username = body.optString("username");
		String password = body.optString("password");
		
		String countryCode = body.optString("country_code");
		boolean isInternationalPhone = PhoneUtil.isInternationalNumber(countryCode);//是否属于国际号码
		countryCode = PhoneUtil.getValidCountryCode(countryCode);
		body.put("country_code", countryCode);
		
		String phone = body.optString("username");
		String fullPhone = countryCode + phone;
		String phoneRegexp = "";
		if (isInternationalPhone) {
			phoneRegexp = bootdoConfig.getPhoneInternationalRegexp();// 国际手机号正则
		} else {
			phoneRegexp = bootdoConfig.getPhoneRegexp();// 手机号正则
		}

		if (!fullPhone.matches(phoneRegexp) ) {
			logger.error("账号输入有误:" + fullPhone);
			return BaseResultHelper.error(CommonEnum.CODE.USERNAME_INCORRECT.code, CommonEnum.CODE.USERNAME_INCORRECT.description);
		}

		String passwordRegexp = bootdoConfig.getPasswordRegexp();// 密码正则
		if (!password.matches(passwordRegexp)) {// 判断密码格式
			logger.error("密码必须是6-16位:" + phone);
			return BaseResultHelper.error(CommonEnum.CODE.PASSWORD_INCORRECT.code, "密码必须是6-16位");
		}
		String validatePhone = fullPhone;
		if (isInternationalPhone) {// 国际号码发送短信时，拼接00
			validatePhone = "00" + validatePhone;
		}

		// 利用短信接口的验证，判断短信验证码是否正确
		String code = body.optString("code");
		/*if (!MDSmsSendV2.smsValidate(validatePhone, code)) // 看验证码是否正确
			return MteduResult.error_code();*/

		AppUserDO dto = new AppUserDO();
		dto.setCountryCode(countryCode);
		dto.setUsername(username);
		AppUserDO appUser = appUserService.selectUser(dto);
		if(appUser != null){//帐户已存在
			return BaseResultHelper.error(CommonEnum.CODE.USER_EXIST.code, CommonEnum.CODE.USER_EXIST.description);
		}
		try {
			AppUserVO dbUser = appUserService.registerUser(body);
			
			// 清除可能存在的Shiro权限信息缓存
            if (JedisUtil.exists(Constant.PREFIX_SHIRO_CACHE + dbUser.getUser_id())) {
                JedisUtil.delKey(Constant.PREFIX_SHIRO_CACHE + dbUser.getUser_id());
            }
            // 设置RefreshToken，时间戳为当前时间戳，直接设置即可(不用先删后设，会覆盖已有的RefreshToken)
            String currentTimeMillis = String.valueOf(System.currentTimeMillis());
            JedisUtil.setObject(Constant.PREFIX_SHIRO_REFRESH_TOKEN + dbUser.getUser_id(), currentTimeMillis, Integer.parseInt(refreshTokenExpireTime));
            // 从Header中Authorization返回AccessToken，时间戳为当前时间戳
            String token = JwtUtil.sign(String.valueOf(dbUser.getUser_id()), currentTimeMillis);
            response.setHeader("Authorization", token);
            response.setHeader("Access-Control-Expose-Headers", "Authorization");
            return BaseResultHelper.success(dbUser);
			//return MteduResult.success(AES.encrypt("1234567812345678", user.getId() + ""));// 注意，userid需要加密
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			return BaseResultHelper.error();// 返回失败
		}

	}

    /**
     * 登录授权
     * @param userDto
     * @return com.wang.model.common.ResponseBean
     * @author Wang926454
     * @date 2018/8/30 16:21
     */
    /*@PostMapping("/login")
    public ResponseBean login(@RequestBody MasterUserDTO userDto, HttpServletResponse httpServletResponse) {
        // 查询数据库中的帐号信息
    	
    	 
    	
        UserDto userDtoTemp = new UserDto();
        userDtoTemp.setAccount(userDto.getAccount());
        userDtoTemp = userService.selectOne(userDtoTemp);
        if (userDtoTemp == null) {
            throw new CustomUnauthorizedException("该帐号不存在(The account does not exist.)");
        }
        // 密码进行AES解密
        String key = AesCipherUtil.deCrypto(userDtoTemp.getPassword());
        // 因为密码加密是以帐号+密码的形式进行加密的，所以解密后的对比是帐号+密码
        if (key.equals(userDto.getAccount() + userDto.getPassword())) {
            // 清除可能存在的Shiro权限信息缓存
            if (JedisUtil.exists(Constant.PREFIX_SHIRO_CACHE + userDto.getAccount())) {
                JedisUtil.delKey(Constant.PREFIX_SHIRO_CACHE + userDto.getAccount());
            }
            // 设置RefreshToken，时间戳为当前时间戳，直接设置即可(不用先删后设，会覆盖已有的RefreshToken)
            String currentTimeMillis = String.valueOf(System.currentTimeMillis());
            JedisUtil.setObject(Constant.PREFIX_SHIRO_REFRESH_TOKEN + userDto.getAccount(), currentTimeMillis, Integer.parseInt(refreshTokenExpireTime));
            // 从Header中Authorization返回AccessToken，时间戳为当前时间戳
            String token = JwtUtil.sign(userDto.getAccount(), currentTimeMillis);
            httpServletResponse.setHeader("Authorization", token);
            httpServletResponse.setHeader("Access-Control-Expose-Headers", "Authorization");
            return new ResponseBean(HttpStatus.OK.value(), "登录成功(Login Success.)", null);
        } else {
            throw new CustomUnauthorizedException("帐号或密码错误(Account or Password Error.)");
        }
    }*/
    
    /**
	 * 用户登录
	 * @param body style {"countryCode":"+86","username":"13241111111","password":"123456"}
	 * @author Yum
	 */
	/*@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody*/
	@PostMapping("/login")
	public Object loginApp(@RequestBody JSONObject body, HttpServletRequest request, HttpServletResponse response) {

		if (!body.containsKey("username") || !body.containsKey("password")) {
			return BaseResultHelper.error(CommonEnum.CODE.PARAM_MISSING.description);
		}

		// 验证参数
		String username = body.optString("username");
		String password = body.optString("password");
		
		String countryCode = body.optString("countryCode");
		boolean isInternationalPhone = PhoneUtil.isInternationalNumber(countryCode);//是否属于国际号码
		countryCode = PhoneUtil.getValidCountryCode(countryCode);
		body.put("country_code", countryCode);
		
		String phone = body.optString("username");
		String fullPhone = countryCode + phone;
		String phoneRegexp = "";
		if (isInternationalPhone) {
			phoneRegexp = bootdoConfig.getPhoneInternationalRegexp();// 国际手机号正则
		} else {
			phoneRegexp = bootdoConfig.getPhoneRegexp();// 手机号正则
		}

		if (!fullPhone.matches(phoneRegexp) ) {
			logger.error("账号输入有误:" + fullPhone);
			return BaseResultHelper.error(CommonEnum.CODE.USERNAME_OR_PASSWORD_INCORRECT.code, CommonEnum.CODE.USERNAME_OR_PASSWORD_INCORRECT.description);
		}
		
		try {
			// service 进行业务处理
			//return userServiceV3.loginApp(countryCode,userName, password, request);
			AppUserDO dto = new AppUserDO();
			dto.setCountryCode(countryCode);
			dto.setUsername(username);
			AppUserDO appUser = appUserService.selectUser(dto);
			if(appUser == null){
				return BaseResultHelper.error(CommonEnum.CODE.USER_NOT_EXIST.code, CommonEnum.CODE.USER_NOT_EXIST.description);
			}
			
			// 密码进行AES解密
	        String key = AesCipherUtil.deCrypto(appUser.getPassword());
	        // 因为密码加密是以帐号+密码的形式进行加密的，所以解密后的对比是帐号+密码
	        if (key.equals(username + password)) {
	            // 清除可能存在的Shiro权限信息缓存
	            if (JedisUtil.exists(Constant.PREFIX_SHIRO_CACHE + appUser.getId())) {
	                JedisUtil.delKey(Constant.PREFIX_SHIRO_CACHE + appUser.getId());
	            }
	            // 设置RefreshToken，时间戳为当前时间戳，直接设置即可(不用先删后设，会覆盖已有的RefreshToken)
	            String currentTimeMillis = String.valueOf(System.currentTimeMillis());
	            JedisUtil.setObject(Constant.PREFIX_SHIRO_REFRESH_TOKEN + appUser.getId(), currentTimeMillis, Integer.parseInt(refreshTokenExpireTime));
	            // 从Header中Authorization返回AccessToken，时间戳为当前时间戳
	            String token = JwtUtil.sign(String.valueOf(appUser.getId()), currentTimeMillis);
	            response.setHeader("Authorization", token);
	            response.setHeader("Access-Control-Expose-Headers", "Authorization");
	            return BaseResultHelper.success();
	        }else{
	        	return BaseResultHelper.error(CommonEnum.CODE.USERNAME_OR_PASSWORD_INCORRECT.code, CommonEnum.CODE.USERNAME_OR_PASSWORD_INCORRECT.description);
	        } 
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			return BaseResultHelper.error();
		}
	}

    /**
     * 测试登录
     * @param
     * @return com.wang.model.common.ResponseBean
     * @author Wang926454
     * @date 2018/8/30 16:18
     */
//    @GetMapping("/article")
//    public ResponseBean article() {
//        Subject subject = SecurityUtils.getSubject();
//        // 登录了返回true
//        if (subject.isAuthenticated()) {
//            return new ResponseBean(HttpStatus.OK.value(), "您已经登录了(You are already logged in)", null);
//        } else {
//            return new ResponseBean(HttpStatus.OK.value(), "你是游客(You are guest)", null);
//        }
//    }

    /**
     * 测试登录注解(@RequiresAuthentication和subject.isAuthenticated()返回true一个性质)
     * @param
     * @return com.wang.model.common.ResponseBean
     * @author Wang926454
     * @date 2018/8/30 16:18
     */
//    @GetMapping("/article2")
//    @RequiresAuthentication
//    public ResponseBean requireAuth() {
//        return new ResponseBean(HttpStatus.OK.value(), "您已经登录了(You are already logged in)", null);
//    }

    /**
     * 获取指定用户
     * @param id
     * @return java.util.Map<java.lang.String,java.lang.Object>
     * @author Wang926454
     * @date 2018/8/30 10:42
     */
    @GetMapping("/{userId}")
    //@RequiresPermissions(logical = Logical.AND, value = {"user:view"})
    @ResponseBody
	public Object  getUser(@PathVariable("userId") Long userId) {
    	
    	if(userId <= 0){
    		return BaseResultHelper.error();
    	}
    	AppUserDO appUser = appUserService.get(userId);
        if (appUser == null) {
        	return BaseResultHelper.error(CommonEnum.CODE.USER_NOT_EXIST.description);
        }
        return BaseResultHelper.success(appUser);
    }

    /**
     * 新增用户
     * @param userDto
     * @return java.util.Map<java.lang.String,java.lang.Object>
     * @author Wang926454
     * @date 2018/8/30 10:42
     */
    /*@PostMapping
    //@RequiresPermissions(logical = Logical.AND, value = {"user:edit"})
    public ResponseBean add(@Validated(UserEditValidGroup.class) @RequestBody UserDto userDto) {
        // 判断当前帐号是否存在
        UserDto userDtoTemp = new UserDto();
        userDtoTemp.setAccount(userDto.getAccount());
        userDtoTemp = userService.selectOne(userDtoTemp);
        if (userDtoTemp != null && StringUtil.isNotBlank(userDtoTemp.getPassword())) {
            throw new CustomUnauthorizedException("该帐号已存在(Account exist.)");
        }
        userDto.setRegTime(new Date());
        // 密码以帐号+密码的形式进行AES加密
        if (userDto.getPassword().length() > Constant.PASSWORD_MAX_LEN) {
            throw new CustomException("密码最多8位(Password up to 8 bits.)");
        }
        String key = AesCipherUtil.enCrypto(userDto.getAccount() + userDto.getPassword());
        userDto.setPassword(key);
        int count = userService.insert(userDto);
        if (count <= 0) {
            throw new CustomException("新增失败(Insert Failure)");
        }
        return new ResponseBean(HttpStatus.OK.value(), "新增成功(Insert Success)", userDto);
    }*/

//    /**
//     * 更新用户
//     * @param userDto
//     * @return java.util.Map<java.lang.String,java.lang.Object>
//     * @author Wang926454
//     * @date 2018/8/30 10:42
//     */
//    @PutMapping
//    //@RequiresPermissions(logical = Logical.AND, value = {"user:edit"})
//    public ResponseBean update(@Validated(UserEditValidGroup.class) @RequestBody UserDto userDto) {
//        // 查询数据库密码
//        UserDto userDtoTemp = new UserDto();
//        userDtoTemp.setAccount(userDto.getAccount());
//        userDtoTemp = userService.selectOne(userDtoTemp);
//        if (userDtoTemp == null) {
//            throw new CustomUnauthorizedException("该帐号不存在(Account not exist.)");
//        } else {
//            userDto.setId(userDtoTemp.getId());
//        }
//        // FIXME: 如果不一样就说明用户修改了密码，重新加密密码(这个处理不太好，但是没有想到好的处理方式)
//        if (!userDtoTemp.getPassword().equals(userDto.getPassword())) {
//            // 密码以帐号+密码的形式进行AES加密
//            if (userDto.getPassword().length() > Constant.PASSWORD_MAX_LEN) {
//                throw new CustomException("密码最多8位(Password up to 8 bits.)");
//            }
//            String key = AesCipherUtil.enCrypto(userDto.getAccount() + userDto.getPassword());
//            userDto.setPassword(key);
//        }
//        int count = userService.updateByPrimaryKeySelective(userDto);
//        if (count <= 0) {
//            throw new CustomException("更新失败(Update Failure)");
//        }
//        return new ResponseBean(HttpStatus.OK.value(), "更新成功(Update Success)", userDto);
//    }
//
//    /**
//     * 删除用户
//     * @param id
//     * @return java.util.Map<java.lang.String,java.lang.Object>
//     * @author Wang926454
//     * @date 2018/8/30 10:43
//     */
//    @DeleteMapping("/{id}")
//    //@RequiresPermissions(logical = Logical.AND, value = {"user:edit"})
//    public ResponseBean delete(@PathVariable("id") Integer id) {
//        int count = userService.deleteByPrimaryKey(id);
//        if (count <= 0) {
//            throw new CustomException("删除失败，ID不存在(Deletion Failed. ID does not exist.)");
//        }
//        return new ResponseBean(HttpStatus.OK.value(), "删除成功(Delete Success)", null);
//    }
//
//    /**
//     * 剔除在线用户
//     * @param id
//     * @return com.wang.model.common.ResponseBean
//     * @author Wang926454
//     * @date 2018/9/6 10:20
//     */
//    @DeleteMapping("/online/{id}")
//    //@RequiresPermissions(logical = Logical.AND, value = {"user:edit"})
//    public ResponseBean deleteOnline(@PathVariable("id") Integer id) {
//        UserDto userDto = userService.selectByPrimaryKey(id);
//        if (JedisUtil.exists(Constant.PREFIX_SHIRO_REFRESH_TOKEN + userDto.getAccount())) {
//            if (JedisUtil.delKey(Constant.PREFIX_SHIRO_REFRESH_TOKEN + userDto.getAccount()) > 0) {
//                return new ResponseBean(HttpStatus.OK.value(), "剔除成功(Delete Success)", null);
//            }
//        }
//        throw new CustomException("剔除失败，Account不存在(Deletion Failed. Account does not exist.)");
//    }
}