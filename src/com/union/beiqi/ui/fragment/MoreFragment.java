package com.union.beiqi.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.union.beiqi.R;
import com.union.beiqi.ui.base.BaseFragment;

public class MoreFragment extends BaseFragment
{
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		return super.createView(inflater.inflate(R.layout.fragment_more, container, false));
	}
	
	@Override
	protected void findWidgets()
	{
	}
	
	@Override
	protected void initComponent()
	{
	}
}
