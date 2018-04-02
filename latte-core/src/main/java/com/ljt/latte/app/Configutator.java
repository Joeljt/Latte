package com.ljt.latte.app;

import android.app.Activity;

import com.joanzapata.iconify.IconFontDescriptor;
import com.joanzapata.iconify.Iconify;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Author: ljt@yonyou.com
 * Date&Time: 2018/02/11, 17:34
 * For：全局配置类
 * 1、ConfigType.CONFIG_READY.name() 输出枚举类的key值
 * 2、静态内部类实现单例，在被调用时才会加载，保证了线程安全
 * 3、在声明变量、方法等时，如果之后不再使用或者更改，尽量使其不可变性最大化，善用final关键字
 */

public class Configutator {

    private static final HashMap<Object, Object> LATTE_CONFIGS = new HashMap<>();
    private static ArrayList<IconFontDescriptor> ICONS = new ArrayList<>();

    private Configutator() {
        // 标记配置开始，但是还未完成
        LATTE_CONFIGS.put(ConfigType.CONFIG_READY.name(), false);
    }

    public final Configutator withApiHost(String host) {
        LATTE_CONFIGS.put(ConfigType.API_HOST.name(), host);
        return this;
    }

    private void initIcons() {
        if(ICONS.size() > 0) {
            final Iconify.IconifyInitializer initializer = Iconify.with(ICONS.get(0));
            for (int i = 1; i < ICONS.size(); i++) {
                initializer.with(ICONS.get(i));
            }
        }
    }

    public final Configutator withIcon(IconFontDescriptor descriptor) {
        ICONS.add(descriptor);
        return this;
    }

    public final Configutator withAppId(String appId) {
        LATTE_CONFIGS.put(ConfigType.WE_CHAT_APP_ID, appId);
        return this;
    }

    public final Configutator withWeChatAppSerect(String appSerect) {
        LATTE_CONFIGS.put(ConfigType.WE_CHAT_APP_SECRET, appSerect);
        return this;
    }

    public final Configutator withActivity(Activity activity) {
        LATTE_CONFIGS.put(ConfigType.ACTIVITY, activity);
        return this;
    }
    /*************************************** 配置相关 ***********************************************/
    final <T> T getConfiguration(Object key) {
        checkConfiguration();
        final Object value = LATTE_CONFIGS.get(key);
        if (value == null)
            throw new NullPointerException(key.toString() + " is null");
        return (T) value;
    }

    private void checkConfiguration() {
        final boolean isReady = (boolean) LATTE_CONFIGS.get(ConfigType.CONFIG_READY.name());
        if(!isReady) {
            throw new RuntimeException("Configuration is not ready, check if you called configure()! ");
        }
    }

    final HashMap<Object, Object> getLatteConfigs() {
        return LATTE_CONFIGS;
    }

    public final void configure() {
        initIcons();
        LATTE_CONFIGS.put(ConfigType.CONFIG_READY.name(), true);
    }


    /****************************************** 单例 ************************************************/
    private static class Holder {
        private static final Configutator INSTANCE = new Configutator();
    }

    public static Configutator getInstance() {
        return Holder.INSTANCE;
    }

}
