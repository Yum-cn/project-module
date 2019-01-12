package com.project.eps.service;

import com.project.eps.domain.OrderDeviceDO;

import java.util.List;
import java.util.Map;

/**
 * 订单设备关系表
 * 
 * @author Yum
 * @email wtuada@126.com
 * @date 2019-01-07 18:22:34
 */
public interface OrderDeviceService {
	
	OrderDeviceDO get(Long id);
	
	List<OrderDeviceDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(OrderDeviceDO orderDevice);
	
	int update(OrderDeviceDO orderDevice);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
	
    int updateStatus(Long id);
    
    int batchUpdateStatus(Long[] ids);
}
