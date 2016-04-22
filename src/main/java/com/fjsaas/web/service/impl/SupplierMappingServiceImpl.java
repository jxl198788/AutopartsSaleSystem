package com.fjsaas.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fjsaas.web.pagination.Pager;
import com.fjsaas.web.bean.SupplierMapping;
import com.fjsaas.web.dao.SupplierMappingCustomDao;
import com.fjsaas.web.dao.SupplierMappingDao;
import com.fjsaas.web.query.SupplierMappingQuery;
import com.fjsaas.web.service.SupplierMappingService;


@Service
public class SupplierMappingServiceImpl implements SupplierMappingService {

	@Resource
	SupplierMappingDao supplierMappingDao;
	
	@Resource
	SupplierMappingCustomDao supplierMappingCustomDao;

	/**
	 * 插入数据库
	 * 
	 * @return
	 */
	public Integer addSupplierMapping(SupplierMapping supplierMapping) {
		return supplierMappingDao.addSupplierMapping(supplierMapping);
	}

	/**
	 * 根据主键查找
	 */
	public SupplierMapping getSupplierMappingByKey(Integer id) {
		return supplierMappingDao.getSupplierMappingByKey(id);
	}
	
	public List<SupplierMapping> getSupplierMappingsByKeys(List<Integer> idList) {
		return supplierMappingDao.getSupplierMappingsByKeys(idList);
	}

	/**
	 * 根据主键删除
	 * 
	 * @return
	 */
	public Integer deleteByKey(Integer id) {
		return supplierMappingDao.deleteByKey(id);
	}

	public Integer deleteByKeys(List<Integer> idList) {
		return supplierMappingDao.deleteByKeys(idList);
	}

	/**
	 * 根据主键更新
	 * 
	 * @return
	 */
	public Integer updateSupplierMappingByKey(SupplierMapping supplierMapping) {
		return supplierMappingDao.updateSupplierMappingByKey(supplierMapping);
	}
	
	public Pager getSupplierMappingListWithPage(SupplierMappingQuery supplierMappingQuery) {
		Pager p = new Pager(supplierMappingQuery.getPageNo(),supplierMappingQuery.getPageSize(),supplierMappingDao.getSupplierMappingListCount(supplierMappingQuery));
		p.setList(supplierMappingDao.getSupplierMappingListWithPage(supplierMappingQuery));
		return p;
	}
	
	public List<SupplierMapping> getSupplierMappingList(SupplierMappingQuery supplierMappingQuery) {
		return supplierMappingDao.getSupplierMappingList(supplierMappingQuery);
	}

	@Override
	public Pager getSupplierMappingListWithPageByMulCondition(
			SupplierMappingQuery supplierMappingQuery) {
		Pager p = new Pager(supplierMappingQuery.getPageNo(),supplierMappingQuery.getPageSize(),supplierMappingCustomDao.getSupplierMappingListCountByMulCondition(supplierMappingQuery));
		p.setList(supplierMappingCustomDao.getSupplierMappingListWithPageByMulCondition(supplierMappingQuery));
		return p;
	}

	@Override
	public int getSupplierMappingListCountByMulCondition(
			SupplierMappingQuery supplierMappingQuery) {
		return supplierMappingCustomDao.getSupplierMappingListCountByMulCondition(supplierMappingQuery);
	}

	@Override
	public List<SupplierMapping> getSupplierMappingListByMulCondition(
			SupplierMappingQuery supplierMappingQuery) {
		return supplierMappingCustomDao.getSupplierMappingListByMulCondition(supplierMappingQuery);
	}
}
