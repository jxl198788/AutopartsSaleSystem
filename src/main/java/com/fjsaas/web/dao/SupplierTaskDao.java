package com.fjsaas.web.dao;

import java.util.List;

import com.fjsaas.web.bean.SupplierTask;
import com.fjsaas.web.query.SupplierTaskQuery;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierTaskDao {

	/**
	 * 添加
	 * @param supplierTask
	 */
	public Integer addSupplierTask(SupplierTask supplierTask);

	/**
	 * 根据主键查找
	 * @param id
	 */
	public SupplierTask getSupplierTaskByKey(Integer id);

	/**
	 * 根据主键批量查找
	 * @param idList
	 */
	public List<SupplierTask> getSupplierTasksByKeys(List<Integer> idList);

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
	 * @param supplierTask
	 */
	public Integer updateSupplierTaskByKey(SupplierTask supplierTask);

	/**
	 * 分页查询
	 * @param supplierTaskQuery
	 */
	public List<SupplierTask> getSupplierTaskListWithPage(SupplierTaskQuery supplierTaskQuery);

	/**
	 * 集合查询
	 * @param supplierTaskQuery
	 */
	public List<SupplierTask> getSupplierTaskList(SupplierTaskQuery supplierTaskQuery);
	
	/**
	 * 总条数
	 * @param supplierTaskQuery
	 */
	public int getSupplierTaskListCount(SupplierTaskQuery supplierTaskQuery);

}
