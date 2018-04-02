package com.ljt.latte.app;

import android.content.Context;

import java.util.HashMap;

/**
 * Author: ljt@yonyou.com
 * Date&Time: 2018/02/11, 17:32
 * For：要么为了继承设计，要么就禁止继承
 */

public final class Latte {

    public static Configutator init(Context context) {
        Configutator.getInstance()
                .getLatteConfigs()
                .put(ConfigType.APPLICATION_CONTEXT.name(), context.getApplicationContext());
        return Configutator.getInstance();
    }

    public static Configutator getConfigurator() {
        return Configutator.getInstance();
    }

    public static <T> T getConfigration(Object key){
        return getConfigurator().getConfiguration(key);
    }

    public static Context getApplicationContext() {
        return (Context) getConfigurator().getConfiguration(ConfigType.APPLICATION_CONTEXT);
    }

}
