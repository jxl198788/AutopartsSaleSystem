package com.fjsaas.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fjsaas.web.pagination.Pager;
import com.fjsaas.web.bean.Image;
import com.fjsaas.web.dao.ImageDao;
import com.fjsaas.web.query.ImageQuery;
import com.fjsaas.web.service.ImageService;


@Service
@Transactional
public class ImageServiceImpl implements ImageService {

	@Resource
	ImageDao imageDao;

	/**
	 * 插入数据库
	 * 
	 * @return
	 */
	public Integer addImage(Image image) {
		return imageDao.addImage(image);
	}

	/**
	 * 根据主键查找
	 */
	@Transactional(readOnly = true)
	public Image getImageByKey(Integer id) {
		return imageDao.getImageByKey(id);
	}
	
	@Transactional(readOnly = true)
	public List<Image> getImagesByKeys(List<Integer> idList) {
		return imageDao.getImagesByKeys(idList);
	}

	/**
	 * 根据主键删除
	 * 
	 * @return
	 */
	public Integer deleteByKey(Integer id) {
		return imageDao.deleteByKey(id);
	}

	public Integer deleteByKeys(List<Integer> idList) {
		return imageDao.deleteByKeys(idList);
	}

	/**
	 * 根据主键更新
	 * 
	 * @return
	 */
	public Integer updateImageByKey(Image image) {
		return imageDao.updateImageByKey(image);
	}
	
	@Transactional(readOnly = true)
	public Pager getImageListWithPage(ImageQuery imageQuery) {
		Pager p = new Pager(imageQuery.getPageNo(),imageQuery.getPageSize(),imageDao.getImageListCount(imageQuery));
		p.setList(imageDao.getImageListWithPage(imageQuery));
		return p;
	}
	
	@Transactional(readOnly = true)
	public List<Image> getImageList(ImageQuery imageQuery) {
		return imageDao.getImageList(imageQuery);
	}
}
