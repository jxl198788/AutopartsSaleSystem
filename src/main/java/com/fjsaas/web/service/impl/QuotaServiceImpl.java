package com.fjsaas.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fjsaas.web.pagination.Pager;
import com.fjsaas.web.bean.Quota;
import com.fjsaas.web.dao.QuotaDao;
import com.fjsaas.web.query.QuotaQuery;
import com.fjsaas.web.service.QuotaService;


@Service
public class QuotaServiceImpl implements QuotaService {

	@Resource
	QuotaDao quotaDao;

	/**
	 * 插入数据库
	 * 
	 * @return
	 */
	public Integer addQuota(Quota quota) {
		return quotaDao.addQuota(quota);
	}

	/**
	 * 根据主键查找
	 */
	public Quota getQuotaByKey(Integer id) {
		return quotaDao.getQuotaByKey(id);
	}
	
	public List<Quota> getQuotasByKeys(List<Integer> idList) {
		return quotaDao.getQuotasByKeys(idList);
	}

	/**
	 * 根据主键删除
	 * 
	 * @return
	 */
	public Integer deleteByKey(Integer id) {
		return quotaDao.deleteByKey(id);
	}

	public Integer deleteByKeys(List<Integer> idList) {
		return quotaDao.deleteByKeys(idList);
	}

	/**
	 * 根据主键更新
	 * 
	 * @return
	 */
	public Integer updateQuotaByKey(Quota quota) {
		return quotaDao.updateQuotaByKey(quota);
	}
	
	public Pager getQuotaListWithPage(QuotaQuery quotaQuery) {
		Pager p = new Pager(quotaQuery.getPageNo(),quotaQuery.getPageSize(),quotaDao.getQuotaListCount(quotaQuery));
		p.setList(quotaDao.getQuotaListWithPage(quotaQuery));
		return p;
	}
	
	public List<Quota> getQuotaList(QuotaQuery quotaQuery) {
		return quotaDao.getQuotaList(quotaQuery);
	}
}
