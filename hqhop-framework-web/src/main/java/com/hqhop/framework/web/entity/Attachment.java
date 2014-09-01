package com.hqhop.framework.web.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.hqhop.framework.common.entity.BaseEntity;

/**
 * 附件表
 * 
 * @author silentwu
 * 
 */
@Entity
@DynamicUpdate(true)
@DynamicInsert(true)
@Table(name = "t_base_attachement")
public class Attachment extends BaseEntity<String> {

	private String fileName;

	private String url;

	@Column(name = "source_id")
	private String sourceId;

	private String creater;

	@Column(name = "create_time")
	private String createTime;

	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getSourceId() {
		return sourceId;
	}
	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
	}
	public String getCreater() {
		return creater;
	}
	public void setCreater(String creater) {
		this.creater = creater;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

}
