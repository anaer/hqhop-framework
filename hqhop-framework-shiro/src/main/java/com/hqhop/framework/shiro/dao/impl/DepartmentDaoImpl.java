package com.hqhop.framework.shiro.dao.impl;

import com.hqhop.framework.common.bind.annotation.Repository;
import com.hqhop.framework.common.orm.hibernate.BaseRepoitoryImpl;
import com.hqhop.framework.shiro.dao.DepartmentDao;
import com.hqhop.framework.shiro.entity.Department;

@Repository(entity = Department.class)
public class DepartmentDaoImpl extends BaseRepoitoryImpl<Department, String> implements DepartmentDao {

}
