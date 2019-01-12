package com.project.eps.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.project.eps.domain.AppUserDO;
import com.project.eps.domain.AppUserDTO;

/**
 * 主用户表
 * @author Yum
 * @email wtuada@126.com
 * @date 2019-01-07 18:22:34
 */
@Mapper
public interface AppUserDao {

	AppUserDO get(Long id);
	
	List<AppUserDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(AppUserDO masterUser);
	
	int update(AppUserDO masterUser);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
	
	int updateStatus(Long id);
	
	int batchUpdateStatus(Long[] ids);
	
	AppUserDO selectUser(AppUserDO bean);
}
