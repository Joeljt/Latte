package com.ljt.latte.ui;

import android.content.Context;

import com.wang.avi.AVLoadingIndicatorView;
import com.wang.avi.AVLoadingIndicatorView.Indicator;

import java.util.WeakHashMap;

/**
 * Author: ljt@yonyou.com
 * Date&Time: 2018/02/12, 16:19
 * For：
 */

public abstract class LoaderCreator {

    private static final WeakHashMap<String, Indicator> LOADING_MAP = new WeakHashMap<>();

    static AVLoadingIndicatorView create(String type, Context context) {
        final AVLoadingIndicatorView avLoadingIndicatorView = new AVLoadingIndicatorView(context);
        if(LOADING_MAP.get(type) == null) {
            final AVLoadingIndicatorView.Indicator indicator = getIndicator(type);
            LOADING_MAP.put(type, indicator);
        }
//        avLoadingIndicatorView.setScrollIndicators(LOADING_MAP.get(type));
        return avLoadingIndicatorView;
    }

    private static Indicator getIndicator(String name) {
        if(name == null || name.isEmpty()) {
            return null;
        }
        final StringBuilder drawableClassName = new StringBuilder();
        if(!name.contains(".")) {
            final String defaultPackageName = AVLoadingIndicatorView.class.getPackage().getName();
            drawableClassName.append(defaultPackageName)
                    .append(".indicators")
                    .append(".");
        }
        drawableClassName.append(name);
        try {
            final Class<?> drawableClass = Class.forName(drawableClassName.toString());
            return (Indicator) drawableClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
