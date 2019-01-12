package com.project.eps.service;

import com.project.eps.domain.OrderDetailDO;

import java.util.List;
import java.util.Map;

/**
 * 订单明细表
 * 
 * @author Yum
 * @email wtuada@126.com
 * @date 2019-01-07 18:22:34
 */
public interface OrderDetailService {
	
	OrderDetailDO get(Long id);
	
	List<OrderDetailDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(OrderDetailDO orderDetail);
	
	int update(OrderDetailDO orderDetail);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
	
    int updateStatus(Long id);
    
    int batchUpdateStatus(Long[] ids);
}
