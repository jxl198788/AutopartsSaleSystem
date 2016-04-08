package com.fjsaas.web.bean;

import java.util.*;
import java.io.Serializable;
import java.math.BigDecimal;


public class SupplierOrm implements Serializable {
	/**
	 * 序列化ID
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String supplierNo;
	private String oeCode;
	private String bigProductNo;
	private String smallProductNo;
	private String produerName;
	private String partName;
	private Float firstPrice;
	private Float secondPrice;
	private Float thirdPrice;
	private Integer supplierId;
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
	
	public String getSupplierNo() {
		return supplierNo;
	}
	
	public void setSupplierNo(String supplierNo) {
		this.supplierNo = supplierNo;
	}
	
	public String getOeCode() {
		return oeCode;
	}
	
	public void setOeCode(String oeCode) {
		this.oeCode = oeCode;
	}
	
	public String getBigProductNo() {
		return bigProductNo;
	}
	
	public void setBigProductNo(String bigProductNo) {
		this.bigProductNo = bigProductNo;
	}
	
	public String getSmallProductNo() {
		return smallProductNo;
	}
	
	public void setSmallProductNo(String smallProductNo) {
		this.smallProductNo = smallProductNo;
	}
	
	public String getProduerName() {
		return produerName;
	}
	
	public void setProduerName(String produerName) {
		this.produerName = produerName;
	}
	
	public String getPartName() {
		return partName;
	}
	
	public void setPartName(String partName) {
		this.partName = partName;
	}
	
	public Float getFirstPrice() {
		return firstPrice;
	}
	
	public void setFirstPrice(Float firstPrice) {
		this.firstPrice = firstPrice;
	}
	
	public Float getSecondPrice() {
		return secondPrice;
	}
	
	public void setSecondPrice(Float secondPrice) {
		this.secondPrice = secondPrice;
	}
	
	public Float getThirdPrice() {
		return thirdPrice;
	}
	
	public void setThirdPrice(Float thirdPrice) {
		this.thirdPrice = thirdPrice;
	}
	
	public Integer getSupplierId() {
		return supplierId;
	}
	
	public void setSupplierId(Integer supplierId) {
		this.supplierId = supplierId;
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
		return "SupplierOrm [id=" + id + ",supplierNo=" + supplierNo + ",oeCode=" + oeCode + ",bigProductNo=" + bigProductNo + ",smallProductNo=" + smallProductNo + ",produerName=" + produerName + ",partName=" + partName + ",firstPrice=" + firstPrice + ",secondPrice=" + secondPrice + ",thirdPrice=" + thirdPrice + ",supplierId=" + supplierId + ",status=" + status + ",createDate=" + createDate + ",creatorId=" + creatorId + ",updateDate=" + updateDate + ",updatorId=" + updatorId + ",isDel=" + isDel + "]";
	}
	
	
}