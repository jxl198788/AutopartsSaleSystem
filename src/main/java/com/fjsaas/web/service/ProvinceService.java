package com.fjsaas.web.service;

import java.util.List;

import com.fjsaas.web.pagination.Pager;
import com.fjsaas.web.bean.Province;
import com.fjsaas.web.query.ProvinceQuery;


public interface ProvinceService {
	/**
	 * 基本插入
	 * 
	 * @return
	 */
	public Integer addProvince(Province province);

	/**
	 * 根据主键查询
	 */
	public Province getProvinceByKey(Integer id);

	/**
	 * 根据主键批量查询
	 */
	public List<Province> getProvincesByKeys(List<Integer> idList);

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
	public Integer updateProvinceByKey(Province province);

	/**
	 * 根据条件查询分页查询
	 * 
	 * @param provinceQuery
	 *            查询条件
	 * @return
	 */
	public Pager getProvinceListWithPage(ProvinceQuery provinceQuery);

	/**
	 * 根据条件查询
	 * 
	 * @param provinceQuery
	 *            查询条件
	 * @return
	 */
	public List<Province> getProvinceList(ProvinceQuery provinceQuery);
	
}
