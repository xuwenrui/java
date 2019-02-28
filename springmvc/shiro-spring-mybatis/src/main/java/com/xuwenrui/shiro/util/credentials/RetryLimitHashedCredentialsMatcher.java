package com.xuwenrui.shiro.util.credentials;

import java.util.concurrent.atomic.AtomicInteger;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;

/**
 * @author 作者:ManrayHsu
 * @Email 386277405@qq.com
 * @date 创建时间: 2016年3月17日
 * @version 1.0
 * @since
 */
/*
 * Shiro默认的Realms的认证实现 n所有Shiro 立即可用的Realm
 * 的实现默认使用SimpleCredentialsMatcher。SimpleCredentialsMatcher
 * 执行一个普通的直接相等性的检查，也就是在存储的帐户credentials 与在AuthenticationToken 所提交的之间的检查。
 * n使用Hashing Credentials 如果要使用Hashing
 * Credentials，那么需要在配置中告诉验证器，使用相应的匹配器，这个在前面示例过。
 * 但是前面直接使用的Sha256Matcher，已经不推荐使用了，现在推荐使用统一的HashedCredentialsMatcher，然后配置具体的算法名称
 * ，这些名称按照Java Security Framework里面的标准名称来配置。常见的名称有： MD5、AES 、DES
 * 、SHA-1、SHA-256、SHA-384、SHA-512……很多
 * 具体可以参见：http://docs.oracle.com/javase/6/docs/technotes/guides/security/
 * StandardNames.html
 */
public class RetryLimitHashedCredentialsMatcher extends HashedCredentialsMatcher {

	private Cache<String, AtomicInteger> passwordRetryCache;

	public RetryLimitHashedCredentialsMatcher(CacheManager cacheManager) {
		passwordRetryCache = cacheManager.getCache("passwordRetryCache");
	}
	/**
	 * 匹配用户输入的token的凭证（未加密）与系统提供的凭证（已加密）
	 */
	@Override
	public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
		String username = (String) token.getPrincipal();
		// retry count + 1
		AtomicInteger retryCount = passwordRetryCache.get(username);
		if (retryCount == null) {
			retryCount = new AtomicInteger(0);
			passwordRetryCache.put(username, retryCount);
		}
		if (retryCount.incrementAndGet() > 5) {
			// if retry count > 5 throw
			throw new ExcessiveAttemptsException();
		}
		//匹配用户输入的token的凭证（未加密）与系统提供的凭证（已加密）
		boolean matches = super.doCredentialsMatch(token, info);
		if (matches) {
			// clear retry count
			passwordRetryCache.remove(username);
		}
		return matches;
	}
}
