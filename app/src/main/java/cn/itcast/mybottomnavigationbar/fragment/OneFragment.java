package cn.itcast.mybottomnavigationbar.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import cn.itcast.mybottomnavigationbar.R;
import cn.itcast.mybottomnavigationbar.utils.UIUtils;

public class OneFragment extends Fragment {

    @BindView(R.id.btn_one)
    Button mBtnOne;
    Unbinder unbinder;
    private FragmentActivity mActivity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }


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

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mActivity = getActivity();
    }

    @OnClick(R.id.btn_one)
    public void onViewClicked() {
        Toast.makeText(mActivity,"你好",Toast.LENGTH_SHORT).show();
    }
}
