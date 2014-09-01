package com.hqhop.framework.web.dao.impl;

import com.hqhop.framework.common.bind.annotation.Repository;
import com.hqhop.framework.common.orm.hibernate.BaseRepoitoryImpl;
import com.hqhop.framework.web.dao.TaskUserRelationDao;
import com.hqhop.framework.web.entity.TaskUserRelation;

@Repository(entity = TaskUserRelation.class)
public class TaskUserRelationDaoImpl extends BaseRepoitoryImpl<TaskUserRelation, String> implements TaskUserRelationDao {

}
