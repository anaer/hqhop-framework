package com.hqhop.framework.shiro.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.hqhop.framework.common.entity.BaseEntity;
/**
 * 用户角色关系
 * 
 * @author silentwu
 * 
 */
//@Entity
//@DynamicUpdate(true)
//@DynamicInsert(true)
//@Table(name = "t_userRoleRelation")
public class UserRoleRelation extends BaseEntity<String> {

	@Column(name = "user_id")
	private User user;
	@Column(name = "role_id")
	private Role role;

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}

}
