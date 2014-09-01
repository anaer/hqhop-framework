package com.hqhop.framework.shiro.dao.impl;


import com.hqhop.framework.common.bind.annotation.Repository;
import com.hqhop.framework.common.orm.hibernate.BaseRepoitoryImpl;
import com.hqhop.framework.shiro.dao.PermissionDao;
import com.hqhop.framework.shiro.entity.Permission;

@Repository(entity = Permission.class)
public class PermissionDaoImpl extends BaseRepoitoryImpl<Permission, String> implements PermissionDao {

}
