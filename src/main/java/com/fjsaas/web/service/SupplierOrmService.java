package com.fjsaas.web.service;

import java.util.List;

import com.fjsaas.web.pagination.Pager;
import com.fjsaas.web.bean.SupplierOrm;
import com.fjsaas.web.query.SupplierOrmQuery;


public interface SupplierOrmService {
	/**
	 * 基本插入
	 * 
	 * @return
	 */
	public Integer addSupplierOrm(SupplierOrm supplierOrm);

	/**
	 * 根据主键查询
	 */
	public SupplierOrm getSupplierOrmByKey(Integer id);

	/**
	 * 根据主键批量查询
	 */
	public List<SupplierOrm> getSupplierOrmsByKeys(List<Integer> idList);

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
	public Integer updateSupplierOrmByKey(SupplierOrm supplierOrm);

	/**
	 * 根据条件查询分页查询
	 * 
	 * @param supplierOrmQuery
	 *            查询条件
	 * @return
	 */
	public Pager getSupplierOrmListWithPage(SupplierOrmQuery supplierOrmQuery);

	/**
	 * 根据条件查询
	 * 
	 * @param supplierOrmQuery
	 *            查询条件
	 * @return
	 */
	public List<SupplierOrm> getSupplierOrmList(SupplierOrmQuery supplierOrmQuery);
	
}
