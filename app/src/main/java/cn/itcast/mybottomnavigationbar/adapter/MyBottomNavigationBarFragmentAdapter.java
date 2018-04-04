package cn.itcast.mybottomnavigationbar.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import cn.itcast.mybottomnavigationbar.fragment.FourFragment;
import cn.itcast.mybottomnavigationbar.fragment.OneFragment;
import cn.itcast.mybottomnavigationbar.fragment.ThreeFragment;
import cn.itcast.mybottomnavigationbar.fragment.TwoFragment;

//Fragment 的适配器.
public class MyBottomNavigationBarFragmentAdapter extends FragmentPagerAdapter {

    public MyBottomNavigationBarFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment =null;
        switch (position){
            case 0:
                fragment = new OneFragment();
                break;
            case 1:
                fragment = new TwoFragment();
                break;
            case 2:
                fragment = new ThreeFragment();
                break;
            case 3:
                fragment = new FourFragment();
                break;
        }
        return fragment;
    }

    //写死了数量4个
    @Override
    public int getCount() {
        return 4;
    }
}
