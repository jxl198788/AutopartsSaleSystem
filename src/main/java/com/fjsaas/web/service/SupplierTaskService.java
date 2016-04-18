package com.fjsaas.web.service;

import java.util.List;

import com.fjsaas.web.pagination.Pager;
import com.fjsaas.web.bean.SupplierTask;
import com.fjsaas.web.query.SupplierTaskQuery;


public interface SupplierTaskService {
	/**
	 * 基本插入
	 * 
	 * @return
	 */
	public Integer addSupplierTask(SupplierTask supplierTask);

	/**
	 * 根据主键查询
	 */
	public SupplierTask getSupplierTaskByKey(Integer id);

	/**
	 * 根据主键批量查询
	 */
	public List<SupplierTask> getSupplierTasksByKeys(List<Integer> idList);

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
	public Integer updateSupplierTaskByKey(SupplierTask supplierTask);

	/**
	 * 根据条件查询分页查询
	 * 
	 * @param supplierTaskQuery
	 *            查询条件
	 * @return
	 */
	public Pager getSupplierTaskListWithPage(SupplierTaskQuery supplierTaskQuery);

	/**
	 * 根据条件查询
	 * 
	 * @param supplierTaskQuery
	 *            查询条件
	 * @return
	 */
	public List<SupplierTask> getSupplierTaskList(SupplierTaskQuery supplierTaskQuery);
	
}
