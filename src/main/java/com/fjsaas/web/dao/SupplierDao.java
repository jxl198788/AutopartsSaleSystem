package com.fjsaas.web.dao;

import java.util.List;

import com.fjsaas.web.bean.Supplier;
import com.fjsaas.web.query.SupplierQuery;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierDao {

	/**
	 * 添加
	 * @param supplier
	 */
	public Integer addSupplier(Supplier supplier);

	/**
	 * 根据主键查找
	 * @param id
	 */
	public Supplier getSupplierByKey(Integer id);

	/**
	 * 根据主键批量查找
	 * @param idList
	 */
	public List<Supplier> getSuppliersByKeys(List<Integer> idList);

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
	 * @param supplier
	 */
	public Integer updateSupplierByKey(Supplier supplier);

	/**
	 * 分页查询
	 * @param supplierQuery
	 */
	public List<Supplier> getSupplierListWithPage(SupplierQuery supplierQuery);

	/**
	 * 集合查询
	 * @param supplierQuery
	 */
	public List<Supplier> getSupplierList(SupplierQuery supplierQuery);
	
	/**
	 * 总条数
	 * @param supplierQuery
	 */
	public int getSupplierListCount(SupplierQuery supplierQuery);

}
