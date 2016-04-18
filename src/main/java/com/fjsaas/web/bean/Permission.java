package com.fjsaas.web.bean;

import java.util.*;
import java.io.Serializable;
import java.math.BigDecimal;


public class Permission implements Serializable {
	/**
	 * 序列化ID
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;
	private String type;
	private String url;
	private String percode;
	private Integer parentid;
	private String parentids;
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
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getPercode() {
		return percode;
	}
	
	public void setPercode(String percode) {
		this.percode = percode;
	}
	
	public Integer getParentid() {
		return parentid;
	}
	
	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}
	
	public String getParentids() {
		return parentids;
	}
	
	public void setParentids(String parentids) {
		this.parentids = parentids;
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
		return "Permission [id=" + id + ",name=" + name + ",type=" + type + ",url=" + url + ",percode=" + percode + ",parentid=" + parentid + ",parentids=" + parentids + ",createDate=" + createDate + ",creatorId=" + creatorId + ",updateDate=" + updateDate + ",updatorId=" + updatorId + ",isDel=" + isDel + "]";
	}
	
	
}