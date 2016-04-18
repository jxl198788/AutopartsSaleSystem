package com.fjsaas.web.bean;

import java.util.*;
import java.io.Serializable;
import java.math.BigDecimal;


public class User implements Serializable {
	/**
	 * 序列化ID
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String telphone;
	private String username;
	private String realname;
	private String password;
	private String job;
	private String email;
	private String address;
	private String gruop;
	private String isRoot;
	private Integer suppilerId;
	private String locked;
	private String salt;
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
	
	public String getTelphone() {
		return telphone;
	}
	
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getRealname() {
		return realname;
	}
	
	public void setRealname(String realname) {
		this.realname = realname;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getJob() {
		return job;
	}
	
	public void setJob(String job) {
		this.job = job;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getGruop() {
		return gruop;
	}
	
	public void setGruop(String gruop) {
		this.gruop = gruop;
	}
	
	public String getIsRoot() {
		return isRoot;
	}
	
	public void setIsRoot(String isRoot) {
		this.isRoot = isRoot;
	}
	
	public Integer getSuppilerId() {
		return suppilerId;
	}
	
	public void setSuppilerId(Integer suppilerId) {
		this.suppilerId = suppilerId;
	}
	
	public String getLocked() {
		return locked;
	}
	
	public void setLocked(String locked) {
		this.locked = locked;
	}
	
	public String getSalt() {
		return salt;
	}
	
	public void setSalt(String salt) {
		this.salt = salt;
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
		return "User [id=" + id + ",telphone=" + telphone + ",username=" + username + ",realname=" + realname + ",password=" + password + ",job=" + job + ",email=" + email + ",address=" + address + ",gruop=" + gruop + ",isRoot=" + isRoot + ",suppilerId=" + suppilerId + ",locked=" + locked + ",salt=" + salt + ",createDate=" + createDate + ",creatorId=" + creatorId + ",updateDate=" + updateDate + ",updatorId=" + updatorId + ",isDel=" + isDel + "]";
	}
	
	
}