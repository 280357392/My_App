package cn.itcast.mybottomnavigationbar.fragment;

import android.os.Bundle;

import cn.itcast.mybottomnavigationbar.R;
import cn.itcast.mybottomnavigationbar.adapter.ViewPagerAdapter;
import cn.itcast.mybottomnavigationbar.fragment.fragment_viewPager.DefaultFragment;
import cn.itcast.mybottomnavigationbar.utils.UIUtils;


/**
 * 综合页
 */
public class OneFragment extends BasePagerFragment {

    @Override
    protected void addPageToAdapter(ViewPagerAdapter adapter) {
        String[] titles = UIUtils.getStringArray(R.array.news_viewpage_arrays);
        //传入1.SlidingTab标题、2.fragment、3.携带参数
        adapter.addPage(titles[0], DefaultFragment.class, getBundle(0));
        adapter.addPage(titles[1], DefaultFragment.class, getBundle(1));
        adapter.addPage(titles[2], DefaultFragment.class, getBundle(2));
        adapter.addPage(titles[3], DefaultFragment.class, getBundle(3));
    }

    private Bundle getBundle(int newType) {
        Bundle bundle = new Bundle();
        bundle.putInt(DefaultFragment.BUNDLE_KEY_CATALOG, newType);
        bundle.putString("key", "我是综合里的" + newType);
        return bundle;
    }
}
