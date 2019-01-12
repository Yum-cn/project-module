package com.project.system.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.project.system.domain.ServerConfigDO;

/**
 * 服务配置表
 * @author Yum
 * @email wtuada@126.com
 * @date 2018-08-07 15:22:38
 */
@Mapper
public interface ServerConfigDao {

	ServerConfigDO get(Long id);
	
	List<ServerConfigDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(ServerConfigDO serverConfig);
	
	int update(ServerConfigDO serverConfig);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
	
	int updateStatus(Long id);
	
	int batchUpdateStatus(Long[] ids);
}
