package com.fjsaas.web.dao;

import java.util.List;

import com.fjsaas.web.bean.SupplierOrm;
import com.fjsaas.web.query.SupplierOrmQuery;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierOrmDao {

	/**
	 * 添加
	 * @param supplierOrm
	 */
	public Integer addSupplierOrm(SupplierOrm supplierOrm);

	/**
	 * 根据主键查找
	 * @param id
	 */
	public SupplierOrm getSupplierOrmByKey(Integer id);

	/**
	 * 根据主键批量查找
	 * @param idList
	 */
	public List<SupplierOrm> getSupplierOrmsByKeys(List<Integer> idList);

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
	 * @param supplierOrm
	 */
	public Integer updateSupplierOrmByKey(SupplierOrm supplierOrm);

	/**
	 * 分页查询
	 * @param supplierOrmQuery
	 */
	public List<SupplierOrm> getSupplierOrmListWithPage(SupplierOrmQuery supplierOrmQuery);

	/**
	 * 集合查询
	 * @param supplierOrmQuery
	 */
	public List<SupplierOrm> getSupplierOrmList(SupplierOrmQuery supplierOrmQuery);
	
	/**
	 * 总条数
	 * @param supplierOrmQuery
	 */
	public int getSupplierOrmListCount(SupplierOrmQuery supplierOrmQuery);

}
