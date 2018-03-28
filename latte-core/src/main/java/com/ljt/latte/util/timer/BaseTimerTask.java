package com.ljt.latte.util.timer;

import java.util.TimerTask;

/**
 * Author: ljt@yonyou.com
 * Date&Time: 2018/03/28, 22:38
 * For：
 */

public class BaseTimerTask extends TimerTask {

    private ITimerListener mTimerListener;

    public BaseTimerTask(ITimerListener timerListener) {
        mTimerListener = timerListener;
    }

    @Override
    public void run() {
        if(mTimerListener != null) {
            mTimerListener.onTimer();
        }
    }
}
