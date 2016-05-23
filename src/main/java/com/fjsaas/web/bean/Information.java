package com.fjsaas.web.bean;

import java.io.Serializable;

public class Information implements Serializable {
	/**
	 * 序列化ID
	 */
	private static final long serialVersionUID = 1L;
	  
	private Integer id;
	private String newsConent;
	private Integer createId;
	private Integer checkRole;
	private String createStatus;
	private String checkStatus;
	private String isdel;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNewsConent() {
		return newsConent;
	}
	public void setNewsConent(String newsConent) {
		this.newsConent = newsConent;
	}
	public Integer getCreateId() {
		return createId;
	}
	public void setCreateId(Integer createId) {
		this.createId = createId;
	}
	public Integer getCheckRole() {
		return checkRole;
	}
	public void setCheckId(Integer checkRole) {
		this.checkRole = checkRole;
	}
	public String getCreateStatus() {
		return createStatus;
	}
	public void setCreateStatus(String createStatus) {
		this.createStatus = createStatus;
	}
	public String getCheckStatus() {
		return checkStatus;
	}
	public void setCheckStatus(String checkStatus) {
		this.checkStatus = checkStatus;
	}
	public String getIsdel() {
		return isdel;
	}
	public void setIsdel(String isdel) {
		this.isdel = isdel;
	}

	public String toString() {
		return "Information [id=" + id + ", newsConent=" + newsConent
				+ ", createId=" + createId + ", checkId=" + checkRole
				+ ", createStatus=" + createStatus + ", checkStatus="
				+ checkStatus + ", isdel=" + isdel + "]";
	}
	
	
	
	
	
	
	
	
}
