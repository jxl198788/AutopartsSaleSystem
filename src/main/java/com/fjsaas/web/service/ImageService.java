package com.fjsaas.web.service;

import java.util.List;

import com.fjsaas.web.pagination.Pager;
import com.fjsaas.web.bean.Image;
import com.fjsaas.web.query.ImageQuery;


public interface ImageService {
	/**
	 * 基本插入
	 * 
	 * @return
	 */
	public Integer addImage(Image image);

	/**
	 * 根据主键查询
	 */
	public Image getImageByKey(Integer id);

	/**
	 * 根据主键批量查询
	 */
	public List<Image> getImagesByKeys(List<Integer> idList);

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
	 * 根据主键更新
	 * 
	 * @return
	 */
	public Integer updateImageByKey(Image image);

	/**
	 * 根据条件查询分页查询
	 * 
	 * @param imageQuery
	 *            查询条件
	 * @return
	 */
	public Pager getImageListWithPage(ImageQuery imageQuery);

	/**
	 * 根据条件查询
	 * 
	 * @param imageQuery
	 *            查询条件
	 * @return
	 */
	public List<Image> getImageList(ImageQuery imageQuery);
	
}
