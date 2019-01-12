package com.project.eps.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.project.eps.dao.UserInfoDao;
import com.project.eps.domain.UserInfoDO;
import com.project.eps.service.UserInfoService;



@Service
public class UserInfoServiceImpl implements UserInfoService {
	@Autowired
	private UserInfoDao userInfoDao;
	
	@Override
	public UserInfoDO get(Long id){
		return userInfoDao.get(id);
	}
	
	@Override
	public List<UserInfoDO> list(Map<String, Object> map){
		return userInfoDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return userInfoDao.count(map);
	}
	
	@Override
	public int save(UserInfoDO userInfo){
		return userInfoDao.save(userInfo);
	}
	
	@Override
	public int update(UserInfoDO userInfo){
		return userInfoDao.update(userInfo);
	}
	
	@Override
	public int remove(Long id){
		return userInfoDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return userInfoDao.batchRemove(ids);
	}
	
	   
    @Override
    public int updateStatus(Long id){
        return userInfoDao.updateStatus(id);
    }
    
    @Override
    public int batchUpdateStatus(Long[] ids){
        return userInfoDao.batchUpdateStatus(ids);
    }
}
