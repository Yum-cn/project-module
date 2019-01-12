package com.project.eps.dao;

import com.project.eps.domain.UserDeviceDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 用户设备表
 * @author Yum
 * @email wtuada@126.com
 * @date 2019-01-07 18:22:34
 */
@Mapper
public interface UserDeviceDao {

	UserDeviceDO get(Long id);
	
	List<UserDeviceDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(UserDeviceDO userDevice);
	
	int update(UserDeviceDO userDevice);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
	
	int updateStatus(Long id);
	
	int batchUpdateStatus(Long[] ids);
}
