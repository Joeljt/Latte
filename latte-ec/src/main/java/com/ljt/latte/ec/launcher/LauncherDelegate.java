package com.ljt.latte.ec.launcher;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;

import com.ljt.latte.delegates.LatteDelegate;
import com.ljt.latte.ec.R;
import com.ljt.latte.ec.R2;
import com.ljt.latte.util.storage.LattePreference;
import com.ljt.latte.util.timer.BaseTimerTask;
import com.ljt.latte.util.timer.ITimerListener;

import java.util.Timer;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * Author: ljt@yonyou.com
 * Date&Time: 2018/03/28, 22:37
 * For：
 */

public class LauncherDelegate extends LatteDelegate implements ITimerListener{

    private int count = 5;

    private Timer mTimer = null;

    @BindView(R2.id.tv_launcher_timer)
    AppCompatTextView tvLauncherTimer;

    @OnClick(R2.id.tv_launcher_timer)
    void onClick() {
        if(count < 0 && mTimer != null) {
            mTimer.cancel();
            mTimer = null;
            checkIfShowScroll();
        }
    }

    @Override
    public Object setLayout() {
        return R.layout.delegate_launcher;
    }

    private void initTimer() {
        mTimer = new Timer();
        final BaseTimerTask mTask = new BaseTimerTask(this);
        mTimer.schedule(mTask, 0, 1000);
    }

    private void checkIfShowScroll() {
        if (!LattePreference.getAppFlag(LauncherScrollTag.IF_HAS_LACHUN_APP.name())) {
            startWithPop(new LauncherScrollDelegate());
            LattePreference.setAppFlag(LauncherScrollTag.IF_HAS_LACHUN_APP.name(), true);
        } else {
            // 检查是否登录了app
        }
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        initTimer();
    }

    @Override
    public void onTimer() {
        getProxyActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if(tvLauncherTimer != null) {
                    tvLauncherTimer.setText("跳过\n" + count-- + "s");
                    if(count < 0 && mTimer != null) {
                        mTimer.cancel();
                        mTimer = null;
                        checkIfShowScroll();
                    }
                }
            }
        });
    }
}
