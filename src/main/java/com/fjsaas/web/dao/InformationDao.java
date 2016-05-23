package com.fjsaas.web.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.fjsaas.web.bean.Information;


@Repository
public interface InformationDao {
	
	public Integer addInformation(Information information);
	
	public List<Information> querStatusByUser(Map<String,Object> map);
	
    public List<Information> querStatusByCheck(Map<String,Object> map);
    
    public void delInformationByUser(Map<String,Object> map);
    
    public void readInformationByUser(Map<String,Object> map);
    
    public void delInformationByCheck(Map<String,Object> map);
    
    public void readInformationByCheck(Map<String,Object> map);
    
    public Integer countCreateStatusByUser(Map<String,Object> map);
    
    public Integer countCheckStatusByCheck(Map<String,Object> map);
    
    public List<Information> querStatusByUserForPage(Map<String,Object> map);
    
    public List<Information> querStatusByCheckForPage(Map<String,Object> map);
    
    public void alldelInformationByUser(Map<String,Object> map);
    
    public void alldelInformationByCheck(Map<String,Object> map);
    
    public void allreadInformationByUser(Map<String,Object> map);
    
    public void allreadInformationByCheck(Map<String,Object> map);
    
}
