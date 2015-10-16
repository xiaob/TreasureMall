package com.union.beiqi.ui.listener;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

import com.union.beiqi.base.tools.IntentUtils;
import com.union.beiqi.ui.activity.MainActivity;
import com.union.beiqi.ui.activity.WelcomeActivity;

public class WelcomeAnimatorListener implements AnimationListener
{
	private WelcomeActivity welcomeActivity;
	
	public WelcomeAnimatorListener(WelcomeActivity welcomeActivity)
	{
		this.welcomeActivity = welcomeActivity;
	}
	
	@Override
	public void onAnimationStart(Animation animation)
	{
	}
	
	@Override
	public void onAnimationEnd(Animation animation)
	{
		IntentUtils.startAty(welcomeActivity, MainActivity.class);
	}
	
	@Override
	public void onAnimationRepeat(Animation animation)
	{
	}
}
