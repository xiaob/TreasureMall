package com.union.beiqi.ui.fragment;

import java.util.List;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.union.beiqi.R;
import com.union.beiqi.base.tools.ProxyUtils;
import com.union.beiqi.service.entity.GameBean;
import com.union.beiqi.service.entity.GameBean.GameData;
import com.union.beiqi.ui.base.BaseFragment;

public class TaskFragment extends BaseFragment implements OnClickListener
{
	private TextView subjectTxt;
	private Button queryBtn;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		return super.createView(inflater.inflate(R.layout.fragment_task, container, false));
	}
	
	@Override
	protected void findWidgets()
	{
		subjectTxt = findView(R.id.tv_subject_content);
		queryBtn = findView(R.id.btn_money_query);
	}
	
	@Override
	protected void initComponent()
	{
		subjectTxt.setText("加载中...");
	}
	
	@Override
	protected void initListener()
	{
		queryBtn.setOnClickListener(this);
	}
	
	@Override
	protected void asyncRetrive()
	{
//		ProxyUtils.getHttpProxy().getAllGameList(this);
	}
	
	protected void refreshGames(GameBean bean)
	{
		List<GameData> games = bean.getGames();
		subjectTxt.setText(games.toString());
	}

	@Override
	public void onClick(View v)
	{
		ProxyUtils.getHttpProxy().getAllGameList(this);
	}
}
