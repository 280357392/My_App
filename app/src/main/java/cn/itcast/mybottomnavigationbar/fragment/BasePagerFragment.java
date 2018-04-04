package cn.itcast.mybottomnavigationbar.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.itcast.mybottomnavigationbar.R;
import cn.itcast.mybottomnavigationbar.adapter.ViewPagerAdapter;
import cn.itcast.mybottomnavigationbar.widget.PagerSlidingTab;

/**
 * Created by mengwei on 2018/4/4.
 */

public abstract class BasePagerFragment extends Fragment{

    Unbinder unbinder;
    @BindView(R.id.slidingTab)
    PagerSlidingTab mSlidingTab;
    @BindView(R.id.pager)
    ViewPager mViewPager;
    private ViewPagerAdapter mAdapter;
    private FragmentActivity mActivity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_base_pager, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mActivity = getActivity();
        //绑定SlidingTab与Viewpager
        mAdapter = new ViewPagerAdapter(getChildFragmentManager(),mActivity);
        addPageToAdapter(mAdapter);//为adapter添加数据，子类实现
        mViewPager.setAdapter(mAdapter);
        mSlidingTab.setViewPager(mViewPager);

        setScreenPageLimit(mViewPager);
    }

    /**
     * 设置ViewPager能够缓存的页数(允许子类重写)
     * @param viewPager
     */
    protected void setScreenPageLimit(ViewPager viewPager) {
        mViewPager.setOffscreenPageLimit(mViewPager.getAdapter().getCount()-1);//缓存所有
    }

    /**
     * 抽象方法，子类设置SlidingTab与Viewpager
     * @param adapter
     */
    protected abstract void addPageToAdapter(ViewPagerAdapter adapter);

    //重写：解决重叠问题,硬性规定。（让每个类都重写的方法就是修改基类）
    @Override
    public void setMenuVisibility(boolean menuVisible) {
        super.setMenuVisibility(menuVisible);
        View view = getView();//返回当前Fragment视图
        if (view != null) {
            view.setVisibility(menuVisible ? View.VISIBLE : View.INVISIBLE);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
