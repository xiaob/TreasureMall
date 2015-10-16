package com.union.beiqi.service.http;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;
import com.union.beiqi.R;
import com.union.beiqi.base.annotation.HttpRequest;
import com.union.beiqi.base.constant.Constant;
import com.union.beiqi.base.tools.DialogUtils;
import com.union.beiqi.base.tools.NetUtil;
import com.union.beiqi.base.tools.ReflectUtils;
import com.union.beiqi.base.tools.ToastUtils;
import com.union.beiqi.ui.base.BaseActivity;
import com.union.beiqi.ui.base.BaseFragment;

public class HttpProxyInvocation implements InvocationHandler
{	
	private RequestQueue mVolleyQueue;
	@Override
	public Object invoke(Object proxy, Method method, Object[] params) throws Throwable
	{
		String[] arguments = method.getAnnotation(HttpRequest.class).arguments();
		Class<?> resultCls = method.getAnnotation(HttpRequest.class).resultClass();
		String refreshMethod = method.getAnnotation(HttpRequest.class).refreshMethod();
		HttpResponseHandler response = ReflectUtils.constructHttpResponse(params[0], resultCls, refreshMethod);
		httpPost(Constant.BASE_URL + method.getName(),params,response,createRequestParams(arguments, params));
		return new Object();
	}

	private Map<String, String> createRequestParams(String[] arguments, Object[] params)
	{
		Map<String, String> requestParams = new HashMap<String, String>();
		for (int pos = 0; pos < arguments.length; pos++)
		{
			requestParams.put(arguments[pos], params[pos+1].toString());
		}
		return requestParams;
	}


	/**
	 * httpPost 请求
	 * @param <T>
	 */
	public void httpPost(String url, Object[] params,HttpResponseHandler response,Map<String, String> mapParms){
		Context context;
		if(params[0] instanceof BaseActivity){
			context = (Context)params[0]; 
		}else{
			context = ((BaseFragment)params[0]).getActivity(); 
		}
		DialogUtils.showLoading(context);
		mVolleyQueue = Volley.newRequestQueue(context);
		if(NetUtil.isHasNet(context)){
			JsonObjectPostRequest request = new JsonObjectPostRequest(url,response, response,mapParms);
			mVolleyQueue.add(request);
		}else{
			
		}
	}
}
