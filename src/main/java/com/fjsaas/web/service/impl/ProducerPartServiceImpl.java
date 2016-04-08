package com.fjsaas.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fjsaas.web.pagination.Pager;
import com.fjsaas.web.bean.ProducerPart;
import com.fjsaas.web.dao.ProducerPartDao;
import com.fjsaas.web.query.ProducerPartQuery;
import com.fjsaas.web.service.ProducerPartService;


@Service
@Transactional
public class ProducerPartServiceImpl implements ProducerPartService {

	@Resource
	ProducerPartDao producerPartDao;

	/**
	 * 插入数据库
	 * 
	 * @return
	 */
	public Integer addProducerPart(ProducerPart producerPart) {
		return producerPartDao.addProducerPart(producerPart);
	}

	/**
	 * 根据主键查找
	 */
	@Transactional(readOnly = true)
	public ProducerPart getProducerPartByKey(Integer id) {
		return producerPartDao.getProducerPartByKey(id);
	}
	
	@Transactional(readOnly = true)
	public List<ProducerPart> getProducerPartsByKeys(List<Integer> idList) {
		return producerPartDao.getProducerPartsByKeys(idList);
	}

	/**
	 * 根据主键删除
	 * 
	 * @return
	 */
	public Integer deleteByKey(Integer id) {
		return producerPartDao.deleteByKey(id);
	}

	public Integer deleteByKeys(List<Integer> idList) {
		return producerPartDao.deleteByKeys(idList);
	}

	/**
	 * 根据主键更新
	 * 
	 * @return
	 */
	public Integer updateProducerPartByKey(ProducerPart producerPart) {
		return producerPartDao.updateProducerPartByKey(producerPart);
	}
	
	@Transactional(readOnly = true)
	public Pager getProducerPartListWithPage(ProducerPartQuery producerPartQuery) {
		Pager p = new Pager(producerPartQuery.getPageNo(),producerPartQuery.getPageSize(),producerPartDao.getProducerPartListCount(producerPartQuery));
		p.setList(producerPartDao.getProducerPartListWithPage(producerPartQuery));
		return p;
	}
	
	@Transactional(readOnly = true)
	public List<ProducerPart> getProducerPartList(ProducerPartQuery producerPartQuery) {
		return producerPartDao.getProducerPartList(producerPartQuery);
	}
}
