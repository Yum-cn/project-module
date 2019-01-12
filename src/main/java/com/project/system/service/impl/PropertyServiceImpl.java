package com.project.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.system.dao.PropertyDao;
import com.project.system.domain.PropertyDO;
import com.project.system.service.PropertyService;

import java.util.List;
import java.util.Map;



@Service
public class PropertyServiceImpl implements PropertyService {
	@Autowired
	private PropertyDao propertyDao;
	
	@Override
	public PropertyDO get(Long id){
		return propertyDao.get(id);
	}
	
	@Override
	public List<PropertyDO> list(Map<String, Object> map){
		return propertyDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return propertyDao.count(map);
	}
	
	@Override
	public int save(PropertyDO property){
		return propertyDao.save(property);
	}
	
	@Override
	public int update(PropertyDO property){
		return propertyDao.update(property);
	}
	
	@Override
	public int remove(Long id){
		return propertyDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return propertyDao.batchRemove(ids);
	}
	
	   
    @Override
    public int updateStatus(Long id){
        return propertyDao.updateStatus(id);
    }
    
    @Override
    public int batchUpdateStatus(Long[] ids){
        return propertyDao.batchUpdateStatus(ids);
    }
}
