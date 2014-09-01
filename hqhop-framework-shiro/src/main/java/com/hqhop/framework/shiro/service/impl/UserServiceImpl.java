package com.hqhop.framework.shiro.service.impl;

import org.springframework.transaction.annotation.Transactional;

import com.hqhop.framework.common.bind.annotation.Service;
import com.hqhop.framework.common.service.BaseServiceImpl;
import com.hqhop.framework.shiro.dao.UserDao;
import com.hqhop.framework.shiro.entity.User;
import com.hqhop.framework.shiro.service.UserService;

@Transactional
@Service(repositoryType = UserDao.class)
public class UserServiceImpl extends BaseServiceImpl<User, String> implements UserService {

}
