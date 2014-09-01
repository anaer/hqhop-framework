package com.hqhop.framework.shiro.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.hqhop.framework.common.entity.BaseEntity;

/**
 * 角色表
 * 
 * @author silentwu
 */
//@Entity
//@DynamicUpdate(true)
//@DynamicInsert(true)
//@Table(name = "t_role")
public class Role extends BaseEntity<String> {

	/**
	 * 前端显示名称
	 */
	private String name;
	/**
	 * 系统中验证时使用的角色标识
	 */
	private String role;

	/**
	 * 详细描述
	 */
	private String description;

	/**
	 * 是否显示 也表示是否可用 为了统一 都使用这个
	 */
	private Boolean disabled = Boolean.FALSE;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getDisabled() {
		return disabled;
	}

	public void setDisabled(Boolean disabled) {
		this.disabled = disabled;
	}

}
