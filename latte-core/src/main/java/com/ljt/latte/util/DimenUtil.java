package com.ljt.latte.util;

import android.content.res.Resources;
import android.util.DisplayMetrics;

import com.ljt.latte.app.Latte;

/**
 * Author: ljt@yonyou.com
 * Date&Time: 2018/02/12, 16:47
 * For：
 */

public class DimenUtil {

    public static int getScreenWidth() {
        final Resources resources = Latte.getApplicationContext().getResources();
        final DisplayMetrics dm = resources.getDisplayMetrics();
        return dm.widthPixels;
    }


    public static int getScreenHeight() {
        final Resources resources = Latte.getApplicationContext().getResources();
        final DisplayMetrics dm = resources.getDisplayMetrics();
        return dm.heightPixels;
    }
}
