package com.hqhop.framework.shiro.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.hqhop.framework.common.entity.BaseEntity;

/**
 * 权限表
 * 
 * @author silentwu
 */
//@Entity
//@DynamicUpdate(true)
//@DynamicInsert(true)
//@Table(name = "t_permission")
public class Permission extends BaseEntity<String> {

	/**
	 * 前端显示名称
	 */
	private String name;

	/**
	 * 系统中验证时使用的权限标识
	 */
	private String permission;

	/**
	 * 详细描述
	 */
	private String description;

	/**
	 * 是否显示
	 */
	private Boolean disabled = Boolean.FALSE;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
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
