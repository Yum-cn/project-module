package com.project.eps.service;

import com.project.eps.domain.UserWithdrawDO;

import java.util.List;
import java.util.Map;

/**
 * 用户提现表
 * 
 * @author Yum
 * @email wtuada@126.com
 * @date 2019-01-07 18:22:35
 */
public interface UserWithdrawService {
	
	UserWithdrawDO get(Long id);
	
	List<UserWithdrawDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(UserWithdrawDO userWithdraw);
	
	int update(UserWithdrawDO userWithdraw);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
	
    int updateStatus(Long id);
    
    int batchUpdateStatus(Long[] ids);
}
