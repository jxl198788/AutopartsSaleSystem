package com.fjsaas.web.dao;

import java.util.List;

import com.fjsaas.web.bean.ProducerPart;
import com.fjsaas.web.query.ProducerPartQuery;
import org.springframework.stereotype.Repository;

@Repository
public interface ProducerPartDao {

	/**
	 * 添加
	 * @param producerPart
	 */
	public Integer addProducerPart(ProducerPart producerPart);

	/**
	 * 根据主键查找
	 * @param id
	 */
	public ProducerPart getProducerPartByKey(Integer id);

	/**
	 * 根据主键批量查找
	 * @param idList
	 */
	public List<ProducerPart> getProducerPartsByKeys(List<Integer> idList);

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
	 * @param producerPart
	 */
	public Integer updateProducerPartByKey(ProducerPart producerPart);

	/**
	 * 分页查询
	 * @param producerPartQuery
	 */
	public List<ProducerPart> getProducerPartListWithPage(ProducerPartQuery producerPartQuery);

	/**
	 * 集合查询
	 * @param producerPartQuery
	 */
	public List<ProducerPart> getProducerPartList(ProducerPartQuery producerPartQuery);
	
	/**
	 * 总条数
	 * @param producerPartQuery
	 */
	public int getProducerPartListCount(ProducerPartQuery producerPartQuery);

}
