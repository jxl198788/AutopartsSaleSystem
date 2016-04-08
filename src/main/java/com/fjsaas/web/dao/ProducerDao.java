package com.fjsaas.web.dao;

import java.util.List;

import com.fjsaas.web.bean.Producer;
import com.fjsaas.web.query.ProducerQuery;
import org.springframework.stereotype.Repository;

@Repository
public interface ProducerDao {

	/**
	 * 添加
	 * @param producer
	 */
	public Integer addProducer(Producer producer);

	/**
	 * 根据主键查找
	 * @param id
	 */
	public Producer getProducerByKey(Integer id);

	/**
	 * 根据主键批量查找
	 * @param idList
	 */
	public List<Producer> getProducersByKeys(List<Integer> idList);

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
	 * @param producer
	 */
	public Integer updateProducerByKey(Producer producer);

	/**
	 * 分页查询
	 * @param producerQuery
	 */
	public List<Producer> getProducerListWithPage(ProducerQuery producerQuery);

	/**
	 * 集合查询
	 * @param producerQuery
	 */
	public List<Producer> getProducerList(ProducerQuery producerQuery);
	
	/**
	 * 总条数
	 * @param producerQuery
	 */
	public int getProducerListCount(ProducerQuery producerQuery);

}
