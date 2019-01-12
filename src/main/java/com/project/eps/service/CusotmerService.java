package com.project.eps.service;

import com.project.eps.domain.CusotmerDO;

import java.util.List;
import java.util.Map;

/**
 * 客户信息表
 * 
 * @author Yum
 * @email wtuada@126.com
 * @date 2019-01-07 18:22:33
 */
public interface CusotmerService {
	
	CusotmerDO get(Long id);
	
	List<CusotmerDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(CusotmerDO cusotmer);
	
	int update(CusotmerDO cusotmer);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
	
    int updateStatus(Long id);
    
    int batchUpdateStatus(Long[] ids);
}
