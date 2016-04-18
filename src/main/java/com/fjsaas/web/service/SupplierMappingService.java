package com.fjsaas.web.service;

import java.util.List;

import com.fjsaas.web.pagination.Pager;
import com.fjsaas.web.bean.SupplierMapping;
import com.fjsaas.web.query.SupplierMappingQuery;


public interface SupplierMappingService {
	/**
	 * 基本插入
	 * 
	 * @return
	 */
	public Integer addSupplierMapping(SupplierMapping supplierMapping);

	/**
	 * 根据主键查询
	 */
	public SupplierMapping getSupplierMappingByKey(Integer id);

	/**
	 * 根据主键批量查询
	 */
	public List<SupplierMapping> getSupplierMappingsByKeys(List<Integer> idList);

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
	public Integer updateSupplierMappingByKey(SupplierMapping supplierMapping);

	/**
	 * 根据条件查询分页查询
	 * 
	 * @param supplierMappingQuery
	 *            查询条件
	 * @return
	 */
	public Pager getSupplierMappingListWithPage(SupplierMappingQuery supplierMappingQuery);

	/**
	 * 根据条件查询
	 * 
	 * @param supplierMappingQuery
	 *            查询条件
	 * @return
	 */
	public List<SupplierMapping> getSupplierMappingList(SupplierMappingQuery supplierMappingQuery);
	
	public Pager getSupplierMappingListWithPageByMulCondition(SupplierMappingQuery supplierMappingQuery);

	public int getSupplierMappingListCountByMulCondition(SupplierMappingQuery supplierMappingQuery);
	
}
