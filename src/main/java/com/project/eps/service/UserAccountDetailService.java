package com.project.eps.service;

import com.project.eps.domain.UserAccountDetailDO;

import java.util.List;
import java.util.Map;

/**
 * 用户账户明细表
 * 
 * @author Yum
 * @email wtuada@126.com
 * @date 2019-01-07 18:22:34
 */
public interface UserAccountDetailService {
	
	UserAccountDetailDO get(Long id);
	
	List<UserAccountDetailDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(UserAccountDetailDO userAccountDetail);
	
	int update(UserAccountDetailDO userAccountDetail);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
	
    int updateStatus(Long id);
    
    int batchUpdateStatus(Long[] ids);
}
