package com.project.eps.dao;

import com.project.eps.domain.CusotmerDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 客户信息表
 * @author Yum
 * @email wtuada@126.com
 * @date 2019-01-07 18:22:33
 */
@Mapper
public interface CusotmerDao {

	CusotmerDO get(Long id);
	
	List<CusotmerDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(CusotmerDO cusotmer);
	
	int update(CusotmerDO cusotmer);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
	
	int updateStatus(Long id);
	
	int batchUpdateStatus(Long[] ids);
}
