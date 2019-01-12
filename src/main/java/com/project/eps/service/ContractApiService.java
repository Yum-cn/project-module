package com.project.eps.service;

import com.project.eps.domain.ContractApiDO;

import java.util.List;
import java.util.Map;

/**
 * 合同API表
 * 
 * @author Yum
 * @email wtuada@126.com
 * @date 2019-01-07 18:22:33
 */
public interface ContractApiService {
	
	ContractApiDO get(Long id);
	
	List<ContractApiDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ContractApiDO contractApi);
	
	int update(ContractApiDO contractApi);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
	
    int updateStatus(Long id);
    
    int batchUpdateStatus(Long[] ids);
}
