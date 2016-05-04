package com.fjsaas.web.bean;

import java.util.*;
import java.io.Serializable;
import java.math.BigDecimal;


public class Image implements Serializable {
	/**
	 * 序列化ID
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;
	private String url;
	private String groupId;
	private String isDef;
	private Date createDate;
	private Integer creatorId;
	private Date updateDate;
	private Integer updatorId;
	private String isDel;
	private String targetId;

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getGroupId() {
		return groupId;
	}
	
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	
	public String getIsDef() {
		return isDef;
	}
	
	public void setIsDef(String isDef) {
		this.isDef = isDef;
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
	
	public String getTargetId() {
		return targetId;
	}
	
	public void setTargetId(String targetId) {
		this.targetId = targetId;
	}
	
	public String toString() {
		return "Image [id=" + id + ",name=" + name + ",url=" + url + ",groupId=" + groupId + ",isDef=" + isDef + ",createDate=" + createDate + ",creatorId=" + creatorId + ",updateDate=" + updateDate + ",updatorId=" + updatorId + ",isDel=" + isDel + ",targetId=" + targetId + "]";
	}
	
	
}