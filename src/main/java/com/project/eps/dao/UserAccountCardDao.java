package com.project.eps.dao;

import com.project.eps.domain.UserAccountCardDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 用户账户卡号表
 * @author Yum
 * @email wtuada@126.com
 * @date 2019-01-07 18:22:34
 */
@Mapper
public interface UserAccountCardDao {

	UserAccountCardDO get(Long id);
	
	List<UserAccountCardDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(UserAccountCardDO userAccountCard);
	
	int update(UserAccountCardDO userAccountCard);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
	
	int updateStatus(Long id);
	
	int batchUpdateStatus(Long[] ids);
}
