package com.hqhop.framework.shiro.service.impl;

import org.springframework.transaction.annotation.Transactional;

import com.hqhop.framework.common.bind.annotation.Service;
import com.hqhop.framework.common.service.BaseServiceImpl;
import com.hqhop.framework.shiro.dao.ResourceDao;
import com.hqhop.framework.shiro.entity.Resource;
import com.hqhop.framework.shiro.service.ResourceService;

@Transactional
@Service(repositoryType = ResourceDao.class)
public class ResourceServiceImpl extends BaseServiceImpl<Resource, String> implements ResourceService {

}
