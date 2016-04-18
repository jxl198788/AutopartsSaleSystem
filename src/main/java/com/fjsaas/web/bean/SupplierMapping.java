package com.fjsaas.web.bean;

import java.util.*;
import java.io.Serializable;
import java.math.BigDecimal;


public class SupplierMapping implements Serializable {
	/**
	 * 序列化ID
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String productBrand;
	private String productName;
	private String productCode;
	private String referenceCode;
	private String referenceBrand;
	private String oeCode;
	private Float firstPrice;
	private Float secondPrice;
	private Float thirdPrice;
	private String status;
	private Integer supplierId;
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
	
	public String getProductBrand() {
		return productBrand;
	}
	
	public void setProductBrand(String productBrand) {
		this.productBrand = productBrand;
	}
	
	public String getProductName() {
		return productName;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public String getProductCode() {
		return productCode;
	}
	
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	
	public String getReferenceCode() {
		return referenceCode;
	}
	
	public void setReferenceCode(String referenceCode) {
		this.referenceCode = referenceCode;
	}
	
	public String getReferenceBrand() {
		return referenceBrand;
	}
	
	public void setReferenceBrand(String referenceBrand) {
		this.referenceBrand = referenceBrand;
	}
	
	public String getOeCode() {
		return oeCode;
	}
	
	public void setOeCode(String oeCode) {
		this.oeCode = oeCode;
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
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public Integer getSupplierId() {
		return supplierId;
	}
	
	public void setSupplierId(Integer supplierId) {
		this.supplierId = supplierId;
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
		return "SupplierMapping [id=" + id + ",productBrand=" + productBrand + ",productName=" + productName + ",productCode=" + productCode + ",referenceCode=" + referenceCode + ",referenceBrand=" + referenceBrand + ",oeCode=" + oeCode + ",firstPrice=" + firstPrice + ",secondPrice=" + secondPrice + ",thirdPrice=" + thirdPrice + ",status=" + status + ",supplierId=" + supplierId + ",createDate=" + createDate + ",creatorId=" + creatorId + ",updateDate=" + updateDate + ",updatorId=" + updatorId + ",isDel=" + isDel + "]";
	}
	
	
}