package com.kot32.warmenglish.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.kot32.warmenglish.R;
import com.kot32.warmenglish.util.SystemStatus;


public class LogoPage extends BaseActivity {

    private ImageView logo_img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    void initData() {


    }

    @Override
    void initView() {

        setContentView(R.layout.activity_logo_page);
        logo_img = (ImageView) findViewById(R.id.logo_img);
    }

    @Override
    void initControl() {
        logo_img.setBackgroundResource(R.drawable.splash);
        ObjectAnimator animator = ObjectAnimator.ofFloat(logo_img, "alpha", 0.0f, 1.0f).setDuration(2000);
        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                Intent intent = new Intent();
                //渐变完成后检查是否是第一次进入APP，再判断跳转到哪个页面
                if (SystemStatus.checkIsFirstComeIn(getApplicationContext())) {
                    intent.setClass(LogoPage.this, WelcomePage.class);
                } else {
                    intent.setClass(LogoPage.this, MainPage.class);
                }
                startActivity(intent);
                finish();
            }
        });
        animator.start();
    }



}

