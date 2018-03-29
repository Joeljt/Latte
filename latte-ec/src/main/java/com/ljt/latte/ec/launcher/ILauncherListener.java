package com.ljt.latte.ec.launcher;

import com.ljt.latte.app.SignState;

/**
 * Created by ljt on 2018/3/29.
 */

public interface ILauncherListener {

    /**
     * 启动页结束的回调
     */
    void onLaunchFinished(SignState signState);

}
