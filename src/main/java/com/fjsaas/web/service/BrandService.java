package com.fjsaas.web.service;

import java.util.List;

import com.fjsaas.web.pagination.Pager;
import com.fjsaas.web.bean.Brand;
import com.fjsaas.web.query.BrandQuery;


public interface BrandService {
	/**
	 * 基本插入
	 * 
	 * @return
	 */
	public Integer addBrand(Brand brand);

	/**
	 * 根据主键查询
	 */
	public Brand getBrandByKey(Integer id);

	/**
	 * 根据主键批量查询
	 */
	public List<Brand> getBrandsByKeys(List<Integer> idList);

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
	public Integer updateBrandByKey(Brand brand);

	/**
	 * 根据条件查询分页查询
	 * 
	 * @param brandQuery
	 *            查询条件
	 * @return
	 */
	public Pager getBrandListWithPage(BrandQuery brandQuery);

	/**
	 * 根据条件查询
	 * 
	 * @param brandQuery
	 *            查询条件
	 * @return
	 */
	public List<Brand> getBrandList(BrandQuery brandQuery);
	
}
