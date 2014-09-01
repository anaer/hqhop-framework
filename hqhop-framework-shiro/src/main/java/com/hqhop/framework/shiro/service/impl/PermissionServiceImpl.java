package com.hqhop.framework.shiro.service.impl;

import org.springframework.transaction.annotation.Transactional;

import com.hqhop.framework.common.bind.annotation.Service;
import com.hqhop.framework.common.service.BaseServiceImpl;
import com.hqhop.framework.shiro.dao.PermissionDao;
import com.hqhop.framework.shiro.entity.Permission;
import com.hqhop.framework.shiro.service.PermissionService;

@Transactional
@Service(repositoryType = PermissionDao.class)
public class PermissionServiceImpl extends BaseServiceImpl<Permission, String> implements PermissionService {

}
