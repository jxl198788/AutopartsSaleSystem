package com.fjsaas.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fjsaas.web.pagination.Pager;
import com.fjsaas.web.bean.Province;
import com.fjsaas.web.dao.ProvinceDao;
import com.fjsaas.web.query.ProvinceQuery;
import com.fjsaas.web.service.ProvinceService;


@Service
public class ProvinceServiceImpl implements ProvinceService {

	@Resource
	ProvinceDao provinceDao;

	/**
	 * 插入数据库
	 * 
	 * @return
	 */
	public Integer addProvince(Province province) {
		return provinceDao.addProvince(province);
	}

	/**
	 * 根据主键查找
	 */
	public Province getProvinceByKey(Integer id) {
		return provinceDao.getProvinceByKey(id);
	}
	
	public List<Province> getProvincesByKeys(List<Integer> idList) {
		return provinceDao.getProvincesByKeys(idList);
	}

	/**
	 * 根据主键删除
	 * 
	 * @return
	 */
	public Integer deleteByKey(Integer id) {
		return provinceDao.deleteByKey(id);
	}

	public Integer deleteByKeys(List<Integer> idList) {
		return provinceDao.deleteByKeys(idList);
	}

	/**
	 * 根据主键更新
	 * 
	 * @return
	 */
	public Integer updateProvinceByKey(Province province) {
		return provinceDao.updateProvinceByKey(province);
	}
	
	public Pager getProvinceListWithPage(ProvinceQuery provinceQuery) {
		Pager p = new Pager(provinceQuery.getPageNo(),provinceQuery.getPageSize(),provinceDao.getProvinceListCount(provinceQuery));
		p.setList(provinceDao.getProvinceListWithPage(provinceQuery));
		return p;
	}
	
	public List<Province> getProvinceList(ProvinceQuery provinceQuery) {
		return provinceDao.getProvinceList(provinceQuery);
	}
}
