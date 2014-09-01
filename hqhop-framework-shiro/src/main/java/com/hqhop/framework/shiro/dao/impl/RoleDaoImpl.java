package com.hqhop.framework.shiro.dao.impl;

import com.hqhop.framework.common.bind.annotation.Repository;
import com.hqhop.framework.common.orm.hibernate.BaseRepoitoryImpl;
import com.hqhop.framework.shiro.dao.RoleDao;
import com.hqhop.framework.shiro.entity.Role;

@Repository(entity = Role.class)
public class RoleDaoImpl extends BaseRepoitoryImpl<Role, String> implements RoleDao {

}
