package com.project.eps.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.project.eps.dao.UserWithdrawDao;
import com.project.eps.domain.UserWithdrawDO;
import com.project.eps.service.UserWithdrawService;



@Service
public class UserWithdrawServiceImpl implements UserWithdrawService {
	@Autowired
	private UserWithdrawDao userWithdrawDao;
	
	@Override
	public UserWithdrawDO get(Long id){
		return userWithdrawDao.get(id);
	}
	
	@Override
	public List<UserWithdrawDO> list(Map<String, Object> map){
		return userWithdrawDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return userWithdrawDao.count(map);
	}
	
	@Override
	public int save(UserWithdrawDO userWithdraw){
		return userWithdrawDao.save(userWithdraw);
	}
	
	@Override
	public int update(UserWithdrawDO userWithdraw){
		return userWithdrawDao.update(userWithdraw);
	}
	
	@Override
	public int remove(Long id){
		return userWithdrawDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return userWithdrawDao.batchRemove(ids);
	}
	
	   
    @Override
    public int updateStatus(Long id){
        return userWithdrawDao.updateStatus(id);
    }
    
    @Override
    public int batchUpdateStatus(Long[] ids){
        return userWithdrawDao.batchUpdateStatus(ids);
    }
}
