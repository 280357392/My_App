package cn.itcast.mybottomnavigationbar.utils;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.View;

import cn.itcast.mybottomnavigationbar.MyApplication;

/**
 * Created by mengwei on 2018/4/4.
 */

public class UIUtils {


    /**
     * 获取Context
     *
     * @return
     */
    public static Context getContext() {
        return MyApplication.getmContext();
    }

    /**
     * 获取Handler
     *
     * @return
     */
    public static Handler getHandler() {
        return MyApplication.getmHandler();
    }

    /**
     * 获取主线程id
     *
     * @return
     */
    public static int getMainThreadId() {
        return MyApplication.getMainThreadId();
    }


    //********************************加载资源文件********************************


    /**
     * 根据strings.xml文件中的ID获得字符串
     *
     * @param id
     * @return
     */
    public static String getString(int id) {
        return getContext().getResources().getString(id);
    }

    /**
     * 根据strings.xml文件中的ID获得字符串数组
     *
     * @param id
     * @return
     */
    public static String[] getStringArray(int id) {
        return getContext().getResources().getStringArray(id);
    }


    /**
     * 根据Drawable.xml文件中的ID获得图片
     *
     * @param id
     * @return
     */
    public static Drawable getDrawable(int id) {
        return getContext().getResources().getDrawable(id);
    }

    /**
     * 根据colors.xml文件中的ID获得颜色
     *
     * @param id
     * @return
     */
    public static int getColor(int id) {
        return getContext().getResources().getColor(id);
    }


    /**
     * 根据id获取颜色状态选择器
     *
     * @param id
     * @return
     */
    public static ColorStateList getColorStateList(int id) {
        return getContext().getResources().getColorStateList(id);
    }

    /**
     * 根据dimens.xml文件中的ID获得dp转成px值
     *
     * @param id
     * @return 返回的是px（dp转成了px）
     */
    public static int getDimen(int id) {
        return getContext().getResources().getDimensionPixelSize(id);
    }

    //********************************dp转成px********************************

    /**
     * dp转成px
     *
     * @param dip
     * @return
     */
    public static int dip2px(float dip) {
        float density = getContext().getResources().getDisplayMetrics().density;
        return (int) (dip * density + 0.5f);
    }

    /**
     * px转成dp
     *
     * @param px
     * @return
     */
    public static float px2dip(int px) {
        float density = getContext().getResources().getDisplayMetrics().density;
        return px / density;
    }

    //********************************加载布局文件********************************

    /**
     * 加载布局文件
     *
     * @param id
     * @return
     */
    public static View inflate(int id) {
        return View.inflate(getContext(), id, null);
    }

    //********************************判断是否允许在主线程********************************

    /**
     * 是否是主线程
     *
     * @return
     */
    public static boolean isRunOnUIThread() {
        //获取当前线程ID，如果当前线程id与主线程id相同，那么当前就是主线程。
        int myTid = android.os.Process.myTid();
        return getMainThreadId() == myTid;
    }


    /**
     * 运行在主线程的方法
     *
     * @param runnable
     */
    public static void runOnUIThread(Runnable runnable) {
        if (isRunOnUIThread()) {
            //已经是主线程，直接运行
            runnable.run();
        } else {
            //如果是子线程，借助handler让其运行在主线程
            getHandler().post(runnable);
        }
    }
}
