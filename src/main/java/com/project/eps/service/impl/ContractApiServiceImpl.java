package com.project.eps.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.project.eps.dao.ContractApiDao;
import com.project.eps.domain.ContractApiDO;
import com.project.eps.service.ContractApiService;



@Service
public class ContractApiServiceImpl implements ContractApiService {
	@Autowired
	private ContractApiDao contractApiDao;
	
	@Override
	public ContractApiDO get(Long id){
		return contractApiDao.get(id);
	}
	
	@Override
	public List<ContractApiDO> list(Map<String, Object> map){
		return contractApiDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return contractApiDao.count(map);
	}
	
	@Override
	public int save(ContractApiDO contractApi){
		return contractApiDao.save(contractApi);
	}
	
	@Override
	public int update(ContractApiDO contractApi){
		return contractApiDao.update(contractApi);
	}
	
	@Override
	public int remove(Long id){
		return contractApiDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return contractApiDao.batchRemove(ids);
	}
	
	   
    @Override
    public int updateStatus(Long id){
        return contractApiDao.updateStatus(id);
    }
    
    @Override
    public int batchUpdateStatus(Long[] ids){
        return contractApiDao.batchUpdateStatus(ids);
    }
}
