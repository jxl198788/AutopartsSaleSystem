package com.fjsaas.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fjsaas.web.pagination.Pager;
import com.fjsaas.web.bean.SupplierEpc;
import com.fjsaas.web.dao.SupplierEpcDao;
import com.fjsaas.web.query.SupplierEpcQuery;
import com.fjsaas.web.service.SupplierEpcService;


@Service
@Transactional
public class SupplierEpcServiceImpl implements SupplierEpcService {

	@Resource
	SupplierEpcDao supplierEpcDao;

	/**
	 * 插入数据库
	 * 
	 * @return
	 */
	public Integer addSupplierEpc(SupplierEpc supplierEpc) {
		return supplierEpcDao.addSupplierEpc(supplierEpc);
	}

	/**
	 * 根据主键查找
	 */
	@Transactional(readOnly = true)
	public SupplierEpc getSupplierEpcByKey(Integer id) {
		return supplierEpcDao.getSupplierEpcByKey(id);
	}
	
	@Transactional(readOnly = true)
	public List<SupplierEpc> getSupplierEpcsByKeys(List<Integer> idList) {
		return supplierEpcDao.getSupplierEpcsByKeys(idList);
	}

	/**
	 * 根据主键删除
	 * 
	 * @return
	 */
	public Integer deleteByKey(Integer id) {
		return supplierEpcDao.deleteByKey(id);
	}

	public Integer deleteByKeys(List<Integer> idList) {
		return supplierEpcDao.deleteByKeys(idList);
	}

	/**
	 * 根据主键更新
	 * 
	 * @return
	 */
	public Integer updateSupplierEpcByKey(SupplierEpc supplierEpc) {
		return supplierEpcDao.updateSupplierEpcByKey(supplierEpc);
	}
	
	@Transactional(readOnly = true)
	public Pager getSupplierEpcListWithPage(SupplierEpcQuery supplierEpcQuery) {
		Pager p = new Pager(supplierEpcQuery.getPageNo(),supplierEpcQuery.getPageSize(),supplierEpcDao.getSupplierEpcListCount(supplierEpcQuery));
		p.setList(supplierEpcDao.getSupplierEpcListWithPage(supplierEpcQuery));
		return p;
	}
	
	@Transactional(readOnly = true)
	public List<SupplierEpc> getSupplierEpcList(SupplierEpcQuery supplierEpcQuery) {
		return supplierEpcDao.getSupplierEpcList(supplierEpcQuery);
	}
}
