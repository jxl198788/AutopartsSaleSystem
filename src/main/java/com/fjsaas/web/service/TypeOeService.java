package com.fjsaas.web.service;

import java.util.List;

import com.fjsaas.web.pagination.Pager;
import com.fjsaas.web.bean.TypeOe;
import com.fjsaas.web.query.TypeOeQuery;


public interface TypeOeService {
	/**
	 * 基本插入
	 * 
	 * @return
	 */
	public Integer addTypeOe(TypeOe typeOe);

	/**
	 * 根据主键查询
	 */
	public TypeOe getTypeOeByKey(Integer id);

	/**
	 * 根据主键批量查询
	 */
	public List<TypeOe> getTypeOesByKeys(List<Integer> idList);

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
	public Integer updateTypeOeByKey(TypeOe typeOe);

	/**
	 * 根据条件查询分页查询
	 * 
	 * @param typeOeQuery
	 *            查询条件
	 * @return
	 */
	public Pager getTypeOeListWithPage(TypeOeQuery typeOeQuery);

	/**
	 * 根据条件查询
	 * 
	 * @param typeOeQuery
	 *            查询条件
	 * @return
	 */
	public List<TypeOe> getTypeOeList(TypeOeQuery typeOeQuery);
	
}
