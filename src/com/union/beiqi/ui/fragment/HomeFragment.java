package com.union.beiqi.ui.fragment;

import org.json.JSONObject;

import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.union.beiqi.R;
import com.union.beiqi.base.tools.LogUtils;
import com.union.beiqi.base.tools.ProxyUtils;
import com.union.beiqi.ui.base.BaseFragment;

public class HomeFragment extends BaseFragment implements OnClickListener
{
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		return super.createView(inflater.inflate(R.layout.fragment_home, container, false));
	}
	
	@Override
	protected void findWidgets()
	{
	}
	
	@Override
	protected void initComponent()
	{
	}
	
	@Override
	protected void initListener()
	{
		ProxyUtils.getHttpProxy().clientLogin(this,"123456","13709201950");
	}
	
	
	@Override
	public void onClick(View v)
	{
	}
}
