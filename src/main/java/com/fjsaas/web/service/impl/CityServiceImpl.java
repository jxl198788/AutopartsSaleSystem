package com.fjsaas.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fjsaas.web.pagination.Pager;
import com.fjsaas.web.bean.City;
import com.fjsaas.web.dao.CityDao;
import com.fjsaas.web.query.CityQuery;
import com.fjsaas.web.service.CityService;


@Service
@Transactional
public class CityServiceImpl implements CityService {

	@Resource
	CityDao cityDao;

	/**
	 * 插入数据库
	 * 
	 * @return
	 */
	public Integer addCity(City city) {
		return cityDao.addCity(city);
	}

	/**
	 * 根据主键查找
	 */
	@Transactional(readOnly = true)
	public City getCityByKey(Integer id) {
		return cityDao.getCityByKey(id);
	}
	
	@Transactional(readOnly = true)
	public List<City> getCitysByKeys(List<Integer> idList) {
		return cityDao.getCitysByKeys(idList);
	}

	/**
	 * 根据主键删除
	 * 
	 * @return
	 */
	public Integer deleteByKey(Integer id) {
		return cityDao.deleteByKey(id);
	}

	public Integer deleteByKeys(List<Integer> idList) {
		return cityDao.deleteByKeys(idList);
	}

	/**
	 * 根据主键更新
	 * 
	 * @return
	 */
	public Integer updateCityByKey(City city) {
		return cityDao.updateCityByKey(city);
	}
	
	@Transactional(readOnly = true)
	public Pager getCityListWithPage(CityQuery cityQuery) {
		Pager p = new Pager(cityQuery.getPageNo(),cityQuery.getPageSize(),cityDao.getCityListCount(cityQuery));
		p.setList(cityDao.getCityListWithPage(cityQuery));
		return p;
	}
	
	@Transactional(readOnly = true)
	public List<City> getCityList(CityQuery cityQuery) {
		return cityDao.getCityList(cityQuery);
	}
}
