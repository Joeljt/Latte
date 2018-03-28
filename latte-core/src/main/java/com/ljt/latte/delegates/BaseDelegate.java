package com.ljt.latte.delegates;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ljt.latte.activities.ProxyActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation_swipeback.SwipeBackFragment;

/**
 * Author: ljt@yonyou.com
 * Date&Time: 2018/02/12, 11:39
 * For：
 */

public abstract class BaseDelegate extends SwipeBackFragment {

    private Unbinder mUnBinder = null;

    public abstract Object setLayout();

    public abstract void onBindView(@Nullable Bundle savedInstanceState, View rootView);

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = null;

        // 布局类型不限制布局文件或者view，根据传入的类型做不同的处理
        if(setLayout() instanceof Integer) {
            rootView = inflater.inflate((Integer) setLayout(), container, false);
        }else if(setLayout() instanceof View) {
            rootView = (View) setLayout();
        }

        // rootView不为空时，将传入的布局与当前fragment进行绑定
        if(rootView != null) {
            mUnBinder = ButterKnife.bind(this, rootView);
            onBindView(savedInstanceState, rootView);
        }

        return rootView;
    }

    public final ProxyActivity getProxyActivity() {
        return (ProxyActivity) _mActivity;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if(mUnBinder != null) {
            mUnBinder.unbind();
        }
    }

}
