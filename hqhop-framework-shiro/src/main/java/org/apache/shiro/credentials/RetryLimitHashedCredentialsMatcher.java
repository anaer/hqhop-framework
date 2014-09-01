package org.apache.shiro.credentials;

import java.util.concurrent.atomic.AtomicInteger;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;

/**
 * 
 * @author silentwu
 * 
 */
public class RetryLimitHashedCredentialsMatcher extends HashedCredentialsMatcher {

	private Cache passwordRetryCache;
	/**
	 * 重复登录错误的次数
	 */
	private int retryNum;

	public RetryLimitHashedCredentialsMatcher(CacheManager cacheManager) {
		passwordRetryCache = cacheManager.getCache("passwordRetryCache");
	}

	@Override
	public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
		String username = (String) token.getPrincipal();
		// retry count + 1
		AtomicInteger retryCount = (AtomicInteger) passwordRetryCache.get(username).get();
		if (retryCount == null) {
			retryCount = new AtomicInteger(0);
			passwordRetryCache.put(username, retryCount);
		}
		if (retryCount.incrementAndGet() > retryNum) {
			// if retry count > 5 throw
			throw new ExcessiveAttemptsException();
		}
		boolean matches = super.doCredentialsMatch(token, info);
		if (matches) {
			// clear retry count
			passwordRetryCache.evict(username);
		}
		return matches;
	}

	public int getRetryNum() {
		return retryNum;
	}

	public void setRetryNum(int retryNum) {
		this.retryNum = retryNum;
	}

}
