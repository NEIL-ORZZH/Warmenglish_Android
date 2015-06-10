package com.kot32.warmenglish.view;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.kot32.warmenglish.R;
import com.kot32.warmenglish.fragment.MainFragment;
import com.kot32.warmenglish.util.LoginUtil;
import com.kot32.warmenglish.util.UILoader;

public class MainPage extends BaseActivity {

    private Toolbar toolbar;
    private DrawerLayout mDrawerLayout;
    private LoginUtil loginUtil;
    private FragmentManager fragmentManager;
    private MainFragment mainFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    void initData() {
        loginUtil = new LoginUtil(MainPage.this, LoginUtil.AUTO_LOGIN) {
            @Override
            public void finish() {
                super.finish();

            }
        };
        fragmentManager=getSupportFragmentManager();
        mainFragment=MainFragment.newInstance();

    }

    @Override
    void initView() {
        Fresco.initialize(this);
        setContentView(R.layout.activity_main_page);
        setTitle("温暖英语");
        toolbar = (Toolbar) findViewById(R.id.tl_custom);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(0xffffffff);
        //初始化侧滑菜单
        mDrawerLayout = UILoader.initDrawerLayout(this, toolbar);
        //替换主Fragment
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        transaction.replace(R.id.main_content,mainFragment);
        transaction.commit();
    }

    @Override
    void initControl() {
        loginUtil.login();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Fresco.shutDown();
        loginUtil.cancel();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //更新数据
        updateData();
    }


    void updateData() {
        UILoader.updateDrawerUI(mDrawerLayout, this);
    }
}
