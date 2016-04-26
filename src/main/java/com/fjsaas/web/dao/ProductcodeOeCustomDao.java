package com.fjsaas.web.dao;

import java.util.HashMap;
import java.util.List;

import com.fjsaas.web.bean.ProductcodeOe;
import com.fjsaas.web.query.ProductcodeOeQuery;

import org.springframework.stereotype.Repository;

@Repository
public interface ProductcodeOeCustomDao {
	
	public List<ProductcodeOe> getProductcodeOesByProductCode(HashMap<String, Object> map);
	
	public List<ProductcodeOe> getProductcodeOesByOeCode(HashMap<String, Object> map);
	
	public List<ProductcodeOe> getProductcodeOesByReferenceCode(HashMap<String, Object> map);
		
}
