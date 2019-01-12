package com.project.eps.dao;

import com.project.eps.domain.UserAccountDetailDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 用户账户明细表
 * @author Yum
 * @email wtuada@126.com
 * @date 2019-01-07 18:22:34
 */
@Mapper
public interface UserAccountDetailDao {

	UserAccountDetailDO get(Long id);
	
	List<UserAccountDetailDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(UserAccountDetailDO userAccountDetail);
	
	int update(UserAccountDetailDO userAccountDetail);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
	
	int updateStatus(Long id);
	
	int batchUpdateStatus(Long[] ids);
}
