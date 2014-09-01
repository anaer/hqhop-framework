package com.hqhop.framework.web.dao.impl;

import com.hqhop.framework.common.bind.annotation.Repository;
import com.hqhop.framework.common.orm.hibernate.BaseRepoitoryImpl;
import com.hqhop.framework.web.dao.TaskDao;
import com.hqhop.framework.web.entity.Task;

@Repository(entity = Task.class)
public class TaskDaoImpl extends BaseRepoitoryImpl<Task, String> implements TaskDao {

}
