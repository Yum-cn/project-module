package com.project.eps.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.project.eps.dao.OrderDetailDao;
import com.project.eps.domain.OrderDetailDO;
import com.project.eps.service.OrderDetailService;



@Service
public class OrderDetailServiceImpl implements OrderDetailService {
	@Autowired
	private OrderDetailDao orderDetailDao;
	
	@Override
	public OrderDetailDO get(Long id){
		return orderDetailDao.get(id);
	}
	
	@Override
	public List<OrderDetailDO> list(Map<String, Object> map){
		return orderDetailDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return orderDetailDao.count(map);
	}
	
	@Override
	public int save(OrderDetailDO orderDetail){
		return orderDetailDao.save(orderDetail);
	}
	
	@Override
	public int update(OrderDetailDO orderDetail){
		return orderDetailDao.update(orderDetail);
	}
	
	@Override
	public int remove(Long id){
		return orderDetailDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return orderDetailDao.batchRemove(ids);
	}
	
	   
    @Override
    public int updateStatus(Long id){
        return orderDetailDao.updateStatus(id);
    }
    
    @Override
    public int batchUpdateStatus(Long[] ids){
        return orderDetailDao.batchUpdateStatus(ids);
    }
}
