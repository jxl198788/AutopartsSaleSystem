package com.fjsaas.web.dao;

import java.util.List;

import com.fjsaas.web.bean.MappingIndex;
import com.fjsaas.web.bean.SupplierMapping;
import com.fjsaas.web.query.MappingIndexQuery;
import com.fjsaas.web.query.SupplierMappingQuery;

import org.springframework.stereotype.Repository;

@Repository
public interface MappingIndexCustomDao {
	
	public Integer updateMappingIndexByMappingId(MappingIndex mappingIndex);
	
	public List<MappingIndex> getMappingIndexListWithPageByMulCondition(MappingIndexQuery mappingIndexQuery);

	public int getMappingIndexListCountByMulCondition(MappingIndexQuery mappingIndexQuery);
	
	public List<MappingIndex> getMappingIndexListByMulCondition(MappingIndexQuery mappingIndexQuery);
	
	
	
	
	
	
	
}
