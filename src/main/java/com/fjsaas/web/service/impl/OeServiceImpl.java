package com.fjsaas.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fjsaas.web.pagination.Pager;
import com.fjsaas.web.bean.Oe;
import com.fjsaas.web.dao.OeDao;
import com.fjsaas.web.query.OeQuery;
import com.fjsaas.web.service.OeService;


@Service
public class OeServiceImpl implements OeService {

	@Resource
	OeDao oeDao;

	/**
	 * 插入数据库
	 * 
	 * @return
	 */
	public Integer addOe(Oe oe) {
		return oeDao.addOe(oe);
	}

	/**
	 * 根据主键查找
	 */
	public Oe getOeByKey(String id) {
		return oeDao.getOeByKey(id);
	}
	
	public List<Oe> getOesByKeys(List<String> idList) {
		return oeDao.getOesByKeys(idList);
	}

	/**
	 * 根据主键删除
	 * 
	 * @return
	 */
	public Integer deleteByKey(String id) {
		return oeDao.deleteByKey(id);
	}

	public Integer deleteByKeys(List<String> idList) {
		return oeDao.deleteByKeys(idList);
	}

	/**
	 * 根据主键更新
	 * 
	 * @return
	 */
	public Integer updateOeByKey(Oe oe) {
		return oeDao.updateOeByKey(oe);
	}
	
	public Pager getOeListWithPage(OeQuery oeQuery) {
		Pager p = new Pager(oeQuery.getPageNo(),oeQuery.getPageSize(),oeDao.getOeListCount(oeQuery));
		p.setList(oeDao.getOeListWithPage(oeQuery));
		return p;
	}
	
	public List<Oe> getOeList(OeQuery oeQuery) {
		return oeDao.getOeList(oeQuery);
	}
}
