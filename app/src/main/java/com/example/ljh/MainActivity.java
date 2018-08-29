package com.example.ljh;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends FragmentActivity implements View.OnClickListener {
    TextView[] tv = new TextView[3];
    ViewPager vp1;
    ViewPagerAdapter vpAdapter;
    Fragment[] fragment = new Fragment[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv[0] = findViewById(R.id.tv1);
        tv[1] = findViewById(R.id.tv2);
        tv[2] = findViewById(R.id.tv3);
        vp1 = findViewById(R.id.vp1);

        fragment[0] = new ShopFragment();
        fragment[1] = new CalendarFragment();
        fragment[2] = new StopWatchFragment();

        vpAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        vp1.setAdapter(vpAdapter);

        for (int i = 0; i <3; i++) {
            tv[i].setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv1: vp1.setCurrentItem(0); break;
            case R.id.tv2: vp1.setCurrentItem(1); break;
            case R.id.tv3: vp1.setCurrentItem(2); break;
        }

    }

    class ViewPagerAdapter extends FragmentStatePagerAdapter{
        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            return fragment[i];
        }

        @Override
        public int getCount() {
            return fragment.length;
        }
    }
}
