package com.fjsaas.web.dao;

import java.util.List;

import com.fjsaas.web.bean.ProductcodeOe;
import com.fjsaas.web.query.ProductcodeOeQuery;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductcodeOeDao {

	/**
	 * 添加
	 * @param productcodeOe
	 */
	public Integer addProductcodeOe(ProductcodeOe productcodeOe);

	/**
	 * 根据主键查找
	 * @param id
	 */
	public ProductcodeOe getProductcodeOeByKey(Integer id);

	/**
	 * 根据主键批量查找
	 * @param idList
	 */
	public List<ProductcodeOe> getProductcodeOesByKeys(List<Integer> idList);

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
	 * @param productcodeOe
	 */
	public Integer updateProductcodeOeByKey(ProductcodeOe productcodeOe);

	/**
	 * 分页查询
	 * @param productcodeOeQuery
	 */
	public List<ProductcodeOe> getProductcodeOeListWithPage(ProductcodeOeQuery productcodeOeQuery);

	/**
	 * 集合查询
	 * @param productcodeOeQuery
	 */
	public List<ProductcodeOe> getProductcodeOeList(ProductcodeOeQuery productcodeOeQuery);
	
	/**
	 * 总条数
	 * @param productcodeOeQuery
	 */
	public int getProductcodeOeListCount(ProductcodeOeQuery productcodeOeQuery);

}
