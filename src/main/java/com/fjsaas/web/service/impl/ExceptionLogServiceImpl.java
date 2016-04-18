package com.fjsaas.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fjsaas.web.pagination.Pager;
import com.fjsaas.web.bean.ExceptionLog;
import com.fjsaas.web.dao.ExceptionLogDao;
import com.fjsaas.web.query.ExceptionLogQuery;
import com.fjsaas.web.service.ExceptionLogService;


@Service
public class ExceptionLogServiceImpl implements ExceptionLogService {

	@Resource
	ExceptionLogDao exceptionLogDao;

	/**
	 * 插入数据库
	 * 
	 * @return
	 */
	public Integer addExceptionLog(ExceptionLog exceptionLog) {
		return exceptionLogDao.addExceptionLog(exceptionLog);
	}

	/**
	 * 根据主键查找
	 */
	public ExceptionLog getExceptionLogByKey(Integer id) {
		return exceptionLogDao.getExceptionLogByKey(id);
	}
	
	public List<ExceptionLog> getExceptionLogsByKeys(List<Integer> idList) {
		return exceptionLogDao.getExceptionLogsByKeys(idList);
	}

	/**
	 * 根据主键删除
	 * 
	 * @return
	 */
	public Integer deleteByKey(Integer id) {
		return exceptionLogDao.deleteByKey(id);
	}

	public Integer deleteByKeys(List<Integer> idList) {
		return exceptionLogDao.deleteByKeys(idList);
	}

	/**
	 * 根据主键更新
	 * 
	 * @return
	 */
	public Integer updateExceptionLogByKey(ExceptionLog exceptionLog) {
		return exceptionLogDao.updateExceptionLogByKey(exceptionLog);
	}
	
	public Pager getExceptionLogListWithPage(ExceptionLogQuery exceptionLogQuery) {
		Pager p = new Pager(exceptionLogQuery.getPageNo(),exceptionLogQuery.getPageSize(),exceptionLogDao.getExceptionLogListCount(exceptionLogQuery));
		p.setList(exceptionLogDao.getExceptionLogListWithPage(exceptionLogQuery));
		return p;
	}
	
	public List<ExceptionLog> getExceptionLogList(ExceptionLogQuery exceptionLogQuery) {
		return exceptionLogDao.getExceptionLogList(exceptionLogQuery);
	}
}
