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
import com.fjsaas.web.bean.SupplierTask;
import com.fjsaas.web.bean.TaskDetail;
import com.fjsaas.web.constants.Constants;
import com.fjsaas.web.service.MappingIndexService;
import com.fjsaas.web.service.ProductcodeOeService;
import com.fjsaas.web.service.SupplierTaskService;

public class MappingIndexAddjob implements Job {

	@Override
	public void execute(JobExecutionContext content) throws JobExecutionException {
		JobDataMap dataMap = content.getMergedJobDataMap();
		TaskDetail taskDetail = (TaskDetail) dataMap.get(Constants.JOB_KEY);
		ApplicationContext applicationContext = (ApplicationContext) taskDetail.getMap().get(Constants.APPLICATION_CONTEXT);
		ProductcodeOeService productcodeOeService = applicationContext.getBean(ProductcodeOeService.class);
		MappingIndexService mappingIndexService = applicationContext.getBean(MappingIndexService.class);
		SupplierTaskService supplierTaskService = applicationContext.getBean(SupplierTaskService.class);
		//TODO 任务表插入
		SupplierTask supplierTask = new SupplierTask();
		supplierTask.setName(taskDetail.getJobName());
		supplierTask.setGroupName(taskDetail.getJobGroup());
		supplierTask.setDescription(taskDetail.getDesc());
		supplierTask.setType("SimpleTrigger");
		supplierTask.setCreateDate(new Date());
		supplierTask.setCreatorId(-1);//系统
		supplierTask.setStatus("0");//任务进行中...
		supplierTaskService.addSupplierTask(supplierTask);
		System.err.println(taskDetail.getJobName()+"-"+taskDetail.getJobGroup()+"任务启动："+new Date());
		
		List<SupplierMapping> supplierMappings = (List<SupplierMapping>) taskDetail.getMap().get(Constants.MAPPING_DATA);
		for (SupplierMapping supplierMapping : supplierMappings) {
			List<MappingIndex> mappingIndexs = productcodeOeService.InferMappingIndexs(supplierMapping);
			if(mappingIndexs!=null && mappingIndexs.size()>0){
				for (MappingIndex mappingIndex : mappingIndexs) {
					mappingIndexService.addMappingIndex(mappingIndex);
				}	
			}
		}
		
		supplierTask.setStatus("1");//任务执行完成
		supplierTask.setEndDate(new Date());
		supplierTaskService.updateSupplierTaskByKey(supplierTask);
				
		System.err.println(taskDetail.getJobName()+"-"+taskDetail.getJobGroup()+"任务结束："+new Date());
	}

}
