package com.fjsaas.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fjsaas.web.pagination.Pager;
import com.fjsaas.web.bean.SupplierTask;
import com.fjsaas.web.dao.SupplierTaskDao;
import com.fjsaas.web.query.SupplierTaskQuery;
import com.fjsaas.web.service.SupplierTaskService;


@Service
public class SupplierTaskServiceImpl implements SupplierTaskService {

	@Resource
	SupplierTaskDao supplierTaskDao;

	/**
	 * 插入数据库
	 * 
	 * @return
	 */
	public Integer addSupplierTask(SupplierTask supplierTask) {
		return supplierTaskDao.addSupplierTask(supplierTask);
	}

	/**
	 * 根据主键查找
	 */
	public SupplierTask getSupplierTaskByKey(Integer id) {
		return supplierTaskDao.getSupplierTaskByKey(id);
	}
	
	public List<SupplierTask> getSupplierTasksByKeys(List<Integer> idList) {
		return supplierTaskDao.getSupplierTasksByKeys(idList);
	}

	/**
	 * 根据主键删除
	 * 
	 * @return
	 */
	public Integer deleteByKey(Integer id) {
		return supplierTaskDao.deleteByKey(id);
	}

	public Integer deleteByKeys(List<Integer> idList) {
		return supplierTaskDao.deleteByKeys(idList);
	}

	/**
	 * 根据主键更新
	 * 
	 * @return
	 */
	public Integer updateSupplierTaskByKey(SupplierTask supplierTask) {
		return supplierTaskDao.updateSupplierTaskByKey(supplierTask);
	}
	
	public Pager getSupplierTaskListWithPage(SupplierTaskQuery supplierTaskQuery) {
		Pager p = new Pager(supplierTaskQuery.getPageNo(),supplierTaskQuery.getPageSize(),supplierTaskDao.getSupplierTaskListCount(supplierTaskQuery));
		p.setList(supplierTaskDao.getSupplierTaskListWithPage(supplierTaskQuery));
		return p;
	}
	
	public List<SupplierTask> getSupplierTaskList(SupplierTaskQuery supplierTaskQuery) {
		return supplierTaskDao.getSupplierTaskList(supplierTaskQuery);
	}
}
