package com.fjsaas.web.service;

import java.util.List;

import com.fjsaas.web.pagination.Pager;
import com.fjsaas.web.bean.Quota;
import com.fjsaas.web.bean.UserQuotas;
import com.fjsaas.web.query.QuotaQuery;


public interface QuotaService {
	/**
	 * 基本插入
	 * 
	 * @return
	 */
	public Integer addQuota(Quota quota);

	/**
	 * 根据主键查询
	 */
	public Quota getQuotaByKey(Integer id);

	/**
	 * 根据主键批量查询
	 */
	public List<Quota> getQuotasByKeys(List<Integer> idList);

	/**
	 * 根据主键删除
	 * 
	 * @return
	 */
	public Integer deleteByKey(Integer id);

	/**
	 * 根据主键批量删除
	 * 
	 * @return
	 */
	public Integer deleteByKeys(List<Integer> idList);

	/**
	 * 根据主键更新
	 * 
	 * @return
	 */
	public Integer updateQuotaByKey(Quota quota);

	/**
	 * 根据条件查询分页查询
	 * 
	 * @param quotaQuery
	 *            查询条件
	 * @return
	 */
	public Pager getQuotaListWithPage(QuotaQuery quotaQuery);

	/**
	 * 根据条件查询
	 * 
	 * @param quotaQuery
	 *            查询条件
	 * @return
	 */
	public List<Quota> getQuotaList(QuotaQuery quotaQuery);
	
//add by lyn ------------------------------------------------begin

	/**
	 * 平台的配额管理页面
	 * 根据条件查询
	 * 
	 * @param quotaQuery
	 *            查询条件
	 * @return
	 */
	public List<UserQuotas> getUserQuotaList(QuotaQuery quotaQuery);
	
	/**
	 * 根据主键批量查询
	 */
	public List<UserQuotas> getUserQuotasByKeys(List<Integer> idList);

	/**
	 * 根据主键批量查询
	 */
	public UserQuotas getUserQuotasByKey(Integer id);
	
	/**
	 * 根据主键更新
	 * 
	 * @return
	 */
	public Integer updateUserQuotaByKey(UserQuotas userquotas);

	/**
	 * 基本插入
	 * 
	 * @return
	 */
	public Integer addUserQuota(UserQuotas userquotas);
	
	/**
	 * 根据主键查询树结构
	 */
	public List<UserQuotas> getTreeDataByKey(UserQuotas userquotas);

	/**
	 * 根据主键查询树结构
	 */
	public List<UserQuotas> getTreeUserByKey(UserQuotas userquotas);
//add by lyn ------------------------------------------------end
	
}
