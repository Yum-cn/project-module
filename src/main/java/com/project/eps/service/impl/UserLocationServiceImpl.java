package com.project.eps.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.project.eps.dao.UserLocationDao;
import com.project.eps.domain.UserLocationDO;
import com.project.eps.service.UserLocationService;



@Service
public class UserLocationServiceImpl implements UserLocationService {
	@Autowired
	private UserLocationDao userLocationDao;
	
	@Override
	public UserLocationDO get(Long id){
		return userLocationDao.get(id);
	}
	
	@Override
	public List<UserLocationDO> list(Map<String, Object> map){
		return userLocationDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return userLocationDao.count(map);
	}
	
	@Override
	public int save(UserLocationDO userLocation){
		return userLocationDao.save(userLocation);
	}
	
	@Override
	public int update(UserLocationDO userLocation){
		return userLocationDao.update(userLocation);
	}
	
	@Override
	public int remove(Long id){
		return userLocationDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return userLocationDao.batchRemove(ids);
	}
	
	   
    @Override
    public int updateStatus(Long id){
        return userLocationDao.updateStatus(id);
    }
    
    @Override
    public int batchUpdateStatus(Long[] ids){
        return userLocationDao.batchUpdateStatus(ids);
    }
}
