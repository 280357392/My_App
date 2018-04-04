package cn.itcast.mybottomnavigationbar.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.ashokvarma.bottomnavigation.TextBadgeItem;

import cn.itcast.mybottomnavigationbar.R;
import cn.itcast.mybottomnavigationbar.adapter.MyBottomNavigationBarFragmentAdapter;

/**
 * 使用谷歌的BottomNavigationBar导航栏时需导入：
 * compile 'com.ashokvarma.android:bottom-navigation-bar:2.0.4'
 */
public class MainActivity extends AppCompatActivity {

    private BottomNavigationBar bottomNavigationBar;
    private FrameLayout fragment_content;
    private MyBottomNavigationBarFragmentAdapter mFragmentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragment_content = (FrameLayout) findViewById(R.id.fragment_content);
        bottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);

        FragmentManager fm = getSupportFragmentManager();
        mFragmentAdapter = new MyBottomNavigationBarFragmentAdapter(fm);//适配器

        initBottomNavigationBar();
        switchFragment(0);//默认显示第一项
    }


    /**
     * 初始化底部tab导航栏，监听切换。
     */
    private void initBottomNavigationBar() {
        //item角标
        TextBadgeItem badge = new TextBadgeItem()
//                .setBorderWidth(2)//Badge的Border(边界)宽度
//                .setBorderColor("#FF0000")//Badge的Border颜色
//                .setBackgroundColor("#9ACD32")//Badge背景颜色
//                .setGravity(Gravity.RIGHT| Gravity.TOP)//位置，默认右上角
                .setText("2");
//                .setTextColor("#F0F8FF")//文本颜色
//                .setAnimationDuration(2000)
//                .setHideOnSelect(true)//当选中状态时消失，非选中状态显示

        //值得一提，模式跟背景的设置都要在添加tab前面，不然不会有效果。
        bottomNavigationBar
                .setMode(BottomNavigationBar.MODE_FIXED)
                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC)
                //选中颜色（图标和文字）
                .setActiveColor("#FF279639")
                //未选中颜色
                .setInActiveColor("#aa666666")
                //导航条背景色
                .setBarBackgroundColor("#ffebedf0")
                //添加item
                //单独设置item选中setActiveColor 与 未选中setInActiveColor颜色
                .addItem(new BottomNavigationItem(R.drawable.widget_bar_news_nor, "综合").setActiveColor("#FF0000").setInActiveColor("#aa666666"))
                .addItem(new BottomNavigationItem(R.drawable.widget_bar_tweet_nor, "动弹").setBadgeItem(badge))//设置角标
                .addItem(new BottomNavigationItem(R.drawable.widget_bar_explore_nor, "发现"))
                .addItem(new BottomNavigationItem(R.drawable.widget_bar_me_nor, "我"))
                .setFirstSelectedPosition(0)//设置默认选择的按钮，仅仅是显示而已
                .initialise();//设置完成

        //tab点击事件
        bottomNavigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {
                //tab切换后时回调
                switchFragment(position);
            }

            @Override
            public void onTabUnselected(int position) {
                //对没有选中的Item进行处理的方法
            }

            @Override
            public void onTabReselected(int position) {
                //双击tab时回调
            }
        });
    }


    /**
     * 切换fragment并保存当前状态。
     */
    private void switchFragment(int position) {
        Fragment fragment = (Fragment) mFragmentAdapter.instantiateItem(fragment_content, position);
        mFragmentAdapter.setPrimaryItem(fragment_content, 0, fragment);
        mFragmentAdapter.finishUpdate(fragment_content);
    }

}


