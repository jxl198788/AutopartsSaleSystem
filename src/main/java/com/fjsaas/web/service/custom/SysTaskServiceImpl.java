package com.fjsaas.web.service.custom;

import java.text.ParseException;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleTrigger;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.quartz.impl.triggers.CronTriggerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Service;

import com.fjsaas.web.bean.TaskDetail;
import com.fjsaas.web.constants.Constants;

@Service
public class SysTaskServiceImpl {

	@Autowired
	private SchedulerFactoryBean schedulerFactoryBean;

	public void runTasks(TaskDetail taskDetail) throws SchedulerException, ParseException {
		Scheduler scheduler = schedulerFactoryBean.getScheduler();
		JobKey jobKey = new JobKey(taskDetail.getJobName(), taskDetail.getJobGroup());
		scheduler.deleteJob(jobKey);
		JobDetail jobDetail = JobBuilder.newJob(taskDetail.getJob()).withIdentity(jobKey).build();
		jobDetail.getJobDataMap().put(Constants.JOB_KEY, taskDetail);
		Trigger trigger = null;
		TriggerKey triggerKey = new TriggerKey(taskDetail.getJobName(),
				taskDetail.getJobGroup());
		if (taskDetail.getCronExpression() != null) {
			CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(taskDetail.getCronExpression());
			trigger = TriggerBuilder.newTrigger().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();
		} else {
			trigger = TriggerBuilder.newTrigger().withIdentity(triggerKey).startAt(taskDetail.getStartDate()).build();
		}
		scheduler.scheduleJob(jobDetail, trigger);
	}
}
