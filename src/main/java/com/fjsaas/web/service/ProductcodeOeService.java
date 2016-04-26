package com.fjsaas.web.service;

import java.util.HashMap;
import java.util.List;

import com.fjsaas.web.pagination.Pager;
import com.fjsaas.web.bean.MappingIndex;
import com.fjsaas.web.bean.ProductcodeOe;
import com.fjsaas.web.bean.SupplierMapping;
import com.fjsaas.web.query.ProductcodeOeQuery;


public interface ProductcodeOeService {
	/**
	 * 基本插入
	 * 
	 * @return
	 */
	public Integer addProductcodeOe(ProductcodeOe productcodeOe);

	/**
	 * 根据主键查询
	 */
	public ProductcodeOe getProductcodeOeByKey(Integer id);

	/**
	 * 根据主键批量查询
	 */
	public List<ProductcodeOe> getProductcodeOesByKeys(List<Integer> idList);

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
	public Integer updateProductcodeOeByKey(ProductcodeOe productcodeOe);

	/**
	 * 根据条件查询分页查询
	 * 
	 * @param productcodeOeQuery
	 *            查询条件
	 * @return
	 */
	public Pager getProductcodeOeListWithPage(ProductcodeOeQuery productcodeOeQuery);

	/**
	 * 根据条件查询
	 * 
	 * @param productcodeOeQuery
	 *            查询条件
	 * @return
	 */
	public List<ProductcodeOe> getProductcodeOeList(ProductcodeOeQuery productcodeOeQuery);
	
	public List<ProductcodeOe> getProductcodeOesByProductCode(HashMap<String, Object> map);
	
	public List<ProductcodeOe> getProductcodeOesByOeCode(HashMap<String, Object> map);
	
	public List<ProductcodeOe> getProductcodeOesByReferenceCode(HashMap<String, Object> map);
	
	public List<MappingIndex> InferMappingIndexs(SupplierMapping supplierMapping);
	
}
