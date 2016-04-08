package com.fjsaas.web.service;

import java.util.List;

import com.fjsaas.web.pagination.Pager;
import com.fjsaas.web.bean.Domain;
import com.fjsaas.web.query.DomainQuery;


public interface DomainService {
	/**
	 * 基本插入
	 * 
	 * @return
	 */
	public Integer addDomain(Domain domain);

	/**
	 * 根据主键查询
	 */
	public Domain getDomainByKey(Integer id);

	/**
	 * 根据主键批量查询
	 */
	public List<Domain> getDomainsByKeys(List<Integer> idList);

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
	public Integer updateDomainByKey(Domain domain);

	/**
	 * 根据条件查询分页查询
	 * 
	 * @param domainQuery
	 *            查询条件
	 * @return
	 */
	public Pager getDomainListWithPage(DomainQuery domainQuery);

	/**
	 * 根据条件查询
	 * 
	 * @param domainQuery
	 *            查询条件
	 * @return
	 */
	public List<Domain> getDomainList(DomainQuery domainQuery);
	
}
