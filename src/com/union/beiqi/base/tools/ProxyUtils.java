package com.union.beiqi.base.tools;

import java.lang.reflect.Proxy;

import com.union.beiqi.service.api.IHttpService;
import com.union.beiqi.service.http.HttpProxyInvocation;

public class ProxyUtils
{
	private static HttpProxyInvocation proxyHandler = new HttpProxyInvocation();
	
	public static IHttpService getHttpProxy()
	{
		return (IHttpService) Proxy.newProxyInstance(proxyHandler.getClass().getClassLoader(), new Class[]{IHttpService.class}, proxyHandler);
	}
}
