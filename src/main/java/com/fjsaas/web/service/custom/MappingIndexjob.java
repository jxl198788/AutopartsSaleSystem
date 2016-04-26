package com.fjsaas.web.service.custom;

import java.util.Date;
import java.util.List;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.context.ApplicationContext;

import com.fjsaas.web.bean.MappingIndex;
import com.fjsaas.web.bean.SupplierMapping;
import com.fjsaas.web.bean.TaskDetail;
import com.fjsaas.web.constants.Constants;
import com.fjsaas.web.service.MappingIndexService;
import com.fjsaas.web.service.ProductcodeOeService;
import com.fjsaas.web.service.impl.MappingIndexServiceImpl;
import com.fjsaas.web.service.impl.ProductcodeOeServiceImpl;

public class MappingIndexjob implements Job {

	private ProductcodeOeService productcodeOeService;
	private MappingIndexService mappingIndexService;
	
	@Override
	public void execute(JobExecutionContext content) throws JobExecutionException {
		//TODO 任务表插入
		JobDataMap dataMap = content.getMergedJobDataMap();
		TaskDetail taskDetail = (TaskDetail) dataMap.get(Constants.JOB_KEY);
		ApplicationContext applicationContext = (ApplicationContext) taskDetail.getMap().get(Constants.APPLICATION_CONTEXT);
		productcodeOeService = applicationContext.getBean(ProductcodeOeService.class);
		mappingIndexService = applicationContext.getBean(MappingIndexService.class);
		System.err.println("任务启动："+new Date());
		System.out.println(taskDetail.getJobName()+":"+taskDetail.getJobGroup());
		
		List<SupplierMapping> supplierMappings = (List<SupplierMapping>) taskDetail.getMap().get(Constants.MAPPING_DATA);
		for (SupplierMapping supplierMapping : supplierMappings) {
			List<MappingIndex> mappingIndexs = productcodeOeService.InferMappingIndexs(supplierMapping);
			if(mappingIndexs!=null && mappingIndexs.size()>0){
				for (MappingIndex mappingIndex : mappingIndexs) {
					mappingIndexService.addMappingIndex(mappingIndex);
				}	
			}
		}
		
		System.err.println("任务结束："+new Date());
	}

}
