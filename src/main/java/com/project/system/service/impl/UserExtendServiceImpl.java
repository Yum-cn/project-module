package com.project.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.system.dao.UserExtendDao;
import com.project.system.domain.UserExtendDO;
import com.project.system.service.UserExtendService;

import java.util.List;
import java.util.Map;



@Service
public class UserExtendServiceImpl implements UserExtendService {
	@Autowired
	private UserExtendDao userExtendDao;
	
	@Override
	public UserExtendDO get(Long id){
		return userExtendDao.get(id);
	}
	
	@Override
	public List<UserExtendDO> list(Map<String, Object> map){
		return userExtendDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return userExtendDao.count(map);
	}
	
	@Override
	public int save(UserExtendDO userExtend){
		return userExtendDao.save(userExtend);
	}
	
	@Override
	public int update(UserExtendDO userExtend){
		return userExtendDao.update(userExtend);
	}
	
	@Override
	public int remove(Long id){
		return userExtendDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return userExtendDao.batchRemove(ids);
	}
	
	   
    @Override
    public int updateStatus(Long id){
        return userExtendDao.updateStatus(id);
    }
    
    @Override
    public int batchUpdateStatus(Long[] ids){
        return userExtendDao.batchUpdateStatus(ids);
    }
}
