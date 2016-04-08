package com.fjsaas.web.dao;

import java.util.List;

import com.fjsaas.web.bean.Task;
import com.fjsaas.web.query.TaskQuery;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskDao {

	/**
	 * 添加
	 * @param task
	 */
	public Integer addTask(Task task);

	/**
	 * 根据主键查找
	 * @param id
	 */
	public Task getTaskByKey(Integer id);

	/**
	 * 根据主键批量查找
	 * @param idList
	 */
	public List<Task> getTasksByKeys(List<Integer> idList);

	/**
	 * 根据主键删除
	 * @param id
	 */
	public Integer deleteByKey(Integer id);

	/**
	 * 根据主键批量删除
	 * @param idList
	 */
	public Integer deleteByKeys(List<Integer> idList);

	/**
	 * 根据主键更新
	 * @param task
	 */
	public Integer updateTaskByKey(Task task);

	/**
	 * 分页查询
	 * @param taskQuery
	 */
	public List<Task> getTaskListWithPage(TaskQuery taskQuery);

	/**
	 * 集合查询
	 * @param taskQuery
	 */
	public List<Task> getTaskList(TaskQuery taskQuery);
	
	/**
	 * 总条数
	 * @param taskQuery
	 */
	public int getTaskListCount(TaskQuery taskQuery);

}
