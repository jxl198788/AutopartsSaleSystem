package com.fjsaas.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fjsaas.web.pagination.Pager;
import com.fjsaas.web.bean.Series;
import com.fjsaas.web.dao.SeriesDao;
import com.fjsaas.web.query.SeriesQuery;
import com.fjsaas.web.service.SeriesService;


@Service
public class SeriesServiceImpl implements SeriesService {

	@Resource
	SeriesDao seriesDao;

	/**
	 * 插入数据库
	 * 
	 * @return
	 */
	public Integer addSeries(Series series) {
		return seriesDao.addSeries(series);
	}

	/**
	 * 根据主键查找
	 */
	public Series getSeriesByKey(Integer id) {
		return seriesDao.getSeriesByKey(id);
	}
	
	public List<Series> getSeriessByKeys(List<Integer> idList) {
		return seriesDao.getSeriessByKeys(idList);
	}

	/**
	 * 根据主键删除
	 * 
	 * @return
	 */
	public Integer deleteByKey(Integer id) {
		return seriesDao.deleteByKey(id);
	}

	public Integer deleteByKeys(List<Integer> idList) {
		return seriesDao.deleteByKeys(idList);
	}

	/**
	 * 根据主键更新
	 * 
	 * @return
	 */
	public Integer updateSeriesByKey(Series series) {
		return seriesDao.updateSeriesByKey(series);
	}
	
	public Pager getSeriesListWithPage(SeriesQuery seriesQuery) {
		Pager p = new Pager(seriesQuery.getPageNo(),seriesQuery.getPageSize(),seriesDao.getSeriesListCount(seriesQuery));
		p.setList(seriesDao.getSeriesListWithPage(seriesQuery));
		return p;
	}
	
	public List<Series> getSeriesList(SeriesQuery seriesQuery) {
		return seriesDao.getSeriesList(seriesQuery);
	}
}
