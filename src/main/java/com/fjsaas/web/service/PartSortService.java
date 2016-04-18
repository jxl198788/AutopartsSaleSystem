package com.fjsaas.web.service;

import java.util.List;

import com.fjsaas.web.pagination.Pager;
import com.fjsaas.web.bean.PartSort;
import com.fjsaas.web.query.PartSortQuery;


public interface PartSortService {
	/**
	 * 基本插入
	 * 
	 * @return
	 */
	public Integer addPartSort(PartSort partSort);

	/**
	 * 根据主键查询
	 */
	public PartSort getPartSortByKey(Integer id);

	/**
	 * 根据主键批量查询
	 */
	public List<PartSort> getPartSortsByKeys(List<Integer> idList);

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
	public Integer updatePartSortByKey(PartSort partSort);

	/**
	 * 根据条件查询分页查询
	 * 
	 * @param partSortQuery
	 *            查询条件
	 * @return
	 */
	public Pager getPartSortListWithPage(PartSortQuery partSortQuery);

	/**
	 * 根据条件查询
	 * 
	 * @param partSortQuery
	 *            查询条件
	 * @return
	 */
	public List<PartSort> getPartSortList(PartSortQuery partSortQuery);
	
}
