package com.union.beiqi.service.http;

import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.toolbox.Volley;
import com.android.volley.VolleyError;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.union.beiqi.R;
import com.union.beiqi.base.constant.ErrorCode;
import com.union.beiqi.base.tools.DialogUtils;
import com.union.beiqi.base.tools.JsonUtils;
import com.union.beiqi.base.tools.LogUtils;
import com.union.beiqi.base.tools.NetUtil;
import com.union.beiqi.base.tools.ReflectUtils;
import com.union.beiqi.base.tools.ToastUtils;
import com.union.beiqi.ui.base.BaseActivity;
import com.union.beiqi.ui.base.BaseFragment;

public class HttpResponseHandler implements Response.Listener<JSONObject>,ErrorListener{
	private static final int SUCCESS = 0;
	private static final String OPCODE = "opcode";
	private static final String RESULT = "result";
	private static final String ERROR = "showErrorMessage";
	private Object context;
	private Class<?> resultCls;
	private String refreshMethod;
	private RequestQueue mVolleyQueue;
	public HttpResponseHandler(Object context, Class<?> resultCls, String refreshMethod)
	{
		this.context = context;
		this.resultCls = resultCls;
		this.refreshMethod = refreshMethod;
	}

	@Override
	public void onErrorResponse(VolleyError arg0) {
		DialogUtils.showError(context);
	}

	@Override
	public void onResponse(JSONObject response) {
		DialogUtils.dismissLoading();
		LogUtils.e(response.toString());
		try
		{
			if (response.getInt(OPCODE) == SUCCESS)
			{
				Object bean = JsonUtils.parserJSONObject(response, resultCls);
				ReflectUtils.invokeMethod(context, refreshMethod, bean, resultCls);
			} else
			{
				throw new JSONException(ErrorCode.getErrorMessage(response.getInt(OPCODE)));
			}
		} catch (Exception e)
		{
			ReflectUtils.invokeMethod(context, ERROR, e.getMessage(), String.class);
		}
	}
	
	
}
