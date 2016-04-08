package com.fjsaas.web.service;

import java.util.List;

import com.fjsaas.web.pagination.Pager;
import com.fjsaas.web.bean.SupplierEpc;
import com.fjsaas.web.query.SupplierEpcQuery;


public interface SupplierEpcService {
	/**
	 * 基本插入
	 * 
	 * @return
	 */
	public Integer addSupplierEpc(SupplierEpc supplierEpc);

	/**
	 * 根据主键查询
	 */
	public SupplierEpc getSupplierEpcByKey(Integer id);

	/**
	 * 根据主键批量查询
	 */
	public List<SupplierEpc> getSupplierEpcsByKeys(List<Integer> idList);

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
	public Integer updateSupplierEpcByKey(SupplierEpc supplierEpc);

	/**
	 * 根据条件查询分页查询
	 * 
	 * @param supplierEpcQuery
	 *            查询条件
	 * @return
	 */
	public Pager getSupplierEpcListWithPage(SupplierEpcQuery supplierEpcQuery);

	/**
	 * 根据条件查询
	 * 
	 * @param supplierEpcQuery
	 *            查询条件
	 * @return
	 */
	public List<SupplierEpc> getSupplierEpcList(SupplierEpcQuery supplierEpcQuery);
	
}
