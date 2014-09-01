package com.hqhop.framework.shiro.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.type.CollectionToStringPermission;

import com.hqhop.framework.common.entity.BaseEntity;

/**
 * 用户权限关系类
 * 
 * @author silentwu
 */

//@TypeDef(
//        name = "SetToStringPermission",
//        typeClass = CollectionToStringPermission.class,
//        parameters = {
//                @Parameter(name = "separator", value = ","),
//                @Parameter(name = "collectionType", value = "java.util.HashSet"),
//                @Parameter(name = "elementType", value = "com.hqhop.framework.shiro.entity.Permission")
//        }
//)
//@Entity
//@DynamicUpdate(true)
//@DynamicInsert(true)
//@Table(name = "t_userResourcePermission")
public class UserResourcePermission extends BaseEntity<String> {

	@Column(name="user_id")
	private User user;

	/**
	 * 资源id
	 */
	@Column(name="resource_id")
	private Resource resource;

	/**
	 * 权限id列表 数据库通过字符串存储 逗号分隔
	 */
	@Column(name = "permission_ids")
	@Type(type = "SetToStringPermission")
	private Set<Permission> permissions;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Resource getResource() {
		return resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}

	public Set<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(Set<Permission> permissions) {
		this.permissions = permissions;
	}

}
