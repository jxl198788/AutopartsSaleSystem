package com.fjsaas.web.bean;

import java.util.*;
import java.io.Serializable;
import java.math.BigDecimal;


public class Quota implements Serializable {
	/**
	 * 序列化ID
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private Integer totalQuota;
	private Integer usableQuota;
	private Integer usedQuato;
	private Integer distributeQuota;
	private Integer supplierId;
	private Integer permissionId;
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
	
	public Integer getTotalQuota() {
		return totalQuota;
	}
	
	public void setTotalQuota(Integer totalQuota) {
		this.totalQuota = totalQuota;
	}
	
	public Integer getUsableQuota() {
		return usableQuota;
	}
	
	public void setUsableQuota(Integer usableQuota) {
		this.usableQuota = usableQuota;
	}
	
	public Integer getUsedQuato() {
		return usedQuato;
	}
	
	public void setUsedQuato(Integer usedQuato) {
		this.usedQuato = usedQuato;
	}
	
	public Integer getDistributeQuota() {
		return distributeQuota;
	}
	
	public void setDistributeQuota(Integer distributeQuota) {
		this.distributeQuota = distributeQuota;
	}
	
	public Integer getSupplierId() {
		return supplierId;
	}
	
	public void setSupplierId(Integer supplierId) {
		this.supplierId = supplierId;
	}
	
	public Integer getPermissionId() {
		return permissionId;
	}
	
	public void setPermissionId(Integer permissionId) {
		this.permissionId = permissionId;
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
		return "Quota [id=" + id + ",totalQuota=" + totalQuota + ",usableQuota=" + usableQuota + ",usedQuato=" + usedQuato + ",distributeQuota=" + distributeQuota + ",supplierId=" + supplierId + ",permissionId=" + permissionId + ",createDate=" + createDate + ",creatorId=" + creatorId + ",updateDate=" + updateDate + ",updatorId=" + updatorId + ",isDel=" + isDel + "]";
	}
	
	
}