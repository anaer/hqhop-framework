package com.hqhop.framework.shiro.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.hqhop.framework.common.entity.BaseEntity;
import com.hqhop.framework.common.entity.Treeable;
import com.hqhop.framework.common.utils.Utils;

/**
 * 系统资源
 * 
 * @author silentwu
 * 
 */
//@Entity
//@DynamicUpdate(true)
//@DynamicInsert(true)
//@Table(name = "t_resource")
public class Resource extends BaseEntity<String> implements Treeable<String> {
	/**
	 * 标题
	 */
	private String name;

	/**
	 * 资源标识符 用于权限匹配的
	 */
	private String identity;

	/**
	 * 点击后前往的地址 菜单才有
	 */
	private String url;

	/**
	 * 父路径
	 */
	@Column(name = "parent_id")
	private String parentId;

	@Column(name = "parent_ids")
	private String parentIds;

	private Integer weight;

	/**
	 * 图标
	 */
	private String icon;

	/**
	 * 是否有叶子节点
	 */
	@Transient
	private boolean hasChildren;

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

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getParentIds() {
		return parentIds;
	}

	public void setParentIds(String parentIds) {
		this.parentIds = parentIds;
	}

	@Override
	public String makeSelfAsNewParentIds() {
		return getParentIds() + getId() + getSeparator();
	}

	public String getTreetableIds() {
		String selfId = makeSelfAsNewParentIds().replace("/", "-");
		return selfId.substring(0, selfId.length() - 1);
	}

	public String getTreetableParentIds() {
		String parentIds = getParentIds().replace("/", "-");
		return parentIds.substring(0, parentIds.length() - 1);
	}

	@Override
	public String getSeparator() {
		return "/";
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public String getIcon() {
		if (!Utils.isEmpty(icon)) {
			return icon;
		}
		if (isRoot()) {
			return getRootDefaultIcon();
		}
		if (isLeaf()) {
			return getLeafDefaultIcon();
		}
		return getBranchDefaultIcon();
	}

	public void setIcon(String icon) {
		this.icon = icon;
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

	public boolean isHasChildren() {
		return hasChildren;
	}

	public void setHasChildren(boolean hasChildren) {
		this.hasChildren = hasChildren;
	}

	public Boolean getDisabled() {
		return disabled;
	}

	public void setDisabled(Boolean disabled) {
		this.disabled = disabled;
	}

	/**
	 * 根节点默认图标 如果没有默认 空即可
	 * 
	 * @return
	 */
	@Override
	public String getRootDefaultIcon() {
		return "ztree_setting";
	}

	/**
	 * 树枝节点默认图标 如果没有默认 空即可
	 * 
	 * @return
	 */
	@Override
	public String getBranchDefaultIcon() {
		return "ztree_folder";
	}

	/**
	 * 树叶节点默认图标 如果没有默认 空即可
	 * 
	 * @return
	 */
	@Override
	public String getLeafDefaultIcon() {
		return "ztree_file";
	}

}
