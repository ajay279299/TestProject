package com.ref;

import java.util.Date;

public class Issuer {
	private Long tenantId = null;
	private Long id = null;
	private String ownerUserId = null;

	private String createdBy = null;
	private Date createDate = null;
	private String updatedBy = null;
	private Date updatedDate = null;

	private Long deleted = null;

	public Date getCreateDate() {
		return createDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public Long getDeleted() {
		return deleted;
	}

	public Long getId() {
		return id;
	}

	public String getOwnerUserId() {
		return ownerUserId;
	}

	public Long getTenantId() {
		return tenantId;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public void setDeleted(Long deleted) {
		this.deleted = deleted;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setOwnerUserId(String ownerUserId) {
		this.ownerUserId = ownerUserId;
	}

	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

}
