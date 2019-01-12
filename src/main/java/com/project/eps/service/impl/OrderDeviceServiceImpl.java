package com.project.eps.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.project.eps.dao.OrderDeviceDao;
import com.project.eps.domain.OrderDeviceDO;
import com.project.eps.service.OrderDeviceService;



@Service
public class OrderDeviceServiceImpl implements OrderDeviceService {
	@Autowired
	private OrderDeviceDao orderDeviceDao;
	
	@Override
	public OrderDeviceDO get(Long id){
		return orderDeviceDao.get(id);
	}
	
	@Override
	public List<OrderDeviceDO> list(Map<String, Object> map){
		return orderDeviceDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return orderDeviceDao.count(map);
	}
	
	@Override
	public int save(OrderDeviceDO orderDevice){
		return orderDeviceDao.save(orderDevice);
	}
	
	@Override
	public int update(OrderDeviceDO orderDevice){
		return orderDeviceDao.update(orderDevice);
	}
	
	@Override
	public int remove(Long id){
		return orderDeviceDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return orderDeviceDao.batchRemove(ids);
	}
	
	   
    @Override
    public int updateStatus(Long id){
        return orderDeviceDao.updateStatus(id);
    }
    
    @Override
    public int batchUpdateStatus(Long[] ids){
        return orderDeviceDao.batchUpdateStatus(ids);
    }
}
