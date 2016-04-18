package com.fjsaas.web.dao;

import java.util.List;

import com.fjsaas.web.bean.OperateLog;
import com.fjsaas.web.query.OperateLogQuery;
import org.springframework.stereotype.Repository;

@Repository
public interface OperateLogDao {

	/**
	 * 添加
	 * @param operateLog
	 */
	public Integer addOperateLog(OperateLog operateLog);

	/**
	 * 根据主键查找
	 * @param id
	 */
	public OperateLog getOperateLogByKey(Integer id);

	/**
	 * 根据主键批量查找
	 * @param idList
	 */
	public List<OperateLog> getOperateLogsByKeys(List<Integer> idList);

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
	 * @param operateLog
	 */
	public Integer updateOperateLogByKey(OperateLog operateLog);

	/**
	 * 分页查询
	 * @param operateLogQuery
	 */
	public List<OperateLog> getOperateLogListWithPage(OperateLogQuery operateLogQuery);

	/**
	 * 集合查询
	 * @param operateLogQuery
	 */
	public List<OperateLog> getOperateLogList(OperateLogQuery operateLogQuery);
	
	/**
	 * 总条数
	 * @param operateLogQuery
	 */
	public int getOperateLogListCount(OperateLogQuery operateLogQuery);

}
