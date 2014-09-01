package com.hqhop.framework.web.service.impl;

import org.springframework.transaction.annotation.Transactional;

import com.hqhop.framework.common.bind.annotation.Service;
import com.hqhop.framework.common.service.BaseServiceImpl;
import com.hqhop.framework.web.dao.AttachmentDao;
import com.hqhop.framework.web.entity.Attachment;
import com.hqhop.framework.web.service.AttachmentService;

@Transactional
@Service(repositoryType = AttachmentDao.class)
public class AttachmentServiceImpl extends BaseServiceImpl<Attachment, String> implements AttachmentService {

}
