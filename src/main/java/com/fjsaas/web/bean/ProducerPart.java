package com.fjsaas.web.bean;

import java.util.*;
import java.io.Serializable;
import java.math.BigDecimal;


public class ProducerPart implements Serializable {
	/**
	 * 序列化ID
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String productCode;
	private Integer producerId;
	private Integer partId;
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
	
	public String getProductCode() {
		return productCode;
	}
	
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	
	public Integer getProducerId() {
		return producerId;
	}
	
	public void setProducerId(Integer producerId) {
		this.producerId = producerId;
	}
	
	public Integer getPartId() {
		return partId;
	}
	
	public void setPartId(Integer partId) {
		this.partId = partId;
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
		return "ProducerPart [id=" + id + ",productCode=" + productCode + ",producerId=" + producerId + ",partId=" + partId + ",createDate=" + createDate + ",creatorId=" + creatorId + ",updateDate=" + updateDate + ",updatorId=" + updatorId + ",isDel=" + isDel + "]";
	}
	
	
}