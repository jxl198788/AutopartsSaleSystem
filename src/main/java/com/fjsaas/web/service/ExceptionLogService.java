package com.fjsaas.web.service;

import java.util.List;

import com.fjsaas.web.pagination.Pager;
import com.fjsaas.web.bean.ExceptionLog;
import com.fjsaas.web.query.ExceptionLogQuery;


public interface ExceptionLogService {
	/**
	 * 基本插入
	 * 
	 * @return
	 */
	public Integer addExceptionLog(ExceptionLog exceptionLog);

	/**
	 * 根据主键查询
	 */
	public ExceptionLog getExceptionLogByKey(Integer id);

	/**
	 * 根据主键批量查询
	 */
	public List<ExceptionLog> getExceptionLogsByKeys(List<Integer> idList);

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
	public Integer updateExceptionLogByKey(ExceptionLog exceptionLog);

	/**
	 * 根据条件查询分页查询
	 * 
	 * @param exceptionLogQuery
	 *            查询条件
	 * @return
	 */
	public Pager getExceptionLogListWithPage(ExceptionLogQuery exceptionLogQuery);

	/**
	 * 根据条件查询
	 * 
	 * @param exceptionLogQuery
	 *            查询条件
	 * @return
	 */
	public List<ExceptionLog> getExceptionLogList(ExceptionLogQuery exceptionLogQuery);
	
}
