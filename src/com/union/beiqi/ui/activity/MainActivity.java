package com.union.beiqi.ui.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

import com.union.beiqi.R;
import com.union.beiqi.base.constant.Constant;
import com.union.beiqi.base.tools.ToastUtils;
import com.union.beiqi.ui.base.BaseActivity;
import com.union.beiqi.ui.fragment.HomeFragment;
import com.union.beiqi.ui.fragment.MallFragment;
import com.union.beiqi.ui.fragment.MoreFragment;
import com.union.beiqi.ui.fragment.TaskFragment;
import com.union.beiqi.ui.widget.FragmentTabHost;

public class MainActivity extends BaseActivity
{
	private static final String HOME = "首页";
	private static final String TASK = "任务";
	private static final String MALL = "商城";
	private static final String MORE = "更多";
	private FragmentTabHost mTabHost;
	private long exitTime = 0;
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		super.onCreateView(R.layout.activity_main);
	}
	
	@Override
	protected void findWidgets()
	{
		mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
	}
	
	@Override
	protected void initComponent()
	{
		initTabHost();
	}
	
    private void initTabHost()
	{
		mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);
		mTabHost.addTab(mTabHost.newTabSpec(Constant.TAB_TAG_HOME).setIndicator(createIndicatorView(R.drawable.selector_maintab_nav_home, HOME)), HomeFragment.class, new Bundle());
		mTabHost.addTab(mTabHost.newTabSpec(Constant.TAB_TAG_TASK).setIndicator(createIndicatorView(R.drawable.selector_maintab_nav_task, TASK)), TaskFragment.class, new Bundle());
		mTabHost.addTab(mTabHost.newTabSpec(Constant.TAB_TAG_MALL).setIndicator(createIndicatorView(R.drawable.selector_maintab_nav_mall, MALL)), MallFragment.class, new Bundle());
		mTabHost.addTab(mTabHost.newTabSpec(Constant.TAB_TAG_MORE).setIndicator(createIndicatorView(R.drawable.selector_maintab_nav_more, MORE)), MoreFragment.class, new Bundle());
	}
	
	public FragmentTabHost getTabHost()
	{
		return mTabHost;
	}
	
	@SuppressLint("InflateParams")
	private View createIndicatorView(int selectorRes, String indictorName)
	{
		TextView textView = (TextView) getLayoutInflater().inflate(R.layout.item_maintab_navigation, null);
		textView.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(selectorRes), null, null);
		textView.setText(indictorName);
		return textView;
	}
	
	@Override
	public boolean dispatchKeyEvent(KeyEvent event)
	{
		if (event.getKeyCode() == KeyEvent.KEYCODE_BACK)
		{
			if (event.getAction() == KeyEvent.ACTION_DOWN && event.getRepeatCount() == 0)
			{
				if (TextUtils.equals(mTabHost.getCurrentTabTag(), Constant.TAB_TAG_HOME))
				{
					exitApp();
				} else
				{
					mTabHost.setCurrentTabByTag(Constant.TAB_TAG_HOME);
				}
				return true;
			}
		}
		return super.dispatchKeyEvent(event);
	}
	
	private void exitApp()
	{
		if ((System.currentTimeMillis() - exitTime) > 2000)
		{
			ToastUtils.custom("再按一次退出程序");
			exitTime = System.currentTimeMillis();
		} else
		{
			getApplication().onTerminate();
		}
	}
}
