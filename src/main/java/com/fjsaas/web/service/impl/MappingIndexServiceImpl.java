package com.fjsaas.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fjsaas.web.pagination.Pager;
import com.fjsaas.web.bean.MappingIndex;
import com.fjsaas.web.dao.MappingIndexDao;
import com.fjsaas.web.query.MappingIndexQuery;
import com.fjsaas.web.service.MappingIndexService;


@Service
public class MappingIndexServiceImpl implements MappingIndexService {

	@Resource
	MappingIndexDao mappingIndexDao;

	/**
	 * 插入数据库
	 * 
	 * @return
	 */
	public Integer addMappingIndex(MappingIndex mappingIndex) {
		return mappingIndexDao.addMappingIndex(mappingIndex);
	}

	/**
	 * 根据主键查找
	 */
	public MappingIndex getMappingIndexByKey(Integer id) {
		return mappingIndexDao.getMappingIndexByKey(id);
	}
	
	public List<MappingIndex> getMappingIndexsByKeys(List<Integer> idList) {
		return mappingIndexDao.getMappingIndexsByKeys(idList);
	}

	/**
	 * 根据主键删除
	 * 
	 * @return
	 */
	public Integer deleteByKey(Integer id) {
		return mappingIndexDao.deleteByKey(id);
	}

	public Integer deleteByKeys(List<Integer> idList) {
		return mappingIndexDao.deleteByKeys(idList);
	}

	/**
	 * 根据主键更新
	 * 
	 * @return
	 */
	public Integer updateMappingIndexByKey(MappingIndex mappingIndex) {
		return mappingIndexDao.updateMappingIndexByKey(mappingIndex);
	}
	
	public Pager getMappingIndexListWithPage(MappingIndexQuery mappingIndexQuery) {
		Pager p = new Pager(mappingIndexQuery.getPageNo(),mappingIndexQuery.getPageSize(),mappingIndexDao.getMappingIndexListCount(mappingIndexQuery));
		p.setList(mappingIndexDao.getMappingIndexListWithPage(mappingIndexQuery));
		return p;
	}
	
	public List<MappingIndex> getMappingIndexList(MappingIndexQuery mappingIndexQuery) {
		return mappingIndexDao.getMappingIndexList(mappingIndexQuery);
	}
}
