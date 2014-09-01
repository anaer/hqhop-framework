package org.apache.shiro.web.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import com.hqhop.framework.common.ApplicationConstants;
import com.hqhop.framework.common.orm.search.SearchOperator;
import com.hqhop.framework.common.orm.search.Searchable;
import com.hqhop.framework.shiro.entity.User;
import com.hqhop.framework.shiro.entity.enumtype.UserStatus;
import com.hqhop.framework.shiro.service.UserService;

/**
 * 验证用户过滤器 1、用户是否删除 2、用户是否锁定
 * 
 * @author silentwu
 */
public class SysUserFilter extends AccessControlFilter {

	@Autowired
	private UserService userService;

	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
		Subject subject = getSubject(request, response);
		if (subject == null) {
			return true;
		}
		String userName = (String) subject.getPrincipal();
		// 此处注意缓存 防止大量的查询db
		Searchable searchable = Searchable.newSearchable();
		searchable.addSearchFilter("name", SearchOperator.eq, userName);
		User user = userService.findObject(searchable);
		if (user == null) {
			return true;
		}
		// 把当前用户放到request中
		request.setAttribute(ApplicationConstants.CURRENT_USER, user);
		if (Boolean.TRUE.equals(user.getDeleted()) || user.getStatus() == UserStatus.blocked) {
			getSubject(request, response).logout();
		}
		return true;
	}

	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		return true;
	}

}
