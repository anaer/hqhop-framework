package com.hqhop.framework.shiro.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.hqhop.framework.common.entity.BaseEntity;
import com.hqhop.framework.common.entity.LogicDeleteable;
import com.hqhop.framework.shiro.entity.enumtype.UserStatus;

/**
 * 
 * @author silentwu
 * 
 */
@Entity
@DynamicUpdate(true)
@DynamicInsert(true)
@Table(name = "t_base_user")
public class User extends BaseEntity<String> implements LogicDeleteable {
	private String name;
	private String password;
	private int age;
	private int sex;
	private String identityCard;
	private String phoneNum;
	/**
	 * 职工号
	 */
	private String empNum;
	/**
	 * 逻辑删除flag
	 */
	private Boolean deleted = Boolean.FALSE;
	/**
	 * 系统用户的状态
	 */
	@Enumerated(EnumType.STRING)
	private UserStatus status = UserStatus.normal;

	@Column(name = "department_id")
	private String departmentId;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public Boolean getDeleted() {
		return this.deleted;
	}

	@Override
	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}
	@Override
	public void markDeleted() {
		this.deleted = Boolean.TRUE;
	}

	public UserStatus getStatus() {
		return status;
	}

	public void setStatus(UserStatus status) {
		this.status = status;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getIdentityCard() {
		return identityCard;
	}
	public void setIdentityCard(String identityCard) {
		this.identityCard = identityCard;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getEmpNum() {
		return empNum;
	}
	public void setEmpNum(String empNum) {
		this.empNum = empNum;
	}
	public String getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", password=" + password + ", age=" + age + ", sex=" + sex + ", identityCard=" + identityCard + ", phoneNum=" + phoneNum + ", empNum=" + empNum + ", deleted=" + deleted + ", status=" + status + ", departmentId=" + departmentId + "]";
	}

}
