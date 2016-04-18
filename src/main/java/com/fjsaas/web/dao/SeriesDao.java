package com.fjsaas.web.dao;

import java.util.List;

import com.fjsaas.web.bean.Series;
import com.fjsaas.web.query.SeriesQuery;
import org.springframework.stereotype.Repository;

@Repository
public interface SeriesDao {

	/**
	 * 添加
	 * @param series
	 */
	public Integer addSeries(Series series);

	/**
	 * 根据主键查找
	 * @param id
	 */
	public Series getSeriesByKey(Integer id);

	/**
	 * 根据主键批量查找
	 * @param idList
	 */
	public List<Series> getSeriessByKeys(List<Integer> idList);

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
	 * @param series
	 */
	public Integer updateSeriesByKey(Series series);

	/**
	 * 分页查询
	 * @param seriesQuery
	 */
	public List<Series> getSeriesListWithPage(SeriesQuery seriesQuery);

	/**
	 * 集合查询
	 * @param seriesQuery
	 */
	public List<Series> getSeriesList(SeriesQuery seriesQuery);
	
	/**
	 * 总条数
	 * @param seriesQuery
	 */
	public int getSeriesListCount(SeriesQuery seriesQuery);

}
