package com.ljt.fastec.example;

import android.app.Application;

import com.joanzapata.iconify.fonts.FontAwesomeModule;
import com.ljt.latte.app.Latte;
import com.ljt.latte.ec.icon.FontEcModule;

/**
 * Author: ljt@yonyou.com
 * Date&Time: 2018/02/12, 11:24
 * For：
 */

public class ExampleApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Latte.init(this)
                .withApiHost("http://127.0.0.1")
                .withIcon(new FontAwesomeModule())
                .withIcon(new FontEcModule())
                .configure();
    }
}
