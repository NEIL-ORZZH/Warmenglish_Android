package com.kot32.warmenglish.view;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.kot32.warmenglish.R;
import com.kot32.warmenglish.util.SystemStatus;
import com.kot32.warmenglish.wight.ColorAnimationView;

public class WelcomePage extends FragmentActivity {
    private static final int[] resource = new int[]{R.drawable.welcome1, R.drawable.welcome4,
            R.drawable.welcome3, R.drawable.welcome4};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_page);
        MyFragmentStatePager adpter = new MyFragmentStatePager(getSupportFragmentManager());
        ColorAnimationView colorAnimationView = (ColorAnimationView) findViewById(R.id.ColorAnimationView);
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setAdapter(adpter);

        //设置渐变颜色
        colorAnimationView.setmViewPager(viewPager, resource.length);
        colorAnimationView.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }


    public class MyFragmentStatePager
            extends FragmentStatePagerAdapter {

        public MyFragmentStatePager(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return new MyFragment(position);
        }

        @Override
        public int getCount() {
            return resource.length;
        }
    }

    @SuppressLint("ValidFragment")
    public class MyFragment
            extends Fragment {
        private int position;

        public MyFragment(int position) {
            this.position = position;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            ImageView imageView = new ImageView(getActivity());
            imageView.setImageResource(resource[position]);
            if(position==resource.length-1){
                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SystemStatus.setFirstComeIn(getApplicationContext());
                        Intent intent=new Intent(WelcomePage.this,MainPage.class);
                        startActivity(intent);
                        finish();
                    }
                });
            }

            return imageView;
        }
    }
}
