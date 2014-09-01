package com.hqhop.framework.shiro.dao.impl;

import com.hqhop.framework.common.bind.annotation.Repository;
import com.hqhop.framework.common.orm.hibernate.BaseRepoitoryImpl;
import com.hqhop.framework.shiro.dao.UserDao;
import com.hqhop.framework.shiro.entity.User;

@Repository(entity = User.class)
public class UserDaoImpl extends BaseRepoitoryImpl<User, String> implements UserDao {

}
