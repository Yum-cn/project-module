package com.project.eps.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.project.eps.dao.ContractDao;
import com.project.eps.domain.ContractDO;
import com.project.eps.service.ContractService;



@Service
public class ContractServiceImpl implements ContractService {
	@Autowired
	private ContractDao contractDao;
	
	@Override
	public ContractDO get(Long id){
		return contractDao.get(id);
	}
	
	@Override
	public List<ContractDO> list(Map<String, Object> map){
		return contractDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return contractDao.count(map);
	}
	
	@Override
	public int save(ContractDO contract){
		return contractDao.save(contract);
	}
	
	@Override
	public int update(ContractDO contract){
		return contractDao.update(contract);
	}
	
	@Override
	public int remove(Long id){
		return contractDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return contractDao.batchRemove(ids);
	}
	
	   
    @Override
    public int updateStatus(Long id){
        return contractDao.updateStatus(id);
    }
    
    @Override
    public int batchUpdateStatus(Long[] ids){
        return contractDao.batchUpdateStatus(ids);
    }
}
