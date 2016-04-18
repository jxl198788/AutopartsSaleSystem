package com.fjsaas.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fjsaas.web.pagination.Pager;
import com.fjsaas.web.bean.Part;
import com.fjsaas.web.dao.PartDao;
import com.fjsaas.web.query.PartQuery;
import com.fjsaas.web.service.PartService;


@Service
public class PartServiceImpl implements PartService {

	@Resource
	PartDao partDao;

	/**
	 * 插入数据库
	 * 
	 * @return
	 */
	public Integer addPart(Part part) {
		return partDao.addPart(part);
	}

	/**
	 * 根据主键查找
	 */
	public Part getPartByKey(Integer id) {
		return partDao.getPartByKey(id);
	}
	
	public List<Part> getPartsByKeys(List<Integer> idList) {
		return partDao.getPartsByKeys(idList);
	}

	/**
	 * 根据主键删除
	 * 
	 * @return
	 */
	public Integer deleteByKey(Integer id) {
		return partDao.deleteByKey(id);
	}

	public Integer deleteByKeys(List<Integer> idList) {
		return partDao.deleteByKeys(idList);
	}

	/**
	 * 根据主键更新
	 * 
	 * @return
	 */
	public Integer updatePartByKey(Part part) {
		return partDao.updatePartByKey(part);
	}
	
	public Pager getPartListWithPage(PartQuery partQuery) {
		Pager p = new Pager(partQuery.getPageNo(),partQuery.getPageSize(),partDao.getPartListCount(partQuery));
		p.setList(partDao.getPartListWithPage(partQuery));
		return p;
	}
	
	public List<Part> getPartList(PartQuery partQuery) {
		return partDao.getPartList(partQuery);
	}
}
