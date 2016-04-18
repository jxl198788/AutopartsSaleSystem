package com.fjsaas.web.bean;

import java.util.*;
import java.io.Serializable;
import java.math.BigDecimal;


public class Task implements Serializable {
	/**
	 * 序列化ID
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String code;
	private String title;
	private Integer submitUserId;
	private Date submitDate;
	private Integer roleId;
	private Integer finishUserId;
	private Date endDate;
	private String status;
	private Date createDate;
	private Integer creatorId;
	private Date updateDate;
	private Integer updatorId;
	private String isDel;

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public Integer getSubmitUserId() {
		return submitUserId;
	}
	
	public void setSubmitUserId(Integer submitUserId) {
		this.submitUserId = submitUserId;
	}
	
	public Date getSubmitDate() {
		return submitDate;
	}
	
	public void setSubmitDate(Date submitDate) {
		this.submitDate = submitDate;
	}
	
	public Integer getRoleId() {
		return roleId;
	}
	
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	
	public Integer getFinishUserId() {
		return finishUserId;
	}
	
	public void setFinishUserId(Integer finishUserId) {
		this.finishUserId = finishUserId;
	}
	
	public Date getEndDate() {
		return endDate;
	}
	
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public Date getCreateDate() {
		return createDate;
	}
	
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	public Integer getCreatorId() {
		return creatorId;
	}
	
	public void setCreatorId(Integer creatorId) {
		this.creatorId = creatorId;
	}
	
	public Date getUpdateDate() {
		return updateDate;
	}
	
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
	public Integer getUpdatorId() {
		return updatorId;
	}
	
	public void setUpdatorId(Integer updatorId) {
		this.updatorId = updatorId;
	}
	
	public String getIsDel() {
		return isDel;
	}
	
	public void setIsDel(String isDel) {
		this.isDel = isDel;
	}
	
	public String toString() {
		return "Task [id=" + id + ",code=" + code + ",title=" + title + ",submitUserId=" + submitUserId + ",submitDate=" + submitDate + ",roleId=" + roleId + ",finishUserId=" + finishUserId + ",endDate=" + endDate + ",status=" + status + ",createDate=" + createDate + ",creatorId=" + creatorId + ",updateDate=" + updateDate + ",updatorId=" + updatorId + ",isDel=" + isDel + "]";
	}
	
	
}