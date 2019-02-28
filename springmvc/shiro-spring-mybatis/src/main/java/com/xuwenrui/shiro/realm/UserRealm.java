package com.xuwenrui.shiro.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.xuwenrui.shiro.entity.User;
import com.xuwenrui.shiro.service.UserService;


/**
 * @author 作者:ManrayHsu
 * @Email 386277405@qq.com
 * @date 创建时间: 2016年3月17日
 * @version 1.0
 * @since
 * AuthorizingRealm API见：http://shiro.apache.org/static/1.2.3/apidocs/org/apache/shiro/realm/AuthorizingRealm.html?is-external=true
 */
public class UserRealm extends AuthorizingRealm {

	@Autowired
	private UserService userService;
	/**
	 * 获取授权信息
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		String username = (String) principals.getPrimaryPrincipal();
		//根据用户名调用UserService接口获取角色及权限信息
		//Shiro提供了一个实现SimpleAuthorizationInfo，大多数时候使用这个即可
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		//userService.findRoles(username)获取权限集合
		authorizationInfo.setRoles(userService.findRoles(username));
		//userService.findPermissions(username)
		authorizationInfo.setStringPermissions(userService.findPermissions(username));
		return authorizationInfo;
	}
	/**
	 * 获取身份验证相关信息
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		//首先根据传入的用户名获取User信息
		String username = (String) token.getPrincipal();
		User user = userService.findByUsername(username);
		//如果user为空，那么抛出没找到帐号异常
		if (user == null) {
			throw new UnknownAccountException();// 没找到帐号
		}
		//如果user找到但锁定了抛出锁定异常
		if (Boolean.TRUE.equals(user.getLocked())) {
			throw new LockedAccountException(); // 帐号锁定
		}
		/**
		 * 最后生成AuthenticationInfo信息，交给间接父类AuthenticatingRealm使用CredentialsMatcher进行
		 * 判断密码是否匹配，如果不匹配将抛出密码错误异常IncorrectCredentialsException；另外如果密码重试此处太多将抛出
		 * 超出重试次数异常ExcessiveAttemptsException；在组装SimpleAuthenticationInfo信息时，需要传入：
		 * 身份信息（用户名）、凭据（密文密码）、盐（username+salt），CredentialsMatcher使用盐加密传入的明文密码和此处的密文密码进行匹配
		 */
		// 交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，如果觉得人家的不好可以自定义实现
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user.getUsername(), // 用户名
				user.getPassword(), // 密码
				ByteSource.Util.bytes(user.getCredentialsSalt()), // salt=username+salt
				getName() // realm name
		);
		return authenticationInfo;
	}
	/**
	 * 清除缓存
	 */
	@Override
	public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
		super.clearCachedAuthorizationInfo(principals);
	}

	@Override
	public void clearCachedAuthenticationInfo(PrincipalCollection principals) {
		super.clearCachedAuthenticationInfo(principals);
	}

	@Override
	public void clearCache(PrincipalCollection principals) {
		super.clearCache(principals);
	}

	public void clearAllCachedAuthorizationInfo() {
		getAuthorizationCache().clear();
	}

	public void clearAllCachedAuthenticationInfo() {
		getAuthenticationCache().clear();
	}

	public void clearAllCache() {
		clearAllCachedAuthenticationInfo();
		clearAllCachedAuthorizationInfo();
	}

}
