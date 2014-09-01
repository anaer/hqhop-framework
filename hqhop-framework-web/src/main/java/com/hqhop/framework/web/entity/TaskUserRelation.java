package com.hqhop.framework.web.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.hqhop.framework.common.entity.BaseEntity;

@Entity
@DynamicUpdate(true)
@DynamicInsert(true)
@Table(name = "t_synergism_task_user")
public class TaskUserRelation extends BaseEntity<String> {
	@Column(name = "task_id")
	private String taskId;

	@Column(name = "user_id")
	private String userId;

	@Column(name = "complete_time")
	private Date completeTime;

	private int status;

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

	public Date getCompleteTime() {
		return completeTime;
	}

	public void setCompleteTime(Date completeTime) {
		this.completeTime = completeTime;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
