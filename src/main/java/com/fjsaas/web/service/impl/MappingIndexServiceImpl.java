package com.fjsaas.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fjsaas.web.pagination.Pager;
import com.fjsaas.web.bean.MappingIndex;
import com.fjsaas.web.dao.MappingIndexCustomDao;
import com.fjsaas.web.dao.MappingIndexDao;
import com.fjsaas.web.query.MappingIndexQuery;
import com.fjsaas.web.service.MappingIndexService;


@Service
public class MappingIndexServiceImpl implements MappingIndexService {

	@Resource
	MappingIndexDao mappingIndexDao;
	
	@Resource
	private MappingIndexCustomDao mappingIndexCustomDao;

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

	@Override
	public Integer updateMappingIndexByMappingId(MappingIndex mappingIndex) {
		// TODO Auto-generated method stub
		return mappingIndexCustomDao.updateMappingIndexByMappingId(mappingIndex);
	}

	@Override
	public Pager getMappingIndexListWithPageByMulCondition(
			MappingIndexQuery mappingIndexQuery) {
		
		// TODO Auto-generated method stub
		Pager p = new Pager(mappingIndexQuery.getPageNo(),mappingIndexQuery.getPageSize(),mappingIndexCustomDao.getMappingIndexListCountByMulCondition(mappingIndexQuery));
		List<MappingIndex> list = mappingIndexCustomDao.getMappingIndexListWithPageByMulCondition(mappingIndexQuery);
		for (MappingIndex mappingIndex : list) {
			MappingIndexQuery query = new MappingIndexQuery();
			query.setMappingId(mappingIndex.getMappingId());
			query.setSupplierId(mappingIndex.getSupplierId());
			query.setProductCode(mappingIndex.getProductCode());
			List<MappingIndex> mappingIndexList = getMappingIndexList(query);
			for (MappingIndex mappingIndex2 : mappingIndexList) {
				mappingIndex.getAutoTypes().add(mappingIndex2.getAutoTypeId());
			}
		}
		p.setList(list);
		return p;
	}

	@Override
	public int getMappingIndexListCountByMulCondition(
			MappingIndexQuery mappingIndexQuery) {
		// TODO Auto-generated method stub
		return mappingIndexCustomDao.getMappingIndexListCountByMulCondition(mappingIndexQuery);
	}

	@Override
	public List<MappingIndex> getMappingIndexListByMulCondition(
			MappingIndexQuery mappingIndexQuery) {
		// TODO Auto-generated method stub
		List<MappingIndex> list = mappingIndexCustomDao.getMappingIndexListByMulCondition(mappingIndexQuery);
		for (MappingIndex mappingIndex : list) {
			MappingIndexQuery query = new MappingIndexQuery();
			query.setMappingId(mappingIndex.getMappingId());
			query.setSupplierId(mappingIndex.getSupplierId());
			query.setProductCode(mappingIndex.getProductCode());
			List<MappingIndex> mappingIndexList = getMappingIndexList(query);
			for (MappingIndex mappingIndex2 : mappingIndexList) {
				mappingIndex.getAutoTypes().add(mappingIndex2.getAutoTypeId());
			}
		}
		return list;
	}
}
