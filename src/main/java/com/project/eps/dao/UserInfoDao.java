package com.project.eps.dao;

import com.project.eps.domain.UserInfoDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 用户扩展信息表
 * @author Yum
 * @email wtuada@126.com
 * @date 2019-01-07 18:22:34
 */
@Mapper
public interface UserInfoDao {

	UserInfoDO get(Long id);
	
	List<UserInfoDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(UserInfoDO userInfo);
	
	int update(UserInfoDO userInfo);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
	
	int updateStatus(Long id);
	
	int batchUpdateStatus(Long[] ids);
}
