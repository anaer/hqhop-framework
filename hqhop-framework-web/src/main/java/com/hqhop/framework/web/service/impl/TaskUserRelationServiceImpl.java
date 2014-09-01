package com.hqhop.framework.web.service.impl;

import org.springframework.transaction.annotation.Transactional;

import com.hqhop.framework.common.bind.annotation.Service;
import com.hqhop.framework.common.service.BaseServiceImpl;
import com.hqhop.framework.web.dao.TaskUserRelationDao;
import com.hqhop.framework.web.entity.TaskUserRelation;
import com.hqhop.framework.web.service.TaskUserRelationService;

@Transactional
@Service(repositoryType = TaskUserRelationDao.class)
public class TaskUserRelationServiceImpl extends BaseServiceImpl<TaskUserRelation, String> implements TaskUserRelationService {

}
