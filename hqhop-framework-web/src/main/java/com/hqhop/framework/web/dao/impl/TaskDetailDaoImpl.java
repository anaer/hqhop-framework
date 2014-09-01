package com.hqhop.framework.web.dao.impl;

import com.hqhop.framework.common.bind.annotation.Repository;
import com.hqhop.framework.common.orm.hibernate.BaseRepoitoryImpl;
import com.hqhop.framework.web.dao.TaskDetailDao;
import com.hqhop.framework.web.entity.TaskDetail;

@Repository(entity = TaskDetail.class)
public class TaskDetailDaoImpl extends BaseRepoitoryImpl<TaskDetail, String> implements TaskDetailDao {

}
