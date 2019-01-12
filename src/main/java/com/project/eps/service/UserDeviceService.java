package com.project.eps.service;

import com.project.eps.domain.UserDeviceDO;

import java.util.List;
import java.util.Map;

/**
 * 用户设备表
 * 
 * @author Yum
 * @email wtuada@126.com
 * @date 2019-01-07 18:22:34
 */
public interface UserDeviceService {
	
	UserDeviceDO get(Long id);
	
	List<UserDeviceDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(UserDeviceDO userDevice);
	
	int update(UserDeviceDO userDevice);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
	
    int updateStatus(Long id);
    
    int batchUpdateStatus(Long[] ids);
}
