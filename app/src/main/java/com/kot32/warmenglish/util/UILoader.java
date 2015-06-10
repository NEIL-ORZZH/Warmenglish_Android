package com.kot32.warmenglish.util;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.kot32.warmenglish.R;
import com.kot32.warmenglish.WarmApplication;
import com.kot32.warmenglish.model.pojo.Student;
import com.kot32.warmenglish.view.LoginPage;

/**
 * Created by kot32 on 15/5/31.
 */
public class UILoader {
    private UILoader() {
    }

    public static DrawerLayout initDrawerLayout(final ActionBarActivity activity, Toolbar toolbar) {


        final ActionBarDrawerToggle mDrawerToggle;
        final DrawerLayout drawerLayout = (DrawerLayout) activity.findViewById(R.id.drawer_layout);

        //设置ActionBar
        ActionBar actionBar = activity.getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setDisplayUseLogoEnabled(false);
        actionBar.setHomeButtonEnabled(true);
        //随着拉出Drawer而变化的指示器
        mDrawerToggle = new ActionBarDrawerToggle(activity, drawerLayout, toolbar, R.string.open_menu, R.string.close_menu) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                updateDrawerUI(drawerLayout,activity);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);

            }
        };
        mDrawerToggle.syncState();
        drawerLayout.setDrawerListener(mDrawerToggle);
        //更新视图
        updateDrawerUI(drawerLayout, activity);
        return drawerLayout;
    }

    public static void updateDrawerUI(DrawerLayout drawerLayout, final ActionBarActivity activity) {
        TextView nickname;
        RelativeLayout myInformation;
        nickname = (TextView) drawerLayout.findViewById(R.id.drawer_nick_name);
        myInformation=(RelativeLayout)drawerLayout.findViewById(R.id.my_information);
        Student student = ((WarmApplication) activity.getApplicationContext()).getStudent();

        if (student != null) {
            nickname.setText(student.getUsername());
            nickname.setClickable(false);
            myInformation.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(activity, LoginPage.class);
                    activity.startActivity(intent);
                }
            });
        } else {
            nickname.setText("请点击登录");
            nickname.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(activity, LoginPage.class);
                    activity.startActivity(intent);
                }
            });
            myInformation.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }


    }
}
