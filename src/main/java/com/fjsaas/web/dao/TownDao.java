package com.fjsaas.web.dao;

import java.util.List;

import com.fjsaas.web.bean.Town;
import com.fjsaas.web.query.TownQuery;
import org.springframework.stereotype.Repository;

@Repository
public interface TownDao {

	/**
	 * 添加
	 * @param town
	 */
	public Integer addTown(Town town);

	/**
	 * 根据主键查找
	 * @param id
	 */
	public Town getTownByKey(Integer id);

	/**
	 * 根据主键批量查找
	 * @param idList
	 */
	public List<Town> getTownsByKeys(List<Integer> idList);

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
	 * @param town
	 */
	public Integer updateTownByKey(Town town);

	/**
	 * 分页查询
	 * @param townQuery
	 */
	public List<Town> getTownListWithPage(TownQuery townQuery);

	/**
	 * 集合查询
	 * @param townQuery
	 */
	public List<Town> getTownList(TownQuery townQuery);
	
	/**
	 * 总条数
	 * @param townQuery
	 */
	public int getTownListCount(TownQuery townQuery);

}
