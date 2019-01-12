package com.project.eps.dao;

import com.project.eps.domain.ApiPlaceDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * API点表
 * @author Yum
 * @email wtuada@126.com
 * @date 2019-01-07 18:22:33
 */
@Mapper
public interface ApiPlaceDao {

	ApiPlaceDO get(Long id);
	
	List<ApiPlaceDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(ApiPlaceDO apiPlace);
	
	int update(ApiPlaceDO apiPlace);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
	
	int updateStatus(Long id);
	
	int batchUpdateStatus(Long[] ids);
}
