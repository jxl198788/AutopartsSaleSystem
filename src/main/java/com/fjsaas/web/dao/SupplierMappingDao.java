package com.fjsaas.web.dao;

import java.util.List;

import com.fjsaas.web.bean.SupplierMapping;
import com.fjsaas.web.query.SupplierMappingQuery;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierMappingDao {

	/**
	 * 添加
	 * @param supplierMapping
	 */
	public Integer addSupplierMapping(SupplierMapping supplierMapping);

	/**
	 * 根据主键查找
	 * @param id
	 */
	public SupplierMapping getSupplierMappingByKey(Integer id);

	/**
	 * 根据主键批量查找
	 * @param idList
	 */
	public List<SupplierMapping> getSupplierMappingsByKeys(List<Integer> idList);

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
	 * @param supplierMapping
	 */
	public Integer updateSupplierMappingByKey(SupplierMapping supplierMapping);

	/**
	 * 分页查询
	 * @param supplierMappingQuery
	 */
	public List<SupplierMapping> getSupplierMappingListWithPage(SupplierMappingQuery supplierMappingQuery);

	/**
	 * 集合查询
	 * @param supplierMappingQuery
	 */
	public List<SupplierMapping> getSupplierMappingList(SupplierMappingQuery supplierMappingQuery);
	
	/**
	 * 总条数
	 * @param supplierMappingQuery
	 */
	public int getSupplierMappingListCount(SupplierMappingQuery supplierMappingQuery);

}
