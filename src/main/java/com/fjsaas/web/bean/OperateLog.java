package com.fjsaas.web.bean;

import java.util.*;
import java.io.Serializable;
import java.math.BigDecimal;


public class OperateLog implements Serializable {
	/**
	 * 序列化ID
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String type;
	private String content;
	private Integer userId;
	private String userName;
	private String userCompany;
	private String operationTime;
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
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public Integer getUserId() {
		return userId;
	}
	
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getUserCompany() {
		return userCompany;
	}
	
	public void setUserCompany(String userCompany) {
		this.userCompany = userCompany;
	}
	
	public String getOperationTime() {
		return operationTime;
	}
	
	public void setOperationTime(String operationTime) {
		this.operationTime = operationTime;
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
		return "OperateLog [id=" + id + ",type=" + type + ",content=" + content + ",userId=" + userId + ",userName=" + userName + ",userCompany=" + userCompany + ",operationTime=" + operationTime + ",createDate=" + createDate + ",creatorId=" + creatorId + ",updateDate=" + updateDate + ",updatorId=" + updatorId + ",isDel=" + isDel + "]";
	}
	
	
}