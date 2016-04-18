package com.fjsaas.web.service;

import java.util.List;

import com.fjsaas.web.pagination.Pager;
import com.fjsaas.web.bean.Supplier;
import com.fjsaas.web.query.SupplierQuery;


public interface SupplierService {
	/**
	 * 基本插入
	 * 
	 * @return
	 */
	public Integer addSupplier(Supplier supplier);

	/**
	 * 根据主键查询
	 */
	public Supplier getSupplierByKey(Integer id);

	/**
	 * 根据主键批量查询
	 */
	public List<Supplier> getSuppliersByKeys(List<Integer> idList);

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
	public Integer updateSupplierByKey(Supplier supplier);

	/**
	 * 根据条件查询分页查询
	 * 
	 * @param supplierQuery
	 *            查询条件
	 * @return
	 */
	public Pager getSupplierListWithPage(SupplierQuery supplierQuery);

	/**
	 * 根据条件查询
	 * 
	 * @param supplierQuery
	 *            查询条件
	 * @return
	 */
	public List<Supplier> getSupplierList(SupplierQuery supplierQuery);
	
}
