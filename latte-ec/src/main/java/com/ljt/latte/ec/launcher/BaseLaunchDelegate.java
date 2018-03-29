package com.ljt.latte.ec.launcher;

import android.app.Activity;

import com.ljt.latte.app.AccountManager;
import com.ljt.latte.app.IUserChecker;
import com.ljt.latte.app.SignState;
import com.ljt.latte.delegates.LatteDelegate;

/**
 * Created by ljt on 2018/3/29.
 */

public abstract class BaseLaunchDelegate extends LatteDelegate{

    protected ILauncherListener mLauncherListener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof ILauncherListener){
            mLauncherListener = (ILauncherListener) activity;
        }
    }

    protected void checkSignState(){

        AccountManager.checkAccount(new IUserChecker() {
            @Override
            public void onSignUp() {
                // 已登录状态，直接跳转主页；只会是广告页跳转
                if (mLauncherListener != null)
                    mLauncherListener.onLaunchFinished(SignState.SIGN_IN);
            }

            @Override
            public void onNotSignUp() {
                // 广告、介绍页都可能来到这里
                if (mLauncherListener != null)
                    mLauncherListener.onLaunchFinished(SignState.NOT_SIGN_IN);
            }
        });
    }

}
