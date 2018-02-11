package com.ljt.latte.app;

import android.content.Context;

import java.util.WeakHashMap;

/**
 * Author: ljt@yonyou.com
 * Date&Time: 2018/02/11, 17:32
 * For：
 */

public final class Latte {

    public static Configutator init(Context context) {
        getConfigurations().put(ConfigType.APPLICATION_CONTEXT.name(), context.getApplicationContext());
        return Configutator.getInstance();
    }

    private static WeakHashMap<String, Object> getConfigurations() {
        return Configutator.getInstance().getLatteConfigs();
    }

}
