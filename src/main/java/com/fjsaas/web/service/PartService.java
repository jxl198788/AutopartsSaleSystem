package com.fjsaas.web.service;

import java.util.List;

import com.fjsaas.web.pagination.Pager;
import com.fjsaas.web.bean.Part;
import com.fjsaas.web.query.PartQuery;


public interface PartService {
	/**
	 * 基本插入
	 * 
	 * @return
	 */
	public Integer addPart(Part part);

	/**
	 * 根据主键查询
	 */
	public Part getPartByKey(Integer id);

	/**
	 * 根据主键批量查询
	 */
	public List<Part> getPartsByKeys(List<Integer> idList);

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
	public Integer updatePartByKey(Part part);

	/**
	 * 根据条件查询分页查询
	 * 
	 * @param partQuery
	 *            查询条件
	 * @return
	 */
	public Pager getPartListWithPage(PartQuery partQuery);

	/**
	 * 根据条件查询
	 * 
	 * @param partQuery
	 *            查询条件
	 * @return
	 */
	public List<Part> getPartList(PartQuery partQuery);
	
}
