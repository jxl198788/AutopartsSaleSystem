package com.fjsaas.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fjsaas.web.pagination.Pager;
import com.fjsaas.web.bean.SupplierRelative;
import com.fjsaas.web.dao.SupplierRelativeDao;
import com.fjsaas.web.query.SupplierRelativeQuery;
import com.fjsaas.web.service.SupplierRelativeService;


@Service
public class SupplierRelativeServiceImpl implements SupplierRelativeService {

	@Resource
	SupplierRelativeDao supplierRelativeDao;

	/**
	 * 插入数据库
	 * 
	 * @return
	 */
	public Integer addSupplierRelative(SupplierRelative supplierRelative) {
		return supplierRelativeDao.addSupplierRelative(supplierRelative);
	}

	/**
	 * 根据主键查找
	 */
	public SupplierRelative getSupplierRelativeByKey(Integer id) {
		return supplierRelativeDao.getSupplierRelativeByKey(id);
	}
	
	public List<SupplierRelative> getSupplierRelativesByKeys(List<Integer> idList) {
		return supplierRelativeDao.getSupplierRelativesByKeys(idList);
	}

	/**
	 * 根据主键删除
	 * 
	 * @return
	 */
	public Integer deleteByKey(Integer id) {
		return supplierRelativeDao.deleteByKey(id);
	}

	public Integer deleteByKeys(List<Integer> idList) {
		return supplierRelativeDao.deleteByKeys(idList);
	}

	/**
	 * 根据主键更新
	 * 
	 * @return
	 */
	public Integer updateSupplierRelativeByKey(SupplierRelative supplierRelative) {
		return supplierRelativeDao.updateSupplierRelativeByKey(supplierRelative);
	}
	
	public Pager getSupplierRelativeListWithPage(SupplierRelativeQuery supplierRelativeQuery) {
		Pager p = new Pager(supplierRelativeQuery.getPageNo(),supplierRelativeQuery.getPageSize(),supplierRelativeDao.getSupplierRelativeListCount(supplierRelativeQuery));
		p.setList(supplierRelativeDao.getSupplierRelativeListWithPage(supplierRelativeQuery));
		return p;
	}
	
	public List<SupplierRelative> getSupplierRelativeList(SupplierRelativeQuery supplierRelativeQuery) {
		return supplierRelativeDao.getSupplierRelativeList(supplierRelativeQuery);
	}
}
