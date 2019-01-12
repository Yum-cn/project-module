package com.project.system.shiro;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.math.NumberUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.project.app.config.shiro.jwt.JwtToken;
import com.project.app.model.common.Constant;
import com.project.app.util.JedisUtil;
import com.project.app.util.JwtUtil;
import com.project.app.util.common.StringUtil;
import com.project.common.config.ApplicationContextRegister;
import com.project.common.utils.ShiroUtils;
import com.project.eps.domain.AppUserDO;
import com.project.eps.service.AppUserService;
import com.project.system.dao.UserDao;
import com.project.system.domain.UserDO;
import com.project.system.service.MenuService;

public class UserRealm extends AuthorizingRealm {
/*	@Autowired
	UserDao userMapper;
	@Autowired
	MenuService menuService;*/
	@Autowired
	private AppUserService appUserService;
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		Long userId = ShiroUtils.getUserId();
		MenuService menuService = ApplicationContextRegister.getBean(MenuService.class);
		Set<String> perms = menuService.listPerms(userId);
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.setStringPermissions(perms);
		return info;
	}
	
	/**
     * 大坑，必须重写此方法，不然Shiro会报错
     */
    @Override
    public boolean supports(AuthenticationToken token) {
    	
    	if(token instanceof JwtToken ||token instanceof UsernamePasswordToken){
    		return true;
    	}
    	
        return token instanceof JwtToken;
    }

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken auth) throws AuthenticationException {
		
		if(auth instanceof JwtToken){
			String token = (String) auth.getCredentials();
	        // 解密获得account，用于和数据库进行对比
	        String account = JwtUtil.getClaim(token, Constant.ACCOUNT);
	        // 帐号为空
	        if (StringUtil.isBlank(account)) {
	            throw new AuthenticationException("Token中帐号为空(The account in Token is empty.)");
	        }
	        // 查询用户是否存在
	        long userId = NumberUtils.toLong(account);
	        if(userId < 0){
	        	throw new AuthenticationException("该帐号不存在(The account does not exist.)");
	        }
	        
			AppUserDO appUser = appUserService.get(userId);
			if(appUser == null){
				throw new AuthenticationException("该帐号不存在(The account does not exist.)");
			}
	        // 开始认证，要AccessToken认证通过，且Redis中存在RefreshToken，且两个Token时间戳一致
	        if (JwtUtil.verify(token) && JedisUtil.exists(Constant.PREFIX_SHIRO_REFRESH_TOKEN + account)) {
	            // 获取RefreshToken的时间戳
	            String currentTimeMillisRedis = JedisUtil.getObject(Constant.PREFIX_SHIRO_REFRESH_TOKEN + account).toString();
	            // 获取AccessToken时间戳，与RefreshToken的时间戳对比
	            if (JwtUtil.getClaim(token, Constant.CURRENT_TIME_MILLIS).equals(currentTimeMillisRedis)) {
	                return new SimpleAuthenticationInfo(token, token, "userRealm");
	            }
	        }
	        throw new AuthenticationException("Token已过期(Token expired or incorrect.)");
    	}else{
    		String username = (String) auth.getPrincipal();
    		Map<String, Object> map = new HashMap<>(16);
    		map.put("username", username);
    		String password = new String((char[]) auth.getCredentials());

    		UserDao userMapper = ApplicationContextRegister.getBean(UserDao.class);
    		// 查询用户信息
    		UserDO user = userMapper.list(map).get(0);

    		// 账号不存在
    		if (user == null) {
    			throw new UnknownAccountException("账号或密码不正确");
    		}

    		// 密码错误
    		if (!password.equals(user.getPassword())) {
    			throw new IncorrectCredentialsException("账号或密码不正确");
    		}

    		// 账号锁定
    		if (user.getStatus() == 0) {
    			throw new LockedAccountException("账号已被锁定,请联系管理员");
    		}
    		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, password, getName());
    		return info;
    	}
		
	}

}
