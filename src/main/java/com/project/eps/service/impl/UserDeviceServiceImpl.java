package com.project.eps.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.project.eps.dao.UserDeviceDao;
import com.project.eps.domain.UserDeviceDO;
import com.project.eps.service.UserDeviceService;



@Service
public class UserDeviceServiceImpl implements UserDeviceService {
	@Autowired
	private UserDeviceDao userDeviceDao;
	
	@Override
	public UserDeviceDO get(Long id){
		return userDeviceDao.get(id);
	}
	
	@Override
	public List<UserDeviceDO> list(Map<String, Object> map){
		return userDeviceDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return userDeviceDao.count(map);
	}
	
	@Override
	public int save(UserDeviceDO userDevice){
		return userDeviceDao.save(userDevice);
	}
	
	@Override
	public int update(UserDeviceDO userDevice){
		return userDeviceDao.update(userDevice);
	}
	
	@Override
	public int remove(Long id){
		return userDeviceDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return userDeviceDao.batchRemove(ids);
	}
	
	   
    @Override
    public int updateStatus(Long id){
        return userDeviceDao.updateStatus(id);
    }
    
    @Override
    public int batchUpdateStatus(Long[] ids){
        return userDeviceDao.batchUpdateStatus(ids);
    }
}
