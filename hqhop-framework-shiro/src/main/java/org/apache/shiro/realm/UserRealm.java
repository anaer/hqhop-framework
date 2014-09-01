package org.apache.shiro.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.hqhop.framework.common.orm.search.SearchOperator;
import com.hqhop.framework.common.orm.search.Searchable;
import com.hqhop.framework.shiro.entity.User;
import com.hqhop.framework.shiro.service.UserService;

/**
 * 
 * @author silentwu
 * 
 */
public class UserRealm extends AuthorizingRealm {

	@Autowired
	private UserService userService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		String username = (String) principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		// authorizationInfo.setRoles(userService.findRoles(username));
		// authorizationInfo.setStringPermissions(userService.findPermissions(username));
		return authorizationInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String userName = token.getPrincipal().toString().trim(); // 得到用户名
		String password = new String((char[]) token.getCredentials()); // 得到密码
		Searchable searchable = Searchable.newSearchable();
		searchable.addSearchFilter("name", SearchOperator.eq, userName);
		System.out.println(userName);
		System.out.println(password);
		User user = userService.findObject(searchable);
		System.out.println(user);
		if (!userName.equals(user.getName().trim())) {
			throw new UnknownAccountException(); // 如果用户名错误
		}
		if (!password.equals(user.getPassword().trim())) {
			throw new IncorrectCredentialsException(); // 如果密码错误
		}
		// 交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，如果觉得人家的不好可以自定义实现
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(userName, // 用户名
				password, // 密码
				getName() // realm name
		);
		return authenticationInfo;
	}
}
