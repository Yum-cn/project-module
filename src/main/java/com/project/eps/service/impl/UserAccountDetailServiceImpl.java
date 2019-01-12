package com.project.eps.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.project.eps.dao.UserAccountDetailDao;
import com.project.eps.domain.UserAccountDetailDO;
import com.project.eps.service.UserAccountDetailService;



@Service
public class UserAccountDetailServiceImpl implements UserAccountDetailService {
	@Autowired
	private UserAccountDetailDao userAccountDetailDao;
	
	@Override
	public UserAccountDetailDO get(Long id){
		return userAccountDetailDao.get(id);
	}
	
	@Override
	public List<UserAccountDetailDO> list(Map<String, Object> map){
		return userAccountDetailDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return userAccountDetailDao.count(map);
	}
	
	@Override
	public int save(UserAccountDetailDO userAccountDetail){
		return userAccountDetailDao.save(userAccountDetail);
	}
	
	@Override
	public int update(UserAccountDetailDO userAccountDetail){
		return userAccountDetailDao.update(userAccountDetail);
	}
	
	@Override
	public int remove(Long id){
		return userAccountDetailDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return userAccountDetailDao.batchRemove(ids);
	}
	
	   
    @Override
    public int updateStatus(Long id){
        return userAccountDetailDao.updateStatus(id);
    }
    
    @Override
    public int batchUpdateStatus(Long[] ids){
        return userAccountDetailDao.batchUpdateStatus(ids);
    }
}
