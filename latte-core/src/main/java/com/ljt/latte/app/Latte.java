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
        getConfigurations().put(ConfigType.APPLICATION_CONTEXT.name(), context.getApplicationContext());
        return Configutator.getInstance();
    }

    private static HashMap<String, Object> getConfigurations() {
        return Configutator.getInstance().getLatteConfigs();
    }

    public static Context getApplication() {
        return (Context) getConfigurations().get(ConfigType.APPLICATION_CONTEXT.name());
    }

}
