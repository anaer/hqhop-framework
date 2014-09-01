package com.hqhop.framework.web.service.impl;

import org.springframework.transaction.annotation.Transactional;

import com.hqhop.framework.common.bind.annotation.Service;
import com.hqhop.framework.common.service.BaseServiceImpl;
import com.hqhop.framework.web.dao.TaskDetailDao;
import com.hqhop.framework.web.entity.TaskDetail;
import com.hqhop.framework.web.service.TaskDetailService;

@Transactional
@Service(repositoryType = TaskDetailDao.class)
public class TaskDetailServiceImpl extends BaseServiceImpl<TaskDetail, String> implements TaskDetailService {

}
