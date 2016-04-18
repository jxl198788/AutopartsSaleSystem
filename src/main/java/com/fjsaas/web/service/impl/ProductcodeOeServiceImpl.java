package com.fjsaas.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fjsaas.web.pagination.Pager;
import com.fjsaas.web.bean.ProductcodeOe;
import com.fjsaas.web.dao.ProductcodeOeDao;
import com.fjsaas.web.query.ProductcodeOeQuery;
import com.fjsaas.web.service.ProductcodeOeService;


@Service
public class ProductcodeOeServiceImpl implements ProductcodeOeService {

	@Resource
	ProductcodeOeDao productcodeOeDao;

	/**
	 * 插入数据库
	 * 
	 * @return
	 */
	public Integer addProductcodeOe(ProductcodeOe productcodeOe) {
		return productcodeOeDao.addProductcodeOe(productcodeOe);
	}

	/**
	 * 根据主键查找
	 */
	public ProductcodeOe getProductcodeOeByKey(Integer id) {
		return productcodeOeDao.getProductcodeOeByKey(id);
	}
	
	public List<ProductcodeOe> getProductcodeOesByKeys(List<Integer> idList) {
		return productcodeOeDao.getProductcodeOesByKeys(idList);
	}

	/**
	 * 根据主键删除
	 * 
	 * @return
	 */
	public Integer deleteByKey(Integer id) {
		return productcodeOeDao.deleteByKey(id);
	}

	public Integer deleteByKeys(List<Integer> idList) {
		return productcodeOeDao.deleteByKeys(idList);
	}

	/**
	 * 根据主键更新
	 * 
	 * @return
	 */
	public Integer updateProductcodeOeByKey(ProductcodeOe productcodeOe) {
		return productcodeOeDao.updateProductcodeOeByKey(productcodeOe);
	}
	
	public Pager getProductcodeOeListWithPage(ProductcodeOeQuery productcodeOeQuery) {
		Pager p = new Pager(productcodeOeQuery.getPageNo(),productcodeOeQuery.getPageSize(),productcodeOeDao.getProductcodeOeListCount(productcodeOeQuery));
		p.setList(productcodeOeDao.getProductcodeOeListWithPage(productcodeOeQuery));
		return p;
	}
	
	public List<ProductcodeOe> getProductcodeOeList(ProductcodeOeQuery productcodeOeQuery) {
		return productcodeOeDao.getProductcodeOeList(productcodeOeQuery);
	}
}
