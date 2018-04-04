package cn.itcast.mybottomnavigationbar.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by mengwei on 2018/4/4.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {

    //需要title
    //需要fragment集合
    private ArrayList<String> mTitles;
    private ArrayList<FragmentInfo> mFragmentInfos;
    private Context mContext;

    public ViewPagerAdapter(FragmentManager fm,Context Context) {
        super(fm);
        mContext = Context;
        mTitles = new ArrayList<>();
        mFragmentInfos = new ArrayList<>();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles.get(position);
    }

    @Override
    public Fragment getItem(int position) {
        FragmentInfo fragmentInfo = mFragmentInfos.get(position);
        return Fragment.instantiate(mContext,fragmentInfo.getClazz().getName(),fragmentInfo.getBundle());
    }

    @Override
    public int getCount() {
        return mFragmentInfos.size();
    }

    /**
     * 添加page
     * @param title
     */
    public void addPage(String title ,Class<?> clazz,Bundle bundle){
        mTitles.add(title);
        mFragmentInfos.add(new FragmentInfo(clazz,bundle));
    }


    /**
     * 封装每一页fragment的信息
     * 方便传参数
     */
    public class FragmentInfo{

        private Class<?> clazz;
        private Bundle bundle;

        public FragmentInfo(Class<?> clazz, Bundle bundle) {
            this.clazz = clazz;
            this.bundle = bundle;
        }

        public Class<?> getClazz() {
            return clazz;
        }

        public void setClazz(Class<?> clazz) {
            this.clazz = clazz;
        }

        public Bundle getBundle() {
            return bundle;
        }

        public void setBundle(Bundle bundle) {
            this.bundle = bundle;
        }
    }
}
