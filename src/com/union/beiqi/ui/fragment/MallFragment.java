package com.union.beiqi.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.union.beiqi.R;
import com.union.beiqi.base.tools.ProxyUtils;
import com.union.beiqi.service.entity.PersonalBean;
import com.union.beiqi.ui.base.BaseFragment;

public class MallFragment extends BaseFragment
{
	private TextView balanceTxt;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		return super.createView(inflater.inflate(R.layout.fragment_mall, container, false));
	}
	
	@Override
	protected void findWidgets()
	{
		balanceTxt = findView(R.id.tv_personal_balance);
	}
	
	@Override
	protected void initComponent()
	{
		balanceTxt.setText("读取中...");
	}
	
	@Override
	protected void asyncRetrive()
	{
//		ProxyUtils.getHttpProxy().getUserInfo("session", this);
	}
	
	protected void refreshPersonal(PersonalBean perosnal)
	{
		balanceTxt.setText(perosnal.getUserBalance());
	}
	
}
