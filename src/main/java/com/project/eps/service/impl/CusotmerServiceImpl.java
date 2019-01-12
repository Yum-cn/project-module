package com.project.eps.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.project.eps.dao.CusotmerDao;
import com.project.eps.domain.CusotmerDO;
import com.project.eps.service.CusotmerService;



@Service
public class CusotmerServiceImpl implements CusotmerService {
	@Autowired
	private CusotmerDao cusotmerDao;
	
	@Override
	public CusotmerDO get(Long id){
		return cusotmerDao.get(id);
	}
	
	@Override
	public List<CusotmerDO> list(Map<String, Object> map){
		return cusotmerDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return cusotmerDao.count(map);
	}
	
	@Override
	public int save(CusotmerDO cusotmer){
		return cusotmerDao.save(cusotmer);
	}
	
	@Override
	public int update(CusotmerDO cusotmer){
		return cusotmerDao.update(cusotmer);
	}
	
	@Override
	public int remove(Long id){
		return cusotmerDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return cusotmerDao.batchRemove(ids);
	}
	
	   
    @Override
    public int updateStatus(Long id){
        return cusotmerDao.updateStatus(id);
    }
    
    @Override
    public int batchUpdateStatus(Long[] ids){
        return cusotmerDao.batchUpdateStatus(ids);
    }
}
