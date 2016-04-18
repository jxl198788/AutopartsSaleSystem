package com.fjsaas.web.dao;

import java.util.List;

import com.fjsaas.web.bean.Part;
import com.fjsaas.web.query.PartQuery;
import org.springframework.stereotype.Repository;

@Repository
public interface PartDao {

	/**
	 * 添加
	 * @param part
	 */
	public Integer addPart(Part part);

	/**
	 * 根据主键查找
	 * @param id
	 */
	public Part getPartByKey(Integer id);

	/**
	 * 根据主键批量查找
	 * @param idList
	 */
	public List<Part> getPartsByKeys(List<Integer> idList);

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
	 * @param part
	 */
	public Integer updatePartByKey(Part part);

	/**
	 * 分页查询
	 * @param partQuery
	 */
	public List<Part> getPartListWithPage(PartQuery partQuery);

	/**
	 * 集合查询
	 * @param partQuery
	 */
	public List<Part> getPartList(PartQuery partQuery);
	
	/**
	 * 总条数
	 * @param partQuery
	 */
	public int getPartListCount(PartQuery partQuery);

}
