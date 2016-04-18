package com.fjsaas.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fjsaas.web.pagination.Pager;
import com.fjsaas.web.bean.OperateLog;
import com.fjsaas.web.dao.OperateLogDao;
import com.fjsaas.web.query.OperateLogQuery;
import com.fjsaas.web.service.OperateLogService;


@Service
public class OperateLogServiceImpl implements OperateLogService {

	@Resource
	OperateLogDao operateLogDao;

	/**
	 * 插入数据库
	 * 
	 * @return
	 */
	public Integer addOperateLog(OperateLog operateLog) {
		return operateLogDao.addOperateLog(operateLog);
	}

	/**
	 * 根据主键查找
	 */
	public OperateLog getOperateLogByKey(Integer id) {
		return operateLogDao.getOperateLogByKey(id);
	}
	
	public List<OperateLog> getOperateLogsByKeys(List<Integer> idList) {
		return operateLogDao.getOperateLogsByKeys(idList);
	}

	/**
	 * 根据主键删除
	 * 
	 * @return
	 */
	public Integer deleteByKey(Integer id) {
		return operateLogDao.deleteByKey(id);
	}

	public Integer deleteByKeys(List<Integer> idList) {
		return operateLogDao.deleteByKeys(idList);
	}

	/**
	 * 根据主键更新
	 * 
	 * @return
	 */
	public Integer updateOperateLogByKey(OperateLog operateLog) {
		return operateLogDao.updateOperateLogByKey(operateLog);
	}
	
	public Pager getOperateLogListWithPage(OperateLogQuery operateLogQuery) {
		Pager p = new Pager(operateLogQuery.getPageNo(),operateLogQuery.getPageSize(),operateLogDao.getOperateLogListCount(operateLogQuery));
		p.setList(operateLogDao.getOperateLogListWithPage(operateLogQuery));
		return p;
	}
	
	public List<OperateLog> getOperateLogList(OperateLogQuery operateLogQuery) {
		return operateLogDao.getOperateLogList(operateLogQuery);
	}
}
