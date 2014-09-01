package com.hqhop.framework.web.service.impl;

import org.springframework.transaction.annotation.Transactional;

import com.hqhop.framework.common.bind.annotation.Service;
import com.hqhop.framework.common.service.BaseServiceImpl;
import com.hqhop.framework.web.dao.TaskDao;
import com.hqhop.framework.web.entity.Task;
import com.hqhop.framework.web.service.TaskService;

@Transactional
@Service(repositoryType = TaskDao.class)
public class TaskServiceImpl extends BaseServiceImpl<Task, String> implements TaskService {

}
