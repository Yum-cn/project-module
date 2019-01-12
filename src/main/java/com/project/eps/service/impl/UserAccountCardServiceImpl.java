package com.project.eps.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.project.eps.dao.UserAccountCardDao;
import com.project.eps.domain.UserAccountCardDO;
import com.project.eps.service.UserAccountCardService;



@Service
public class UserAccountCardServiceImpl implements UserAccountCardService {
	@Autowired
	private UserAccountCardDao userAccountCardDao;
	
	@Override
	public UserAccountCardDO get(Long id){
		return userAccountCardDao.get(id);
	}
	
	@Override
	public List<UserAccountCardDO> list(Map<String, Object> map){
		return userAccountCardDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return userAccountCardDao.count(map);
	}
	
	@Override
	public int save(UserAccountCardDO userAccountCard){
		return userAccountCardDao.save(userAccountCard);
	}
	
	@Override
	public int update(UserAccountCardDO userAccountCard){
		return userAccountCardDao.update(userAccountCard);
	}
	
	@Override
	public int remove(Long id){
		return userAccountCardDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return userAccountCardDao.batchRemove(ids);
	}
	
	   
    @Override
    public int updateStatus(Long id){
        return userAccountCardDao.updateStatus(id);
    }
    
    @Override
    public int batchUpdateStatus(Long[] ids){
        return userAccountCardDao.batchUpdateStatus(ids);
    }
}
