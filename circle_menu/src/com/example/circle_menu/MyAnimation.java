package com.example.circle_menu;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.RotateAnimation;

public class MyAnimation {

	public static void startAnimationIn(ViewGroup viewGroup,int duration){
		for (int i = 0; i < viewGroup.getChildCount(); i++) {
			viewGroup.getChildAt(i).setVisibility(View.VISIBLE);//可见
			viewGroup.getChildAt(i).setFocusable(true);//焦点
			viewGroup.getChildAt(i).setClickable(true);//点击
			
			Animation animation;//动画
			
			animation=new RotateAnimation(-180, 0, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 1.0f);
			animation.setDuration(duration);
			animation.setFillAfter(true);
			
			viewGroup.startAnimation(animation);
			
		}
	}
	
	public static void startAnimationOut(final ViewGroup viewGroup,int duration,int startOffset){
		
		Animation animation;
		animation=new RotateAnimation(0, 180, Animation.RELATIVE_TO_SELF,0.5f, Animation.RELATIVE_TO_SELF, 1.0f);
		animation.setDuration(duration);
		animation.setFillAfter(true);
		animation.setStartOffset(startOffset);
		
		animation.setAnimationListener(new AnimationListener() {
			
			@Override
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationEnd(Animation animation) {
				// TODO Auto-generated method stub
				for(int i = 0; i < viewGroup.getChildCount(); i++ ){      
                    viewGroup.getChildAt(i).setVisibility(View.GONE);//设置显示      
                    viewGroup.getChildAt(i).setFocusable(false);//获得焦点      
                    viewGroup.getChildAt(i).setClickable(false);//可以点击      
                }      
			}
		});
		viewGroup.startAnimation(animation);
	}
	
}
