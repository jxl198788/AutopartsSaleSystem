package com.fjsaas.web.service;

import java.util.List;

import com.fjsaas.web.pagination.Pager;
import com.fjsaas.web.bean.Task;
import com.fjsaas.web.query.TaskQuery;


public interface TaskService {
	/**
	 * 基本插入
	 * 
	 * @return
	 */
	public Integer addTask(Task task);

	/**
	 * 根据主键查询
	 */
	public Task getTaskByKey(Integer id);

	/**
	 * 根据主键批量查询
	 */
	public List<Task> getTasksByKeys(List<Integer> idList);

	/**
	 * 根据主键删除
	 * 
	 * @return
	 */
	public Integer deleteByKey(Integer id);

	/**
	 * 根据主键批量删除
	 * 
	 * @return
	 */
	public Integer deleteByKeys(List<Integer> idList);

	/**
	 * 根据主键更新
	 * 
	 * @return
	 */
	public Integer updateTaskByKey(Task task);

	/**
	 * 根据条件查询分页查询
	 * 
	 * @param taskQuery
	 *            查询条件
	 * @return
	 */
	public Pager getTaskListWithPage(TaskQuery taskQuery);

	/**
	 * 根据条件查询
	 * 
	 * @param taskQuery
	 *            查询条件
	 * @return
	 */
	public List<Task> getTaskList(TaskQuery taskQuery);
	
}
