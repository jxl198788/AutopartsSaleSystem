package com.fjsaas.web.service;

import java.util.List;

import com.fjsaas.web.pagination.Pager;
import com.fjsaas.web.bean.Oe;
import com.fjsaas.web.query.OeQuery;


public interface OeService {
	/**
	 * 基本插入
	 * 
	 * @return
	 */
	public Integer addOe(Oe oe);

	/**
	 * 根据主键查询
	 */
	public Oe getOeByKey(String id);

	/**
	 * 根据主键批量查询
	 */
	public List<Oe> getOesByKeys(List<String> idList);

	/**
	 * 根据主键删除
	 * 
	 * @return
	 */
	public Integer deleteByKey(String id);

	/**
	 * 根据主键批量删除
	 * 
	 * @return
	 */
	public Integer deleteByKeys(List<String> idList);

	/**
	 * 根据主键更新
	 * 
	 * @return
	 */
	public Integer updateOeByKey(Oe oe);

	/**
	 * 根据条件查询分页查询
	 * 
	 * @param oeQuery
	 *            查询条件
	 * @return
	 */
	public Pager getOeListWithPage(OeQuery oeQuery);

	/**
	 * 根据条件查询
	 * 
	 * @param oeQuery
	 *            查询条件
	 * @return
	 */
	public List<Oe> getOeList(OeQuery oeQuery);
	
}
