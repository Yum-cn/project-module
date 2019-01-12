package com.project.eps.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.common.constant.CommonEnum;
import com.common.id.IdWorker;
import com.project.app.util.AesCipherUtil;
import com.project.eps.dao.AppUserDao;
import com.project.eps.dao.UserInfoDao;
import com.project.eps.domain.AppUserDO;
import com.project.eps.domain.AppUserVO;
import com.project.eps.domain.UserInfoDO;
import com.project.eps.service.AppUserService;

import net.sf.json.JSONObject;



@Service
public class AppUserServiceImpl implements AppUserService {
	@Autowired
	private AppUserDao appUserDao;
	@Autowired
	private UserInfoDao userInfoDao;
	
	@Override
	public AppUserDO get(Long id){
		return appUserDao.get(id);
	}
	
	@Override
	public List<AppUserDO> list(Map<String, Object> map){
		return appUserDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return appUserDao.count(map);
	}
	
	@Override
	public int save(AppUserDO masterUser){
		return appUserDao.save(masterUser);
	}
	
	@Override
	public int update(AppUserDO masterUser){
		return appUserDao.update(masterUser);
	}
	
	@Override
	public int remove(Long id){
		return appUserDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return appUserDao.batchRemove(ids);
	}
	
	   
    @Override
    public int updateStatus(Long id){
        return appUserDao.updateStatus(id);
    }
    
    @Override
    public int batchUpdateStatus(Long[] ids){
        return appUserDao.batchUpdateStatus(ids);
    }

	@Override
	public AppUserDO selectUser(AppUserDO bean) {
		return appUserDao.selectUser(bean);
	}

	IdWorker idWorker = new IdWorker(1);
	@Override
	public AppUserVO registerUser(JSONObject body) {
		
		AppUserDO appUser = new AppUserDO();
		appUser.setId(idWorker.nextId());
		appUser.setCountryCode(body.optString("country_code"));
		appUser.setUsername(body.optString("username"));
		appUser.setRegisterTime(System.currentTimeMillis()/1000);
		String key = AesCipherUtil.enCrypto(body.optString("username") + body.optString("password"));
		appUser.setPassword(key);
		appUser.setStatus(CommonEnum.STATUS.ONE.value);
		appUserDao.save(appUser);
		
		UserInfoDO userInfo = new UserInfoDO();
		userInfo.setId(idWorker.nextId());
		userInfo.setUserId(appUser.getId());
		userInfo.setPhone(body.optString("username"));
		userInfo.setStatus(CommonEnum.STATUS.ONE.value);
		userInfo.setCreateTime(System.currentTimeMillis()/1000);
		userInfoDao.save(userInfo);

		AppUserVO userVO = new AppUserVO();
		userVO.setUser_id(appUser.getId());
		userVO.setCountry_code(body.optString("country_code"));
		userVO.setUsername(body.optString("username"));
		userVO.setRegister_time(appUser.getRegisterTime());
		userVO.setPhone(body.optString("username"));

		return userVO;
	}

}
