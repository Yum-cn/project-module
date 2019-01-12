package com.project.eps.dao;

import com.project.eps.domain.UserLocationDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 用户位置表
 * @author Yum
 * @email wtuada@126.com
 * @date 2019-01-07 18:22:35
 */
@Mapper
public interface UserLocationDao {

	UserLocationDO get(Long id);
	
	List<UserLocationDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(UserLocationDO userLocation);
	
	int update(UserLocationDO userLocation);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
	
	int updateStatus(Long id);
	
	int batchUpdateStatus(Long[] ids);
}
