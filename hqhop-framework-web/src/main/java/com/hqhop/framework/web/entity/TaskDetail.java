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

@Entity
@DynamicUpdate(true)
@DynamicInsert(true)
@Table(name = "t_synergism_task_detail")
public class TaskDetail extends BaseEntity<String> {

	@Column(name = "task_id")
	private String taskId;

	private String content;

	@Column(name = "user_id")
	private String userId;

	@Column(name = "date_time")
	private Date dateTime;

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

}
