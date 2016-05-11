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
	
//add by lyn --------------------------------------------begin

	/**
	 * 根据条件查询
	 * 
	 * @param supplierQuery
	 *            查询条件
	 * @return
	 */
	public List<Supplier> getSupplierInfoList(SupplierQuery supplierQuery);

	/**
	 * 根据主键查询
	 */
	public Supplier getSupplierById(Integer id);
	
	/**
	 * 根据主键更新
	 * 
	 * @return
	 */
	public Integer updateSupplierById(Supplier supplier);
	public Integer updateUserById(Supplier supplier);
	public Integer updateDomainById(Supplier supplier);
	/**
	 * 域名分配插入
	 * 
	 * @return
	 */
	public Integer addDomain(Supplier supplier);


	/**
	 * 根据主键激活、锁定供应商信息
	 * add by lyn 2016.04.27
	 * @return
	 */
	public Integer updateUserStatusById(Supplier supplier);
	
	/**
	 * 根据主键删除
	 * 
	 * @return
	 */
	public Integer deleteById(Supplier supplier);
//add by lyn --------------------------------------------end
}
