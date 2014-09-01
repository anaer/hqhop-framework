package com.hqhop.framework.web.dao.impl;

import com.hqhop.framework.common.bind.annotation.Repository;
import com.hqhop.framework.common.orm.hibernate.BaseRepoitoryImpl;
import com.hqhop.framework.web.dao.AttachmentDao;
import com.hqhop.framework.web.entity.Attachment;

@Repository(entity = Attachment.class)
public class AttachmentDaoImpl extends BaseRepoitoryImpl<Attachment, String> implements AttachmentDao {

}
