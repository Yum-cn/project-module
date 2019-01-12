package com.project.eps.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.project.eps.dao.ApiPlaceDao;
import com.project.eps.domain.ApiPlaceDO;
import com.project.eps.service.ApiPlaceService;



@Service
public class ApiPlaceServiceImpl implements ApiPlaceService {
	@Autowired
	private ApiPlaceDao apiPlaceDao;
	
	@Override
	public ApiPlaceDO get(Long id){
		return apiPlaceDao.get(id);
	}
	
	@Override
	public List<ApiPlaceDO> list(Map<String, Object> map){
		return apiPlaceDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return apiPlaceDao.count(map);
	}
	
	@Override
	public int save(ApiPlaceDO apiPlace){
		return apiPlaceDao.save(apiPlace);
	}
	
	@Override
	public int update(ApiPlaceDO apiPlace){
		return apiPlaceDao.update(apiPlace);
	}
	
	@Override
	public int remove(Long id){
		return apiPlaceDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return apiPlaceDao.batchRemove(ids);
	}
	
	   
    @Override
    public int updateStatus(Long id){
        return apiPlaceDao.updateStatus(id);
    }
    
    @Override
    public int batchUpdateStatus(Long[] ids){
        return apiPlaceDao.batchUpdateStatus(ids);
    }
}
