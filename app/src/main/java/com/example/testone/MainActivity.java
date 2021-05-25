package com.example.testone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;

import android.opengl.Visibility;
import android.os.Bundle;
import android.util.Log;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    ArrayList<Fragment> fragmentList = new ArrayList<>();

    ViewPager viewPager;

    MyPageAdapter myPageAdapter;

    TabLayout tab_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabFragment tabFragment1 = new TabFragment();
        TabFragment2 tabFragment2 = new TabFragment2();
        TabFragment3 tabFragment3 = new TabFragment3();

        fragmentList.add(tabFragment1);
        fragmentList.add(tabFragment2);
        fragmentList.add(tabFragment3);

        viewPager = findViewById(R.id.view_pager);

        myPageAdapter = new MyPageAdapter(getSupportFragmentManager(), fragmentList);
        viewPager.setAdapter(myPageAdapter);
        viewPager.setCurrentItem(0);
        viewPager.addOnPageChangeListener(new MyPageChangeListener());

        tab_layout = findViewById(R.id.tab_layout);
        tab_layout.addTab(tab_layout.newTab());
        tab_layout.addTab(tab_layout.newTab());
        tab_layout.addTab(tab_layout.newTab());
        tab_layout.setupWithViewPager(viewPager);

        // 在addTab的时候，设置Text，是不会生效的，代码中有removeAllTabs()
        // 在adapter中的getPageTitle进行设置也是可以的
        tab_layout.getTabAt(0).setText("tab1");
        tab_layout.getTabAt(1).setText("tab2");
        tab_layout.getTabAt(2).setText("tab3");
    }

    public class MyPageChangeListener implements ViewPager.OnPageChangeListener{
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            Log.d(TAG, "onPageScrolled: ");
        }

        @Override
        public void onPageSelected(int position) {
            Log.d(TAG, "onPageSelected: ");
        }

        @Override
        public void onPageScrollStateChanged(int state) {
            Log.d(TAG, "onPageScrollStateChanged: ");
        }
    }
}
