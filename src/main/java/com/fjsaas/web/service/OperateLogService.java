package com.fjsaas.web.service;

import java.util.List;

import com.fjsaas.web.pagination.Pager;
import com.fjsaas.web.bean.OperateLog;
import com.fjsaas.web.query.OperateLogQuery;


public interface OperateLogService {
	/**
	 * 基本插入
	 * 
	 * @return
	 */
	public Integer addOperateLog(OperateLog operateLog);

	/**
	 * 根据主键查询
	 */
	public OperateLog getOperateLogByKey(Integer id);

	/**
	 * 根据主键批量查询
	 */
	public List<OperateLog> getOperateLogsByKeys(List<Integer> idList);

	/**
	 * 根据主键删除
	 * 
	 * @return
	 */
	public Integer deleteByKey(Integer id);

	/**
	 * 根据主键批量删除
	 * 
	 * @return
	 */
	public Integer deleteByKeys(List<Integer> idList);

	/**
	 * 根据主键更新
	 * 
	 * @return
	 */
	public Integer updateOperateLogByKey(OperateLog operateLog);

	/**
	 * 根据条件查询分页查询
	 * 
	 * @param operateLogQuery
	 *            查询条件
	 * @return
	 */
	public Pager getOperateLogListWithPage(OperateLogQuery operateLogQuery);

	/**
	 * 根据条件查询
	 * 
	 * @param operateLogQuery
	 *            查询条件
	 * @return
	 */
	public List<OperateLog> getOperateLogList(OperateLogQuery operateLogQuery);
	
}
