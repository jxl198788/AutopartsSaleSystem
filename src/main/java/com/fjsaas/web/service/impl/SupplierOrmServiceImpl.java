package com.fjsaas.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fjsaas.web.pagination.Pager;
import com.fjsaas.web.bean.SupplierOrm;
import com.fjsaas.web.dao.SupplierOrmDao;
import com.fjsaas.web.query.SupplierOrmQuery;
import com.fjsaas.web.service.SupplierOrmService;


@Service
@Transactional
public class SupplierOrmServiceImpl implements SupplierOrmService {

	@Resource
	SupplierOrmDao supplierOrmDao;

	/**
	 * 插入数据库
	 * 
	 * @return
	 */
	public Integer addSupplierOrm(SupplierOrm supplierOrm) {
		return supplierOrmDao.addSupplierOrm(supplierOrm);
	}

	/**
	 * 根据主键查找
	 */
	@Transactional(readOnly = true)
	public SupplierOrm getSupplierOrmByKey(Integer id) {
		return supplierOrmDao.getSupplierOrmByKey(id);
	}
	
	@Transactional(readOnly = true)
	public List<SupplierOrm> getSupplierOrmsByKeys(List<Integer> idList) {
		return supplierOrmDao.getSupplierOrmsByKeys(idList);
	}

	/**
	 * 根据主键删除
	 * 
	 * @return
	 */
	public Integer deleteByKey(Integer id) {
		return supplierOrmDao.deleteByKey(id);
	}

	public Integer deleteByKeys(List<Integer> idList) {
		return supplierOrmDao.deleteByKeys(idList);
	}

	/**
	 * 根据主键更新
	 * 
	 * @return
	 */
	public Integer updateSupplierOrmByKey(SupplierOrm supplierOrm) {
		return supplierOrmDao.updateSupplierOrmByKey(supplierOrm);
	}
	
	@Transactional(readOnly = true)
	public Pager getSupplierOrmListWithPage(SupplierOrmQuery supplierOrmQuery) {
		Pager p = new Pager(supplierOrmQuery.getPageNo(),supplierOrmQuery.getPageSize(),supplierOrmDao.getSupplierOrmListCount(supplierOrmQuery));
		p.setList(supplierOrmDao.getSupplierOrmListWithPage(supplierOrmQuery));
		return p;
	}
	
	@Transactional(readOnly = true)
	public List<SupplierOrm> getSupplierOrmList(SupplierOrmQuery supplierOrmQuery) {
		return supplierOrmDao.getSupplierOrmList(supplierOrmQuery);
	}
}
