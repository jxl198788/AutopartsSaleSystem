package com.fjsaas.web.dao;

import java.util.List;

import com.fjsaas.web.bean.Brand;
import com.fjsaas.web.query.BrandQuery;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandDao {

	/**
	 * 添加
	 * @param brand
	 */
	public Integer addBrand(Brand brand);

	/**
	 * 根据主键查找
	 * @param id
	 */
	public Brand getBrandByKey(Integer id);

	/**
	 * 根据主键批量查找
	 * @param idList
	 */
	public List<Brand> getBrandsByKeys(List<Integer> idList);

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
	 * @param brand
	 */
	public Integer updateBrandByKey(Brand brand);

	/**
	 * 分页查询
	 * @param brandQuery
	 */
	public List<Brand> getBrandListWithPage(BrandQuery brandQuery);

	/**
	 * 集合查询
	 * @param brandQuery
	 */
	public List<Brand> getBrandList(BrandQuery brandQuery);
	
	/**
	 * 总条数
	 * @param brandQuery
	 */
	public int getBrandListCount(BrandQuery brandQuery);

}
