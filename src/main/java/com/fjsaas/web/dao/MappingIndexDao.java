package com.fjsaas.web.dao;

import java.util.List;

import com.fjsaas.web.bean.MappingIndex;
import com.fjsaas.web.query.MappingIndexQuery;
import org.springframework.stereotype.Repository;

@Repository
public interface MappingIndexDao {

	/**
	 * 添加
	 * @param mappingIndex
	 */
	public Integer addMappingIndex(MappingIndex mappingIndex);

	/**
	 * 根据主键查找
	 * @param id
	 */
	public MappingIndex getMappingIndexByKey(Integer id);

	/**
	 * 根据主键批量查找
	 * @param idList
	 */
	public List<MappingIndex> getMappingIndexsByKeys(List<Integer> idList);

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
	 * @param mappingIndex
	 */
	public Integer updateMappingIndexByKey(MappingIndex mappingIndex);

	/**
	 * 分页查询
	 * @param mappingIndexQuery
	 */
	public List<MappingIndex> getMappingIndexListWithPage(MappingIndexQuery mappingIndexQuery);

	/**
	 * 集合查询
	 * @param mappingIndexQuery
	 */
	public List<MappingIndex> getMappingIndexList(MappingIndexQuery mappingIndexQuery);
	
	/**
	 * 总条数
	 * @param mappingIndexQuery
	 */
	public int getMappingIndexListCount(MappingIndexQuery mappingIndexQuery);

}
