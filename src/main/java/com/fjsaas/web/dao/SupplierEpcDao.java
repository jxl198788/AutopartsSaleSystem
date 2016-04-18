package com.fjsaas.web.dao;

import java.util.List;

import com.fjsaas.web.bean.SupplierEpc;
import com.fjsaas.web.query.SupplierEpcQuery;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierEpcDao {

	/**
	 * 添加
	 * @param supplierEpc
	 */
	public Integer addSupplierEpc(SupplierEpc supplierEpc);

	/**
	 * 根据主键查找
	 * @param id
	 */
	public SupplierEpc getSupplierEpcByKey(Integer id);

	/**
	 * 根据主键批量查找
	 * @param idList
	 */
	public List<SupplierEpc> getSupplierEpcsByKeys(List<Integer> idList);

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
	 * @param supplierEpc
	 */
	public Integer updateSupplierEpcByKey(SupplierEpc supplierEpc);

	/**
	 * 分页查询
	 * @param supplierEpcQuery
	 */
	public List<SupplierEpc> getSupplierEpcListWithPage(SupplierEpcQuery supplierEpcQuery);

	/**
	 * 集合查询
	 * @param supplierEpcQuery
	 */
	public List<SupplierEpc> getSupplierEpcList(SupplierEpcQuery supplierEpcQuery);
	
	/**
	 * 总条数
	 * @param supplierEpcQuery
	 */
	public int getSupplierEpcListCount(SupplierEpcQuery supplierEpcQuery);

}
