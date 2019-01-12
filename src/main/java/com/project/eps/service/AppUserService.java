package com.project.eps.service;

import java.util.List;
import java.util.Map;

import com.project.eps.domain.AppUserDO;
import com.project.eps.domain.AppUserVO;

import net.sf.json.JSONObject;

/**
 * 主用户表
 * 
 * @author Yum
 * @email wtuada@126.com
 * @date 2019-01-07 18:22:34
 */
public interface AppUserService {
	
	AppUserDO get(Long id);
	
	List<AppUserDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(AppUserDO masterUser);
	
	int update(AppUserDO masterUser);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
	
    int updateStatus(Long id);
    
    int batchUpdateStatus(Long[] ids);
    
    AppUserDO selectUser(AppUserDO bean);

	AppUserVO registerUser(JSONObject body);
}
