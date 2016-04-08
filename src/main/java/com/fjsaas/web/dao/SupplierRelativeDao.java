package com.fjsaas.web.dao;

import java.util.List;

import com.fjsaas.web.bean.SupplierRelative;
import com.fjsaas.web.query.SupplierRelativeQuery;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRelativeDao {

	/**
	 * 添加
	 * @param supplierRelative
	 */
	public Integer addSupplierRelative(SupplierRelative supplierRelative);

	/**
	 * 根据主键查找
	 * @param id
	 */
	public SupplierRelative getSupplierRelativeByKey(Integer id);

	/**
	 * 根据主键批量查找
	 * @param idList
	 */
	public List<SupplierRelative> getSupplierRelativesByKeys(List<Integer> idList);

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
	 * @param supplierRelative
	 */
	public Integer updateSupplierRelativeByKey(SupplierRelative supplierRelative);

	/**
	 * 分页查询
	 * @param supplierRelativeQuery
	 */
	public List<SupplierRelative> getSupplierRelativeListWithPage(SupplierRelativeQuery supplierRelativeQuery);

	/**
	 * 集合查询
	 * @param supplierRelativeQuery
	 */
	public List<SupplierRelative> getSupplierRelativeList(SupplierRelativeQuery supplierRelativeQuery);
	
	/**
	 * 总条数
	 * @param supplierRelativeQuery
	 */
	public int getSupplierRelativeListCount(SupplierRelativeQuery supplierRelativeQuery);

}
