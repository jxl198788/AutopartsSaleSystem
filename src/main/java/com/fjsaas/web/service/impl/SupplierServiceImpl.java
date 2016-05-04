package com.fjsaas.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fjsaas.web.pagination.Pager;
import com.fjsaas.web.bean.Supplier;
import com.fjsaas.web.dao.SupplierDao;
import com.fjsaas.web.query.SupplierQuery;
import com.fjsaas.web.service.SupplierService;


@Service
public class SupplierServiceImpl implements SupplierService {

	@Resource
	SupplierDao supplierDao;

	/**
	 * 插入数据库
	 * 
	 * @return
	 */
	public Integer addSupplier(Supplier supplier) {
		return supplierDao.addSupplier(supplier);
	}

	/**
	 * 根据主键更新
	 * 
	 * @return
	 */
	public Integer updateSupplierByKey(Supplier supplier) {
		return supplierDao.updateSupplierByKey(supplier);
	}
	
	/**
	 * 根据主键查找
	 */
	public Supplier getSupplierByKey(Integer id) {
		return supplierDao.getSupplierByKey(id);
	}
	
	public List<Supplier> getSuppliersByKeys(List<Integer> idList) {
		return supplierDao.getSuppliersByKeys(idList);
	}

	/**
	 * 根据主键删除
	 * 
	 * @return
	 */
	public Integer deleteByKey(Integer id) {
		return supplierDao.deleteByKey(id);
	}

	public Integer deleteByKeys(List<Integer> idList) {
		return supplierDao.deleteByKeys(idList);
	}

	public Pager getSupplierListWithPage(SupplierQuery supplierQuery) {
		Pager p = new Pager(supplierQuery.getPageNo(),supplierQuery.getPageSize(),supplierDao.getSupplierListCount(supplierQuery));
		p.setList(supplierDao.getSupplierListWithPage(supplierQuery));
		return p;
	}
	
	public List<Supplier> getSupplierList(SupplierQuery supplierQuery) {
		return supplierDao.getSupplierList(supplierQuery);
	}

	//add by lyn --------------------------------------------begin

	public List<Supplier> getSupplierInfoList(SupplierQuery supplierQuery) {
		return supplierDao.getSupplierInfoList(supplierQuery);
	}

	/**
	 * 根据主键查找
	 */
	public Supplier getSupplierById(Integer id) {
		return supplierDao.getSupplierById(id);
	}
	
	/**
	 * 根据主键更新
	 * 
	 * @return
	 */
	public Integer updateSupplierById(Supplier supplier) {
		return supplierDao.updateSupplierById(supplier);
	}
	public Integer updateUserById(Supplier supplier){
		return supplierDao.updateUserById(supplier);
	}
	public Integer updateDomainById(Supplier supplier){
		return supplierDao.updateDomainById(supplier);
	}
	
	/**
	 * 根据主键激活、锁定供应商信息
	 * add by lyn 2016.04.27
	 * @return
	 */
	public Integer updateUserStatusById(Supplier supplier) {
		return supplierDao.updateUserStatusById(supplier);
	}
	
	/**
	 * 根据主键删除
	 * 
	 * @return
	 */
	public Integer deleteById(Integer id) {
		return supplierDao.deleteById(id);
	}
	//add by lyn --------------------------------------------end

}
