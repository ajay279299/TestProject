package com.dto;

public class MetaData {

	private Long tenantId = null;
	private Long extensionId = null;
	private String extensionLabel = null;
	private String extensionDataType = null;
	private String extensionVisibilty = null;

	public String getExtensionDataType() {
		return extensionDataType;
	}

	public Long getExtensionId() {
		return extensionId;
	}

	public String getExtensionLabel() {
		return extensionLabel;
	}

	public String getExtensionVisibilty() {
		return extensionVisibilty;
	}

	public Long getTenantId() {
		return tenantId;
	}

	public void setExtensionDataType(String extensionDataType) {
		this.extensionDataType = extensionDataType;
	}

	public void setExtensionId(Long extensionId) {
		this.extensionId = extensionId;
	}

	public void setExtensionLabel(String extensionLabel) {
		this.extensionLabel = extensionLabel;
	}

	public void setExtensionVisibilty(String extensionVisibilty) {
		this.extensionVisibilty = extensionVisibilty;
	}

	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}

}
