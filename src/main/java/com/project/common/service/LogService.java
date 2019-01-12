package com.project.common.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.common.domain.LogDO;
import com.project.common.domain.PageDO;
import com.project.common.utils.Query;
@Service
public interface LogService {
	void save(LogDO logDO);
	PageDO<LogDO> queryList(Query query);
	int remove(Long id);
	int batchRemove(Long[] ids);
}
