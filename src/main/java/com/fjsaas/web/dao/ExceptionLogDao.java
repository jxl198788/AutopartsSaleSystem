package com.fjsaas.web.dao;

import java.util.List;

import com.fjsaas.web.bean.ExceptionLog;
import com.fjsaas.web.query.ExceptionLogQuery;
import org.springframework.stereotype.Repository;

@Repository
public interface ExceptionLogDao {

	/**
	 * 添加
	 * @param exceptionLog
	 */
	public Integer addExceptionLog(ExceptionLog exceptionLog);

	/**
	 * 根据主键查找
	 * @param id
	 */
	public ExceptionLog getExceptionLogByKey(Integer id);

	/**
	 * 根据主键批量查找
	 * @param idList
	 */
	public List<ExceptionLog> getExceptionLogsByKeys(List<Integer> idList);

	/**
	 * 根据主键删除
	 * @param id
	 */
	public Integer deleteByKey(Integer id);

	/**
	 * 根据主键批量删除
	 * @param idList
	 */
	public Integer deleteByKeys(List<Integer> idList);

	/**
	 * 根据主键更新
	 * @param exceptionLog
	 */
	public Integer updateExceptionLogByKey(ExceptionLog exceptionLog);

	/**
	 * 分页查询
	 * @param exceptionLogQuery
	 */
	public List<ExceptionLog> getExceptionLogListWithPage(ExceptionLogQuery exceptionLogQuery);

	/**
	 * 集合查询
	 * @param exceptionLogQuery
	 */
	public List<ExceptionLog> getExceptionLogList(ExceptionLogQuery exceptionLogQuery);
	
	/**
	 * 总条数
	 * @param exceptionLogQuery
	 */
	public int getExceptionLogListCount(ExceptionLogQuery exceptionLogQuery);

}
