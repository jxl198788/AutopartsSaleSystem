package com.fjsaas.web.bean;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.quartz.Job;

public class TaskDetail {

	/** 任务id */
    private String jobId;
    /** 任务名称 */
    private String jobName;
    /** 任务分组 */
    private String jobGroup;
    /** 任务描述 */
    private String desc;
    /** 任务状态 0禁用 1启用 2删除*/ 
    private String jobStatus;
	private Class<? extends Job> job; 
    private String cronExpression;
    private Date startDate;
    private Date endDate;
    private Integer repeatCount = 0;
    private Integer repeatInterval = 0;
    
    private Map<String, Object> map = new HashMap<String, Object>();
    
    
	
	public TaskDetail(String jobName, String jobGroup, Class<? extends Job> job,
			String cronExpression) {
		super();
		this.jobName = jobName;
		this.jobGroup = jobGroup;
		this.job = job;
		this.cronExpression = cronExpression;
	}
	
	
	public TaskDetail(String jobName, String jobGroup, Class<? extends Job> job, Date startDate) {
		super();
		this.jobName = jobName;
		this.jobGroup = jobGroup;
		this.job = job;
		this.startDate = startDate;
	}



	public Class<? extends Job> getJob() {
		return job;
	}


	public void setJob(Class<? extends Job> job) {
		this.job = job;
	}


	public String getCronExpression() {
		return cronExpression;
	}
	public void setCronExpression(String cronExpression) {
		this.cronExpression = cronExpression;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public int getRepeatCount() {
		return repeatCount;
	}
	public void setRepeatCount(int repeatCount) {
		this.repeatCount = repeatCount;
	}
	public int getRepeatInterval() {
		return repeatInterval;
	}
	public void setRepeatInterval(int repeatInterval) {
		this.repeatInterval = repeatInterval;
	}


	public String getJobId() {
		return jobId;
	}


	public void setJobId(String jobId) {
		this.jobId = jobId;
	}


	public String getJobName() {
		return jobName;
	}


	public void setJobName(String jobName) {
		this.jobName = jobName;
	}


	public String getJobGroup() {
		return jobGroup;
	}


	public void setJobGroup(String jobGroup) {
		this.jobGroup = jobGroup;
	}


	public String getDesc() {
		return desc;
	}


	public void setDesc(String desc) {
		this.desc = desc;
	}


	public String getJobStatus() {
		return jobStatus;
	}


	public void setJobStatus(String jobStatus) {
		this.jobStatus = jobStatus;
	}


	public void setRepeatCount(Integer repeatCount) {
		this.repeatCount = repeatCount;
	}


	public void setRepeatInterval(Integer repeatInterval) {
		this.repeatInterval = repeatInterval;
	}


	public Map<String, Object> getMap() {
		return map;
	}


	public void setMap(Map<String, Object> map) {
		this.map = map;
	}
    
    
    
}
