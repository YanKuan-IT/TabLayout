package com.example.testone;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import java.util.List;

public class MyPageAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragmentList;

    public MyPageAdapter(@NonNull FragmentManager fm, List<Fragment> list) {
        super(fm);
        this.fragmentList = list;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        // 可以在这里设置title
        return super.getPageTitle(position);
    }
}
