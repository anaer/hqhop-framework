package com.hqhop.framework.shiro.service.impl;

import org.springframework.transaction.annotation.Transactional;

import com.hqhop.framework.common.bind.annotation.Service;
import com.hqhop.framework.common.service.BaseServiceImpl;
import com.hqhop.framework.shiro.dao.DepartmentDao;
import com.hqhop.framework.shiro.entity.Department;
import com.hqhop.framework.shiro.service.DepartmentService;

@Transactional
@Service(repositoryType = DepartmentDao.class)
public class DepartmentServiceImpl extends BaseServiceImpl<Department, String> implements DepartmentService {

}
