package com.fjsaas.web.dao;

import java.util.List;

import com.fjsaas.web.bean.Quota;
import com.fjsaas.web.bean.UserQuotas;
import com.fjsaas.web.query.QuotaQuery;

import org.springframework.stereotype.Repository;

@Repository
public interface QuotaDao {

	/**
	 * 添加
	 * @param quota
	 */
	public Integer addQuota(Quota quota);

	/**
	 * 根据主键查找
	 * @param id
	 */
	public Quota getQuotaByKey(Integer id);

	/**
	 * 根据主键批量查找
	 * @param idList
	 */
	public List<Quota> getQuotasByKeys(List<Integer> idList);

	/**
	 * 根据主键删除
	 * @param id
	 */
	public Integer deleteByKey(Integer id);

	/**
	 * 根据主键批量删除
	 * @param idList
	 */
	public Integer deleteByKeys(List<Integer> idList);

	/**
	 * 根据主键更新
	 * @param quota
	 */
	public Integer updateQuotaByKey(Quota quota);

	/**
	 * 分页查询
	 * @param quotaQuery
	 */
	public List<Quota> getQuotaListWithPage(QuotaQuery quotaQuery);

	/**
	 * 集合查询
	 * @param quotaQuery
	 */
	public List<Quota> getQuotaList(QuotaQuery quotaQuery);
	
	/**
	 * 总条数
	 * @param quotaQuery
	 */
	public int getQuotaListCount(QuotaQuery quotaQuery);

	//add by lyn ------------------------------------------------begin
	
	/**
	 * 集合查询
	 * @param quotaQuery
	 */
	public List<UserQuotas> getUserQuotaList(QuotaQuery quotaQuery);

	/**
	 * 根据主键批量查找
	 * @param idList
	 */
	public List<UserQuotas> getUserQuotasByKeys(List<Integer> idList);

	/**
	 * 根据主键批量查找
	 * @param idList
	 */
	public UserQuotas getUserQuotasByKey(Integer id);

	/**
	 * 根据主键更新
	 * @param quota
	 */
	public Integer updateUserQuotaByKey(UserQuotas userquotas);
	//add by lyn ------------------------------------------------end
}
