package com.fjsaas.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fjsaas.web.pagination.Pager;
import com.fjsaas.web.bean.Task;
import com.fjsaas.web.dao.TaskDao;
import com.fjsaas.web.query.TaskQuery;
import com.fjsaas.web.service.TaskService;


@Service
public class TaskServiceImpl implements TaskService {

	@Resource
	TaskDao taskDao;

	/**
	 * 插入数据库
	 * 
	 * @return
	 */
	public Integer addTask(Task task) {
		return taskDao.addTask(task);
	}

	/**
	 * 根据主键查找
	 */
	public Task getTaskByKey(Integer id) {
		return taskDao.getTaskByKey(id);
	}
	
	public List<Task> getTasksByKeys(List<Integer> idList) {
		return taskDao.getTasksByKeys(idList);
	}

	/**
	 * 根据主键删除
	 * 
	 * @return
	 */
	public Integer deleteByKey(Integer id) {
		return taskDao.deleteByKey(id);
	}

	public Integer deleteByKeys(List<Integer> idList) {
		return taskDao.deleteByKeys(idList);
	}

	/**
	 * 根据主键更新
	 * 
	 * @return
	 */
	public Integer updateTaskByKey(Task task) {
		return taskDao.updateTaskByKey(task);
	}
	
	public Pager getTaskListWithPage(TaskQuery taskQuery) {
		Pager p = new Pager(taskQuery.getPageNo(),taskQuery.getPageSize(),taskDao.getTaskListCount(taskQuery));
		p.setList(taskDao.getTaskListWithPage(taskQuery));
		return p;
	}
	
	public List<Task> getTaskList(TaskQuery taskQuery) {
		return taskDao.getTaskList(taskQuery);
	}
}
