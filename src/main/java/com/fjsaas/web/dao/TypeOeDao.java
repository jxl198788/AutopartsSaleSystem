package com.fjsaas.web.dao;

import java.util.List;

import com.fjsaas.web.bean.TypeOe;
import com.fjsaas.web.query.TypeOeQuery;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeOeDao {

	/**
	 * 添加
	 * @param typeOe
	 */
	public Integer addTypeOe(TypeOe typeOe);

	/**
	 * 根据主键查找
	 * @param id
	 */
	public TypeOe getTypeOeByKey(Integer id);

	/**
	 * 根据主键批量查找
	 * @param idList
	 */
	public List<TypeOe> getTypeOesByKeys(List<Integer> idList);

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
	 * @param typeOe
	 */
	public Integer updateTypeOeByKey(TypeOe typeOe);

	/**
	 * 分页查询
	 * @param typeOeQuery
	 */
	public List<TypeOe> getTypeOeListWithPage(TypeOeQuery typeOeQuery);

	/**
	 * 集合查询
	 * @param typeOeQuery
	 */
	public List<TypeOe> getTypeOeList(TypeOeQuery typeOeQuery);
	
	/**
	 * 总条数
	 * @param typeOeQuery
	 */
	public int getTypeOeListCount(TypeOeQuery typeOeQuery);

}
