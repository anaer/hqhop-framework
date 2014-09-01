package com.hqhop.framework.shiro.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.hqhop.framework.common.entity.BaseEntity;
import com.hqhop.framework.common.entity.Treeable;
/**
 * 部门表
 * 
 * @author silentwu
 * 
 */
@Entity
@DynamicUpdate(true)
@DynamicInsert(true)
@Table(name = "t_base_department")
public class Department extends BaseEntity<String> implements Treeable<String> {
	private String name;

	@Column(name = "parent_id")
	private String parentId;

	private String icon;

	private Integer weight;

	@Transient
	private boolean hasChildren;

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public String getIcon() {
		return this.icon;
	}

	@Override
	public void setIcon(String icon) {
		this.icon = icon;
	}

	@Override
	public String getParentId() {
		return this.parentId;
	}

	@Override
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	@Override
	public String getParentIds() {
		return null;
	}

	@Override
	public void setParentIds(String parentIds) {
	}

	@Override
	public String getSeparator() {
		return null;
	}

	@Override
	public String makeSelfAsNewParentIds() {
		return null;
	}

	@Override
	public Integer getWeight() {
		return this.weight;
	}

	@Override
	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	@Override
	public boolean isRoot() {
		if (getParentId() != null && "0".equals(getParentId())) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isLeaf() {
		if (isRoot()) {
			return false;
		}
		if (isHasChildren()) {
			return false;
		}
		return true;
	}

	@Override
	public boolean isHasChildren() {
		return false;
	}

	@Override
	public String getRootDefaultIcon() {
		return null;
	}

	@Override
	public String getBranchDefaultIcon() {
		return null;
	}

	@Override
	public String getLeafDefaultIcon() {
		return null;
	}

	@Override
	public String toString() {
		return "Department [name=" + name + ", parentId=" + parentId + ", icon=" + icon + ", weight=" + weight + ", hasChildren=" + hasChildren + "]";
	}

}
