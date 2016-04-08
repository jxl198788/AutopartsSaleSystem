package com.fjsaas.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fjsaas.web.pagination.Pager;
import com.fjsaas.web.bean.Producer;
import com.fjsaas.web.dao.ProducerDao;
import com.fjsaas.web.query.ProducerQuery;
import com.fjsaas.web.service.ProducerService;


@Service
@Transactional
public class ProducerServiceImpl implements ProducerService {

	@Resource
	ProducerDao producerDao;

	/**
	 * 插入数据库
	 * 
	 * @return
	 */
	public Integer addProducer(Producer producer) {
		return producerDao.addProducer(producer);
	}

	/**
	 * 根据主键查找
	 */
	@Transactional(readOnly = true)
	public Producer getProducerByKey(Integer id) {
		return producerDao.getProducerByKey(id);
	}
	
	@Transactional(readOnly = true)
	public List<Producer> getProducersByKeys(List<Integer> idList) {
		return producerDao.getProducersByKeys(idList);
	}

	/**
	 * 根据主键删除
	 * 
	 * @return
	 */
	public Integer deleteByKey(Integer id) {
		return producerDao.deleteByKey(id);
	}

	public Integer deleteByKeys(List<Integer> idList) {
		return producerDao.deleteByKeys(idList);
	}

	/**
	 * 根据主键更新
	 * 
	 * @return
	 */
	public Integer updateProducerByKey(Producer producer) {
		return producerDao.updateProducerByKey(producer);
	}
	
	@Transactional(readOnly = true)
	public Pager getProducerListWithPage(ProducerQuery producerQuery) {
		Pager p = new Pager(producerQuery.getPageNo(),producerQuery.getPageSize(),producerDao.getProducerListCount(producerQuery));
		p.setList(producerDao.getProducerListWithPage(producerQuery));
		return p;
	}
	
	@Transactional(readOnly = true)
	public List<Producer> getProducerList(ProducerQuery producerQuery) {
		return producerDao.getProducerList(producerQuery);
	}
}
