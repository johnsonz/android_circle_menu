package com.example.circle_menu;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

public class MainActivity extends Activity {

	private ImageButton imagebtn_home;
	private ImageButton imagebtn_menu;
	private RelativeLayout rl_2;
	private RelativeLayout rl_3;
	
	private boolean isLevel2Show=true;
	private boolean isLevel3Show=true;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        imagebtn_home=(ImageButton)findViewById(R.id.imagebtn_home);
        imagebtn_menu=(ImageButton)findViewById(R.id.imagebtn_menu);
        
        rl_2=(RelativeLayout)findViewById(R.id.rl_2);
        rl_3=(RelativeLayout)findViewById(R.id.rl_3);
        
        imagebtn_menu.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (isLevel3Show) {
					//隐藏第三级菜单
					MyAnimation.startAnimationOut(rl_3, 1000, 0);
				}else {
					//显示第三级菜单
					MyAnimation.startAnimationIn(rl_3, 1000);
				}
				isLevel3Show=!isLevel3Show;
			}
		});
        
        imagebtn_home.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (isLevel2Show) {
					if (isLevel3Show) {
						//隐藏第三级菜单和第二级菜单
						MyAnimation.startAnimationOut(rl_3, 1000,0);
						
						//延迟1000毫秒
						new Handler().postDelayed(new Runnable() {
							
							@Override
							public void run() {
								// TODO Auto-generated method stub
								MyAnimation.startAnimationOut(rl_2, 1000, 0);
							}
						}, 800);
						
						
						isLevel3Show=!isLevel3Show;
					}else {
						//隐藏第二级菜单
						MyAnimation.startAnimationOut(rl_2, 1000, 0);
					}
				}else {
					//显示第二级菜单
					MyAnimation.startAnimationIn(rl_2, 1000);
				}
				isLevel2Show=!isLevel2Show;
			}
		});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
