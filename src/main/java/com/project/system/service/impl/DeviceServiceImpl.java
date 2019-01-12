package com.project.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.common.dao.DictDao;
import com.project.common.domain.DictDO;
import com.project.common.domain.Tree;
import com.project.common.utils.BuildTree;
import com.project.system.dao.DeviceDao;
import com.project.system.domain.DeviceDO;
import com.project.system.service.DeviceService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



@Service
public class DeviceServiceImpl implements DeviceService {
	@Autowired
	private DeviceDao deviceDao;
	@Autowired
    private DictDao dictDao;
	
	@Override
	public DeviceDO get(Long id){
		return deviceDao.get(id);
	}
	
	@Override
	public List<DeviceDO> list(Map<String, Object> map){
		return deviceDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return deviceDao.count(map);
	}
	
	@Override
	public int save(DeviceDO device){
		return deviceDao.save(device);
	}
	
	@Override
	public int update(DeviceDO device){
		return deviceDao.update(device);
	}
	
	@Override
	public int remove(Long id){
		return deviceDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return deviceDao.batchRemove(ids);
	}
	
	   
    @Override
    public int updateStatus(Long id){
        return deviceDao.updateStatus(id);
    }
    
    @Override
    public int batchUpdateStatus(Long[] ids){
        return deviceDao.batchUpdateStatus(ids);
    }

	@Override
	public Tree<DictDO> getTree(Map<String, Object> map) {
		List<Tree<DictDO>> trees = new ArrayList<Tree<DictDO>>();
		List<DictDO> dicts = dictDao.list(map);
		for (DictDO dict : dicts) {
			Tree<DictDO> tree = new Tree<DictDO>();
			tree.setId(String.valueOf(dict.getId()));
			tree.setParentId(null);
			tree.setText(dict.getName());
			Map<String, Object> state = new HashMap<>(16);
			state.put("opened", true);
			tree.setState(state);
			trees.add(tree);
		}
		// 默认顶级菜单为０，根据数据库实际情况调整
		Tree<DictDO> t = BuildTree.build(trees);
		return t;
	}
}
