package com.project.system.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.project.system.domain.UserExtendDO;

/**
 * 用户扩展表
 * @author Yum
 * @email wtuada@126.com
 * @date 2018-08-04 17:55:57
 */
@Mapper
public interface UserExtendDao {

	UserExtendDO get(Long id);
	
	List<UserExtendDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(UserExtendDO userExtend);
	
	int update(UserExtendDO userExtend);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
	
	int updateStatus(Long id);
	
	int batchUpdateStatus(Long[] ids);
}
