package com.fjsaas.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fjsaas.web.pagination.Pager;
import com.fjsaas.web.bean.Brand;
import com.fjsaas.web.dao.BrandDao;
import com.fjsaas.web.query.BrandQuery;
import com.fjsaas.web.service.BrandService;


@Service
@Transactional
public class BrandServiceImpl implements BrandService {

	@Resource
	BrandDao brandDao;

	/**
	 * 插入数据库
	 * 
	 * @return
	 */
	public Integer addBrand(Brand brand) {
		return brandDao.addBrand(brand);
	}

	/**
	 * 根据主键查找
	 */
	@Transactional(readOnly = true)
	public Brand getBrandByKey(Integer id) {
		return brandDao.getBrandByKey(id);
	}
	
	@Transactional(readOnly = true)
	public List<Brand> getBrandsByKeys(List<Integer> idList) {
		return brandDao.getBrandsByKeys(idList);
	}

	/**
	 * 根据主键删除
	 * 
	 * @return
	 */
	public Integer deleteByKey(Integer id) {
		return brandDao.deleteByKey(id);
	}

	public Integer deleteByKeys(List<Integer> idList) {
		return brandDao.deleteByKeys(idList);
	}

	/**
	 * 根据主键更新
	 * 
	 * @return
	 */
	public Integer updateBrandByKey(Brand brand) {
		return brandDao.updateBrandByKey(brand);
	}
	
	@Transactional(readOnly = true)
	public Pager getBrandListWithPage(BrandQuery brandQuery) {
		Pager p = new Pager(brandQuery.getPageNo(),brandQuery.getPageSize(),brandDao.getBrandListCount(brandQuery));
		p.setList(brandDao.getBrandListWithPage(brandQuery));
		return p;
	}
	
	@Transactional(readOnly = true)
	public List<Brand> getBrandList(BrandQuery brandQuery) {
		return brandDao.getBrandList(brandQuery);
	}
}
