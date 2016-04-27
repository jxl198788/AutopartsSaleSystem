package com.fjsaas.web.dao;

import java.util.List;

import com.fjsaas.web.bean.MappingIndex;
import com.fjsaas.web.query.MappingIndexQuery;
import org.springframework.stereotype.Repository;

@Repository
public interface MappingIndexCsutomDao {
	
	public Integer updateMappingIndexByMappingId(MappingIndex mappingIndex);
	
}
