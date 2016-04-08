package com.fjsaas.web.dao;

import java.util.List;

import com.fjsaas.web.bean.Image;
import com.fjsaas.web.query.ImageQuery;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageDao {

	/**
	 * 添加
	 * @param image
	 */
	public Integer addImage(Image image);

	/**
	 * 根据主键查找
	 * @param id
	 */
	public Image getImageByKey(Integer id);

	/**
	 * 根据主键批量查找
	 * @param idList
	 */
	public List<Image> getImagesByKeys(List<Integer> idList);

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
	 * @param image
	 */
	public Integer updateImageByKey(Image image);

	/**
	 * 分页查询
	 * @param imageQuery
	 */
	public List<Image> getImageListWithPage(ImageQuery imageQuery);

	/**
	 * 集合查询
	 * @param imageQuery
	 */
	public List<Image> getImageList(ImageQuery imageQuery);
	
	/**
	 * 总条数
	 * @param imageQuery
	 */
	public int getImageListCount(ImageQuery imageQuery);

}
