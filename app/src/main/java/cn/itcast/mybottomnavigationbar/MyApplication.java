package cn.itcast.mybottomnavigationbar;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

/**
 * 自定义Application，进行全局初始化
 * Created by mengwei on 2018/4/4.
 */

public class MyApplication extends Application {

    private static Context mContext;
    private static Handler mHandler;
    private static int mMainThreadId;//主线程ID

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        mHandler = new Handler();
        mMainThreadId = android.os.Process.myTid();
    }

    public static Context getmContext() {
        return mContext;
    }

    public static Handler getmHandler() {
        return mHandler;
    }

    public static int getMainThreadId() {
        return mMainThreadId;
    }
}
