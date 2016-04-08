package com.fjsaas.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fjsaas.web.pagination.Pager;
import com.fjsaas.web.bean.PartSort;
import com.fjsaas.web.dao.PartSortDao;
import com.fjsaas.web.query.PartSortQuery;
import com.fjsaas.web.service.PartSortService;


@Service
@Transactional
public class PartSortServiceImpl implements PartSortService {

	@Resource
	PartSortDao partSortDao;

	/**
	 * 插入数据库
	 * 
	 * @return
	 */
	public Integer addPartSort(PartSort partSort) {
		return partSortDao.addPartSort(partSort);
	}

	/**
	 * 根据主键查找
	 */
	@Transactional(readOnly = true)
	public PartSort getPartSortByKey(Integer id) {
		return partSortDao.getPartSortByKey(id);
	}
	
	@Transactional(readOnly = true)
	public List<PartSort> getPartSortsByKeys(List<Integer> idList) {
		return partSortDao.getPartSortsByKeys(idList);
	}

	/**
	 * 根据主键删除
	 * 
	 * @return
	 */
	public Integer deleteByKey(Integer id) {
		return partSortDao.deleteByKey(id);
	}

	public Integer deleteByKeys(List<Integer> idList) {
		return partSortDao.deleteByKeys(idList);
	}

	/**
	 * 根据主键更新
	 * 
	 * @return
	 */
	public Integer updatePartSortByKey(PartSort partSort) {
		return partSortDao.updatePartSortByKey(partSort);
	}
	
	@Transactional(readOnly = true)
	public Pager getPartSortListWithPage(PartSortQuery partSortQuery) {
		Pager p = new Pager(partSortQuery.getPageNo(),partSortQuery.getPageSize(),partSortDao.getPartSortListCount(partSortQuery));
		p.setList(partSortDao.getPartSortListWithPage(partSortQuery));
		return p;
	}
	
	@Transactional(readOnly = true)
	public List<PartSort> getPartSortList(PartSortQuery partSortQuery) {
		return partSortDao.getPartSortList(partSortQuery);
	}
}
