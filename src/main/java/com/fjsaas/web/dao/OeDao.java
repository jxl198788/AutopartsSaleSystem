package com.fjsaas.web.dao;

import java.util.List;

import com.fjsaas.web.bean.Oe;
import com.fjsaas.web.query.OeQuery;
import org.springframework.stereotype.Repository;

@Repository
public interface OeDao {

	/**
	 * 添加
	 * @param oe
	 */
	public Integer addOe(Oe oe);

	/**
	 * 根据主键查找
	 * @param id
	 */
	public Oe getOeByKey(String id);

	/**
	 * 根据主键批量查找
	 * @param idList
	 */
	public List<Oe> getOesByKeys(List<String> idList);

	/**
	 * 根据主键删除
	 * @param id
	 */
	public Integer deleteByKey(String id);

	/**
	 * 根据主键批量删除
	 * @param idList
	 */
	public Integer deleteByKeys(List<String> idList);

	/**
	 * 根据主键更新
	 * @param oe
	 */
	public Integer updateOeByKey(Oe oe);

	/**
	 * 分页查询
	 * @param oeQuery
	 */
	public List<Oe> getOeListWithPage(OeQuery oeQuery);

	/**
	 * 集合查询
	 * @param oeQuery
	 */
	public List<Oe> getOeList(OeQuery oeQuery);
	
	/**
	 * 总条数
	 * @param oeQuery
	 */
	public int getOeListCount(OeQuery oeQuery);

}
