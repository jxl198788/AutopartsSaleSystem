package com.fjsaas.web.bean;

import java.util.Date;

public class UserQuotas {
	/**
	 * 序列化ID
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String username;//用户名
	private String telphone;//手机号
	private Integer supplierid;//汽配商id
	private String suppliername;//汽配商名称
	private String rolename;//角色
	private Integer high_quotas;//配额
	private Integer h_deal_quotas;//已分配配额
	private Integer h_left_quotas;//剩余配额
	private Integer h_use_quotas;//已使用配额
	private Integer h_unuse_quotas;//未使用配额
	private Integer comm_quotas;//配额
	private Integer c_deal_quotas;//已分配配额
	private Integer c_left_quotas;//未分配配额
	private Integer c_use_quotas;//已使用配额
	private Integer c_unuse_quotas;//未使用配额
	private Date updateDate;
	private Integer updatorId;
	private Integer type;//查询类型：1高级查询，2普通查询
	
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
	public String getTelphone() {
		return telphone;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
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
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getSupplierid() {
		return supplierid;
	}
	public void setSupplierid(Integer supplierid) {
		this.supplierid = supplierid;
	}
	public Integer getHigh_quotas() {
		return high_quotas;
	}
	public void setHigh_quotas(Integer high_quotas) {
		this.high_quotas = high_quotas;
	}
	public Integer getH_deal_quotas() {
		return h_deal_quotas;
	}
	public void setH_deal_quotas(Integer h_deal_quotas) {
		this.h_deal_quotas = h_deal_quotas;
	}
	public Integer getH_left_quotas() {
		return h_left_quotas;
	}
	public void setH_left_quotas(Integer h_left_quotas) {
		this.h_left_quotas = h_left_quotas;
	}
	public Integer getH_use_quotas() {
		return h_use_quotas;
	}
	public void setH_use_quotas(Integer h_use_quotas) {
		this.h_use_quotas = h_use_quotas;
	}
	public Integer getH_unuse_quotas() {
		return h_unuse_quotas;
	}
	public void setH_unuse_quotas(Integer h_unuse_quotas) {
		this.h_unuse_quotas = h_unuse_quotas;
	}
	public Integer getComm_quotas() {
		return comm_quotas;
	}
	public void setComm_quotas(Integer comm_quotas) {
		this.comm_quotas = comm_quotas;
	}
	public Integer getC_deal_quotas() {
		return c_deal_quotas;
	}
	public void setC_deal_quotas(Integer c_deal_quotas) {
		this.c_deal_quotas = c_deal_quotas;
	}
	public Integer getC_left_quotas() {
		return c_left_quotas;
	}
	public void setC_left_quotas(Integer c_left_quotas) {
		this.c_left_quotas = c_left_quotas;
	}
	public Integer getC_use_quotas() {
		return c_use_quotas;
	}
	public void setC_use_quotas(Integer c_use_quotas) {
		this.c_use_quotas = c_use_quotas;
	}
	public Integer getC_unuse_quotas() {
		return c_unuse_quotas;
	}
	public void setC_unuse_quotas(Integer c_unuse_quotas) {
		this.c_unuse_quotas = c_unuse_quotas;
	}
	
}
