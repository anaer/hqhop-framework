package com.hqhop.framework.shiro.service.impl;

import org.springframework.transaction.annotation.Transactional;

import com.hqhop.framework.common.bind.annotation.Service;
import com.hqhop.framework.common.service.BaseServiceImpl;
import com.hqhop.framework.shiro.dao.RoleDao;
import com.hqhop.framework.shiro.entity.Role;
import com.hqhop.framework.shiro.service.RoleService;

@Transactional
@Service(repositoryType = RoleDao.class)
public class RoleServiceImpl extends BaseServiceImpl<Role, String> implements RoleService {

}
