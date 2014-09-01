package com.hqhop.framework.shiro.dao.impl;

import com.hqhop.framework.common.bind.annotation.Repository;
import com.hqhop.framework.common.orm.hibernate.BaseRepoitoryImpl;
import com.hqhop.framework.shiro.dao.ResourceDao;
import com.hqhop.framework.shiro.entity.Resource;

@Repository(entity = Resource.class)
public class ResourceDaoImpl extends BaseRepoitoryImpl<Resource, String> implements ResourceDao {

}
