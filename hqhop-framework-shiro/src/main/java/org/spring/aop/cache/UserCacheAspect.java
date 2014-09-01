package org.spring.aop.cache;

import java.util.List;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.hqhop.framework.common.cache.aop.BaseCacheAspect;
import com.hqhop.framework.shiro.entity.User;

/**
 * 用户缓存切面 缓存实现
 */
@Component
@Aspect
public class UserCacheAspect extends BaseCacheAspect {
	 
	public UserCacheAspect() {
		setCacheName("userCache");
	}

	/**
	 * 匹配用户Service
	 */
	@Pointcut(value = "target(com.hqhop.framework.shiro.service.impl.UserServiceImpl)")
	private void userServicePointcut() {
	}

	/**
	 * only put
	 */
	@Pointcut(value = "execution(* save(..)) " + "|| execution(* update(..)) ")
	private void cachePutPointcut() {
	}

	@AfterReturning(value = "userServicePointcut() && cachePutPointcut()", returning = "user")
	public void cachePutAdvice(Object user) {
		System.out.println("cachePutAdvice....");
		// put cache
		put((User) user);
	}

	/**
	 * evict 比如删除
	 */
	@Pointcut(value = "(execution(* remove*(*))) && args(arg)", argNames = "arg")
	private void cacheEvictPointcut(Object arg) {
	}

	@After(value = "userServicePointcut() && cacheEvictPointcut(arg)", argNames = "arg")
	public void cacheEvictAdvice(Object arg) {
		if (arg == null) {
			this.clear();
			return;
		} else if (arg instanceof String[]) {
			for (String id : (String[]) arg) {
				// only evict id
				evictId(String.valueOf(id));
			}
		} else if (arg instanceof User) {
			// evict user
			evict((User) arg);
		} else if (arg instanceof List) {
			for (Object o : (List) arg) {
				// only evict id
				evict((User) o);
			}
		}
	}

	/**
	 * 查询
	 */
	@Pointcut(value = "(execution(* findObject(*)))")
	private void cacheablePointcut() {
	}

	@Around(value = "userServicePointcut() && cacheablePointcut()")
	public Object cacheableAdvice(ProceedingJoinPoint pjp) throws Throwable {

		Object arg = pjp.getArgs().length >= 1 ? pjp.getArgs()[0] : null;
		User user = null;
		if (arg instanceof String) {
			user = this.get(arg);
		}
		// cache hit
		if (user != null) {
			log.debug("cacheName:{}, hit key:{}", cacheName, arg);
			return user;
		}
		log.debug("cacheName:{}, miss key:{}", cacheName, arg);

		// cache miss
		user = (User) pjp.proceed();
		// put cache
		put(user);
		return user;
	}

	public void put(User user) {
		if (user == null) {
			return;
		}
		String id = user.getId();
		// username ---> id
		put(user.getName(), id);
		// id ---> user
		put(id, user);
	}

	public void evictId(String id) {
		evict(id);
	}

	public void evict(User user) {
		if (user == null) {
			return;
		}
		String id = user.getId();
		evict(id);
		evict(user.getName());
	}

}
