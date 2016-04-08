package com.fjsaas.web.dao;

import java.util.List;

import com.fjsaas.web.bean.PartSort;
import com.fjsaas.web.query.PartSortQuery;
import org.springframework.stereotype.Repository;

@Repository
public interface PartSortDao {

	/**
	 * 添加
	 * @param partSort
	 */
	public Integer addPartSort(PartSort partSort);

	/**
	 * 根据主键查找
	 * @param id
	 */
	public PartSort getPartSortByKey(Integer id);

	/**
	 * 根据主键批量查找
	 * @param idList
	 */
	public List<PartSort> getPartSortsByKeys(List<Integer> idList);

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
	 * @param partSort
	 */
	public Integer updatePartSortByKey(PartSort partSort);

	/**
	 * 分页查询
	 * @param partSortQuery
	 */
	public List<PartSort> getPartSortListWithPage(PartSortQuery partSortQuery);

	/**
	 * 集合查询
	 * @param partSortQuery
	 */
	public List<PartSort> getPartSortList(PartSortQuery partSortQuery);
	
	/**
	 * 总条数
	 * @param partSortQuery
	 */
	public int getPartSortListCount(PartSortQuery partSortQuery);

}
