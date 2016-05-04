package com.fjsaas.web.bean;

import java.util.*;
import java.io.Serializable;
import java.math.BigDecimal;


public class Supplier implements Serializable {
	/**
	 * 序列化ID
	 */
	private static final long serialVersionUID = 1L;
	//supplier表
	private Integer id;
	private String username;//用户名 user表
	private String rolename;//汽配商名称 supplier表
	private Integer supplierid;
	private String suppliername;//汽配商名称 supplier表
	private String domain_name;//域名 domain表
	private String businessLicenseUrl;
	private String province;
	private String city;
	private String town;
	private String addr;
	private String linkman;
	private String telphone;
	private String locked;
	private Date createDate;
	private Integer creatorId;
	private Date updateDate;
	private Integer updatorId;
	private Integer userlocked;//用于激活和锁定用户账户，1：激活（即生效），0：锁定（即失效）
	private String is_root;//是否为根管理员
	private String isDel;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSuppliername() {
		return suppliername;
	}
	public void setSuppliername(String suppliername) {
		this.suppliername = suppliername;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	public String getDomain_name() {
		return domain_name;
	}
	public void setDomain_name(String domain_name) {
		this.domain_name = domain_name;
	}
	public String getBusinessLicenseUrl() {
		return businessLicenseUrl;
	}
	public void setBusinessLicenseUrl(String businessLicenseUrl) {
		this.businessLicenseUrl = businessLicenseUrl;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getLinkman() {
		return linkman;
	}
	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}
	public String getTelphone() {
		return telphone;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
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
		return "Supplier [id=" + id + ",username=" + username + ",telphone=" + telphone + ",rolename=" + rolename + ",domain_name=" + domain_name + ",suppliername=" + suppliername + ",businessLicenseUrl=" + businessLicenseUrl + ",province=" + province + ",city=" + city + ",town=" + town + ",addr=" + addr + ",linkman=" + linkman + ",createDate=" + createDate + ",creatorId=" + creatorId + ",updateDate=" + updateDate + ",updatorId=" + updatorId + ",userlocked=" + userlocked + ",isDel=" + isDel + "]";
	}
	public String getIs_root() {
		return is_root;
	}
	public void setIs_root(String is_root) {
		this.is_root = is_root;
	}
	public Integer getSupplierid() {
		return supplierid;
	}
	public void setSupplierid(Integer supplierid) {
		this.supplierid = supplierid;
	}
	public Integer getUserlocked() {
		return userlocked;
	}
	public void setUserlocked(Integer userlocked) {
		this.userlocked = userlocked;
	}
	public String getLocked() {
		return locked;
	}
	public void setLocked(String locked) {
		this.locked = locked;
	}
	
}