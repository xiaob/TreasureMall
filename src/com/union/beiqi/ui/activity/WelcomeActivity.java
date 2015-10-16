package com.union.beiqi.ui.activity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.union.beiqi.R;
import com.union.beiqi.ui.base.BaseActivity;
import com.union.beiqi.ui.listener.WelcomeAnimatorListener;

public class WelcomeActivity extends BaseActivity
{
	private ImageView loadingItem;
	private Animation welcomeAnimation;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		super.onCreateView(R.layout.activity_welcome);
	}
	
	@Override
	protected void findWidgets()
	{
		loadingItem = findView(R.id.iv_welcome_loading_item);
	}
	
	@Override
	protected void initComponent()
	{
		welcomeAnimation = AnimationUtils.loadAnimation(this, R.anim.welcome_loading);
		welcomeAnimation.setAnimationListener(new WelcomeAnimatorListener(this));
	}
	
	@Override
	protected void excuteOther()
	{
		loadingItem.startAnimation(welcomeAnimation);
	}
}
