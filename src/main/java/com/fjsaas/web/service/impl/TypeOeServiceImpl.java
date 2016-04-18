package com.fjsaas.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fjsaas.web.pagination.Pager;
import com.fjsaas.web.bean.TypeOe;
import com.fjsaas.web.dao.TypeOeDao;
import com.fjsaas.web.query.TypeOeQuery;
import com.fjsaas.web.service.TypeOeService;


@Service
public class TypeOeServiceImpl implements TypeOeService {

	@Resource
	TypeOeDao typeOeDao;

	/**
	 * 插入数据库
	 * 
	 * @return
	 */
	public Integer addTypeOe(TypeOe typeOe) {
		return typeOeDao.addTypeOe(typeOe);
	}

	/**
	 * 根据主键查找
	 */
	public TypeOe getTypeOeByKey(Integer id) {
		return typeOeDao.getTypeOeByKey(id);
	}
	
	public List<TypeOe> getTypeOesByKeys(List<Integer> idList) {
		return typeOeDao.getTypeOesByKeys(idList);
	}

	/**
	 * 根据主键删除
	 * 
	 * @return
	 */
	public Integer deleteByKey(Integer id) {
		return typeOeDao.deleteByKey(id);
	}

	public Integer deleteByKeys(List<Integer> idList) {
		return typeOeDao.deleteByKeys(idList);
	}

	/**
	 * 根据主键更新
	 * 
	 * @return
	 */
	public Integer updateTypeOeByKey(TypeOe typeOe) {
		return typeOeDao.updateTypeOeByKey(typeOe);
	}
	
	public Pager getTypeOeListWithPage(TypeOeQuery typeOeQuery) {
		Pager p = new Pager(typeOeQuery.getPageNo(),typeOeQuery.getPageSize(),typeOeDao.getTypeOeListCount(typeOeQuery));
		p.setList(typeOeDao.getTypeOeListWithPage(typeOeQuery));
		return p;
	}
	
	public List<TypeOe> getTypeOeList(TypeOeQuery typeOeQuery) {
		return typeOeDao.getTypeOeList(typeOeQuery);
	}
}
