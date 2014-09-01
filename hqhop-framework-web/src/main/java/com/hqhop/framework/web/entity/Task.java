package com.hqhop.framework.web.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.hqhop.framework.common.entity.BaseEntity;
import com.hqhop.framework.shiro.entity.User;

/**
 * 任务表
 * 
 * @author silentwu
 * 
 */
@Entity
@DynamicUpdate(true)
@DynamicInsert(true)
@Table(name = "t_synergism_task")
public class Task extends BaseEntity<String> {

	private String subject;

	private String content;

	@Column(name = "user_id")
	private String userId;

	@Column(name = "create_date")
	private Date createDate;

	private int status;

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
