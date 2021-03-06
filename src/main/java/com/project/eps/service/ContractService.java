package com.project.eps.service;

import com.project.eps.domain.ContractDO;

import java.util.List;
import java.util.Map;

/**
 * 合同表
 * 
 * @author Yum
 * @email wtuada@126.com
 * @date 2019-01-07 18:22:33
 */
public interface ContractService {
	
	ContractDO get(Long id);
	
	List<ContractDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ContractDO contract);
	
	int update(ContractDO contract);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
	
    int updateStatus(Long id);
    
    int batchUpdateStatus(Long[] ids);
}
