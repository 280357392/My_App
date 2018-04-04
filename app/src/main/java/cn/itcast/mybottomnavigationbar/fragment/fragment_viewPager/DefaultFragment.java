package cn.itcast.mybottomnavigationbar.fragment.fragment_viewPager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.itcast.mybottomnavigationbar.R;

/**
 * Created by mengwei on 2018/4/4.
 */

public class DefaultFragment extends Fragment {

    public static final String BUNDLE_KEY_CATALOG = "bundle_key_catalog";
    @BindView(R.id.tv_type)
    TextView mTvType;
    Unbinder unbinder;
    private int mCatalog;
    private String mKey;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            mCatalog = bundle.getInt(BUNDLE_KEY_CATALOG);
            mKey = bundle.getString("key");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_default, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
    }

    private void initView() {
        mTvType.setText(mKey);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
