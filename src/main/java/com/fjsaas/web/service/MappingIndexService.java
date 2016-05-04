package com.fjsaas.web.service;

import java.util.List;

import com.fjsaas.web.pagination.Pager;
import com.fjsaas.web.bean.MappingIndex;
import com.fjsaas.web.query.MappingIndexQuery;


public interface MappingIndexService {
	/**
	 * 基本插入
	 * 
	 * @return
	 */
	public Integer addMappingIndex(MappingIndex mappingIndex);

	/**
	 * 根据主键查询
	 */
	public MappingIndex getMappingIndexByKey(Integer id);

	/**
	 * 根据主键批量查询
	 */
	public List<MappingIndex> getMappingIndexsByKeys(List<Integer> idList);

	/**
	 * 根据主键删除
	 * 
	 * @return
	 */
	public Integer deleteByKey(Integer id);

	/**
	 * 根据主键批量删除
	 * 
	 * @return
	 */
	public Integer deleteByKeys(List<Integer> idList);

	/**
	 * 跟
	 * 
	 * @return
	 */
	public Integer updateMappingIndexByKey(MappingIndex mappingIndex);

	/**
	 * 根据条件查询分页查询
	 * 
	 * @param mappingIndexQuery
	 *            查询条件
	 * @return
	 */
	public Pager getMappingIndexListWithPage(MappingIndexQuery mappingIndexQuery);

	/**
	 * 根据条件查询
	 * 
	 * @param mappingIndexQuery
	 *            查询条件
	 * @return
	 */
	public List<MappingIndex> getMappingIndexList(MappingIndexQuery mappingIndexQuery);
	
	public Integer updateMappingIndexByMappingId(MappingIndex mappingIndex);
	
	public Pager getMappingIndexListWithPageByMulCondition(MappingIndexQuery mappingIndexQuery);

	public int getMappingIndexListCountByMulCondition(MappingIndexQuery mappingIndexQuery);
	
	public List<MappingIndex> getMappingIndexListByMulCondition(MappingIndexQuery mappingIndexQuery);
}
