package com.kot32.warmenglish.view;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.ViewGroup;

import com.github.florent37.materialviewpager.MaterialViewPager;
import com.kot32.warmenglish.R;
import com.kot32.warmenglish.fragment.RecyclerViewFragment;
import com.kot32.warmenglish.fragment.ScrollFragment;
import com.kot32.warmenglish.util.UILoader;

public class ProblemsPage extends BaseActivity {

    private MaterialViewPager mViewPager;
    private DrawerLayout mDrawer;
    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    void initView() {
        setContentView(R.layout.activity_problems_page);
        setTitle("");

        mViewPager = (MaterialViewPager) findViewById(R.id.materialViewPager);

        toolbar = mViewPager.getToolbar();
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }
        mDrawer = UILoader.initDrawerLayout(this, toolbar);
    }

    @Override
    void initData() {

    }

    @Override
    void initControl() {


        //设置适配器
        mViewPager.getViewPager().setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {

            int oldPosition = -1;

            @Override
            public Fragment getItem(int position) {
                switch (position % 4) {

                    case 1:
                        return RecyclerViewFragment.newInstance();
                    default:
                        return ScrollFragment.newInstance();
                }

            }

            @Override
            public void setPrimaryItem(ViewGroup container, int position, Object object) {
                super.setPrimaryItem(container, position, object);

                //only if position changed
                if (position == oldPosition)
                    return;
                oldPosition = position;

                int color = 0;
                Drawable bg_img = getResources().getDrawable(R.drawable.md1);
                switch (position % 4) {
                    case 0:

                        color = getResources().getColor(R.color.blue);
                        break;
                    case 1:
                        bg_img = getResources().getDrawable(R.drawable.md2);
                        color = getResources().getColor(R.color.green);
                        break;
                    case 2:
                        bg_img = getResources().getDrawable(R.drawable.md3);
                        color = getResources().getColor(R.color.cyan);
                        break;
                    case 3:
                        bg_img = getResources().getDrawable(R.drawable.md4);
                        color = getResources().getColor(R.color.red);
                        break;
                }

                final int fadeDuration = 400;

                mViewPager.setImageDrawable(bg_img, fadeDuration);
                mViewPager.setColor(color, fadeDuration);

            }

            @Override
            public int getCount() {
                return 100;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                switch (position % 4) {
                    case 0:
                        return "   选择题   ";
                    case 1:
                        return "   完型填空   ";
                    case 2:
                        return "   阅读题   ";
                    case 3:
                        return "   作文题   ";
                }
                return "";
            }
        });

        mViewPager.getViewPager().setOffscreenPageLimit(mViewPager.getViewPager().getAdapter().getCount());
        mViewPager.getPagerTitleStrip().setViewPager(mViewPager.getViewPager());

        mViewPager.getViewPager().setCurrentItem(0);
    }


    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }
}
