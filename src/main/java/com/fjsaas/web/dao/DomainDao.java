package com.fjsaas.web.dao;

import java.util.List;

import com.fjsaas.web.bean.Domain;
import com.fjsaas.web.query.DomainQuery;
import org.springframework.stereotype.Repository;

@Repository
public interface DomainDao {

	/**
	 * 添加
	 * @param domain
	 */
	public Integer addDomain(Domain domain);

	/**
	 * 根据主键查找
	 * @param id
	 */
	public Domain getDomainByKey(Integer id);

	/**
	 * 根据主键批量查找
	 * @param idList
	 */
	public List<Domain> getDomainsByKeys(List<Integer> idList);

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
	 * @param domain
	 */
	public Integer updateDomainByKey(Domain domain);

	/**
	 * 分页查询
	 * @param domainQuery
	 */
	public List<Domain> getDomainListWithPage(DomainQuery domainQuery);

	/**
	 * 集合查询
	 * @param domainQuery
	 */
	public List<Domain> getDomainList(DomainQuery domainQuery);
	
	/**
	 * 总条数
	 * @param domainQuery
	 */
	public int getDomainListCount(DomainQuery domainQuery);

}
