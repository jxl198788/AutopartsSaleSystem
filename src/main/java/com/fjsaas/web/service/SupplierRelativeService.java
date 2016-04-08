package com.fjsaas.web.service;

import java.util.List;

import com.fjsaas.web.pagination.Pager;
import com.fjsaas.web.bean.SupplierRelative;
import com.fjsaas.web.query.SupplierRelativeQuery;


public interface SupplierRelativeService {
	/**
	 * 基本插入
	 * 
	 * @return
	 */
	public Integer addSupplierRelative(SupplierRelative supplierRelative);

	/**
	 * 根据主键查询
	 */
	public SupplierRelative getSupplierRelativeByKey(Integer id);

	/**
	 * 根据主键批量查询
	 */
	public List<SupplierRelative> getSupplierRelativesByKeys(List<Integer> idList);

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
	public Integer updateSupplierRelativeByKey(SupplierRelative supplierRelative);

	/**
	 * 根据条件查询分页查询
	 * 
	 * @param supplierRelativeQuery
	 *            查询条件
	 * @return
	 */
	public Pager getSupplierRelativeListWithPage(SupplierRelativeQuery supplierRelativeQuery);

	/**
	 * 根据条件查询
	 * 
	 * @param supplierRelativeQuery
	 *            查询条件
	 * @return
	 */
	public List<SupplierRelative> getSupplierRelativeList(SupplierRelativeQuery supplierRelativeQuery);
	
}
