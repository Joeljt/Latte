package com.ljt.latte.ec.sign;

import android.app.Activity;

import com.ljt.latte.delegates.LatteDelegate;

/**
 * Created by ljt on 2018/3/29.
 */

public abstract class SignDelegate extends LatteDelegate {

    protected ISignListener mSignListener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        if (activity instanceof ISignListener)
            mSignListener = (ISignListener) activity;

    }
}
