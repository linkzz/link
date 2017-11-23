/**
 * Copyright (c) 2011-2013, dafei 李飞 (myaniu AT gmail DOT com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.link.common.plugin.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

import java.util.concurrent.ConcurrentMap;


/**
 * ShiroKit. (Singleton, ThreadSafe)
 *
 * @author dafei
 */
public class ShiroKit {

	/**
	 * 登录成功时所用的页面。
	 */
	private static String successUrl = "/";

	/**
	 * 登录成功时所用的页面。
	 */
	private static String loginUrl = "/login.html";


	/**
	 * 登录成功时所用的页面。
	 */
	private static String unauthorizedUrl ="/401.html";


	/**
	 * Session中保存的请求的Key值
	 */
	private static String SAVED_REQUEST_KEY = "jfinalShiroSavedRequest";


	/**
	 * 用来记录那个action或者actionpath中是否有shiro认证注解。
	 */
	private static ConcurrentMap<String, AuthzHandler> authzMaps = null;

	/**
	 * 禁止初始化
	 */
	private ShiroKit() {}

	static void init(ConcurrentMap<String, AuthzHandler> maps) {
		authzMaps = maps;
	}

	static AuthzHandler getAuthzHandler(String actionKey){
		/*
		if(authzMaps.containsKey(controllerClassName)){
			return true;
		}*/
		return authzMaps.get(actionKey);
	}

	public static final String getSuccessUrl() {
		return successUrl;
	}

	public static final void setSuccessUrl(String successUrl) {
		ShiroKit.successUrl = successUrl;
	}

	public static final String getLoginUrl() {
		return loginUrl;
	}

	public static final void setLoginUrl(String loginUrl) {
		ShiroKit.loginUrl = loginUrl;
	}

	public static final String getUnauthorizedUrl() {
		return unauthorizedUrl;
	}

	public static final void setUnauthorizedUrl(String unauthorizedUrl) {
		ShiroKit.unauthorizedUrl = unauthorizedUrl;
	}
	/**
	 * Session中保存的请求的Key值
	 * @return
	 */
	public static final String getSavedRequestKey(){
		return SAVED_REQUEST_KEY;
	}

	/**
	 * 获取subject
	 */
	public static Subject getSubject(){
		return SecurityUtils.getSubject();
	}

	/**
	 *已认证通过的用户，不包含已记住的用户，这是与user标签的区别所在。
	 * 与notAuthenticated搭配使用
	 * @return 通过身份验证 true 否则 false
	 */
	public static boolean isAuthenticated(){
		return getSubject() != null && getSubject().isAuthenticated();
	}

	/**
	 * 从shiro中获取session
	 * @return session
	 */
	public static Session getSession(){
		return getSubject().getSession();
	}

	public static boolean hasPermission(String url) {
		return true;
	}
}
