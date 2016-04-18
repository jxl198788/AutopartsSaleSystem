package com.fjsaas.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fjsaas.web.pagination.Pager;
import com.fjsaas.web.bean.Domain;
import com.fjsaas.web.dao.DomainDao;
import com.fjsaas.web.query.DomainQuery;
import com.fjsaas.web.service.DomainService;


@Service
public class DomainServiceImpl implements DomainService {

	@Resource
	DomainDao domainDao;

	/**
	 * 插入数据库
	 * 
	 * @return
	 */
	public Integer addDomain(Domain domain) {
		return domainDao.addDomain(domain);
	}

	/**
	 * 根据主键查找
	 */
	public Domain getDomainByKey(Integer id) {
		return domainDao.getDomainByKey(id);
	}
	
	public List<Domain> getDomainsByKeys(List<Integer> idList) {
		return domainDao.getDomainsByKeys(idList);
	}

	/**
	 * 根据主键删除
	 * 
	 * @return
	 */
	public Integer deleteByKey(Integer id) {
		return domainDao.deleteByKey(id);
	}

	public Integer deleteByKeys(List<Integer> idList) {
		return domainDao.deleteByKeys(idList);
	}

	/**
	 * 根据主键更新
	 * 
	 * @return
	 */
	public Integer updateDomainByKey(Domain domain) {
		return domainDao.updateDomainByKey(domain);
	}
	
	public Pager getDomainListWithPage(DomainQuery domainQuery) {
		Pager p = new Pager(domainQuery.getPageNo(),domainQuery.getPageSize(),domainDao.getDomainListCount(domainQuery));
		p.setList(domainDao.getDomainListWithPage(domainQuery));
		return p;
	}
	
	public List<Domain> getDomainList(DomainQuery domainQuery) {
		return domainDao.getDomainList(domainQuery);
	}
}
