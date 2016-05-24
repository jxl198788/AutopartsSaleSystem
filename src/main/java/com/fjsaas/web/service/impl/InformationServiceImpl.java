package com.fjsaas.web.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Service;

import com.fjsaas.web.bean.Information;
import com.fjsaas.web.dao.InformationDao;
import com.fjsaas.web.service.InformationService;

@Service
public class InformationServiceImpl implements InformationService {
	
	@Resource
	private InformationDao dao;//链接数据库dao层

	@Override
	public Integer addInformation(Information information) {
		
		return dao.addInformation(information);
	}

	@Override
	public List<Information> querStatusByUser(Integer userId) {
	    Map<String,Object> map = new HashMap<String, Object>();
	    map.put("id", userId);
		return dao.querStatusByCheck(map);
	}

	@Override
	public List<Information> querStatusByCheck(Integer checkId) {
		 Map<String,Object> map = new HashMap<String, Object>();
		 map.put("id", checkId);
		return dao.querStatusByCheck(map);
	}

	@Override
	public void delInformationByUser(Integer userId, List<Integer> idsList) {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("userId", userId);
		map.put("list", idsList);
		dao.delInformationByCheck(map);
	}

	@Override
	public void readInformationByUser(Integer userId, List<Integer> idsList) {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("userId", userId);
		map.put("list", idsList);
		dao.readInformationByUser(map);
		
	}

	@Override
	public void delInformationByCheck(Integer checkId, List<Integer> idsList) {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("checkId", checkId);
		map.put("list", idsList);
		dao.delInformationByCheck(map);
		
	}

	@Override
	public void readInformationByCheck(Integer checkId,
			List<Integer> idsList) {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("checkId", checkId);
		map.put("list", idsList);
		dao.readInformationByCheck(map);
		
	}

	@Override
	public Integer countCreateStatusByUser(Integer userId) {
		int i = 0;
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("id", userId);
		i = dao.countCheckStatusByCheck(map);
		return i;
	}

	@Override
	public Integer countCheckStatusByCheck(Integer checkId) {
		int i = 0;
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("id", checkId);
		i = dao.countCheckStatusByCheck(map);
		return i;
	}

	@Override
	public void alldelInformationByUser(Integer id) {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("id", id);
	    dao.alldelInformationByUser(map);
		
	}

	@Override
	public void alldelInformationByCheck(Integer id) {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("id", id);
	    dao.alldelInformationByCheck(map);
		
	}

	@Override
	public void allreadInformationByUser(Integer id) {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("id", id);
		dao.allreadInformationByUser(map);
	}

	@Override
	public void allreadInformationByCheck(Integer id) {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("id", id);
		dao.allreadInformationByCheck(map);
	}



	
}
