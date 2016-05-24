package com.fjsaas.web.service;

import java.util.List;
import java.util.Map;

import com.fjsaas.web.bean.Information;

public interface InformationService {
	//接口
	public Integer addInformation(Information information);
	
	public List<Information> querStatusByUser(Integer userId);
	
	public List<Information> querStatusByCheck(Integer checkId);
	
	 public void delInformationByUser(Integer userId,List<Integer> idsList);
	 
	 public void readInformationByUser(Integer userId,List<Integer> idsList);
	 
	 public void delInformationByCheck(Integer checkId,List<Integer> idsList);
	    
	 public void readInformationByCheck(Integer checkId,List<Integer> idsList);
	
	 public Integer countCreateStatusByUser(Integer userId);
	    
	 public Integer countCheckStatusByCheck(Integer checkId);

	 public void alldelInformationByUser(Integer id);
	    
	 public void alldelInformationByCheck(Integer id);
	    
	 public void allreadInformationByUser(Integer id);
	    
	 public void allreadInformationByCheck(Integer id);
	 

}
