package com.ljt.latte.ec.launcher;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.ljt.latte.delegates.LatteDelegate;
import com.ljt.latte.ec.R;
import com.ljt.latte.ui.Launcher.LauncherHolderCreator;
import com.ljt.latte.util.storage.LattePreference;

import java.util.ArrayList;

/**
 * Author: ljt@yonyou.com
 * Date&Time: 2018/03/28, 23:32
 * For：
 */

public class LauncherScrollDelegate extends BaseLaunchDelegate implements OnItemClickListener {

    private ConvenientBanner<Integer> mConvenientBanner = null;
    private static final ArrayList<Integer> INTEGERS = new ArrayList<>();

    private void initBanner() {
        INTEGERS.add(R.mipmap.launcher_01);
        INTEGERS.add(R.mipmap.launcher_02);
        INTEGERS.add(R.mipmap.launcher_03);
        INTEGERS.add(R.mipmap.launcher_04);
        INTEGERS.add(R.mipmap.launcher_05);

        mConvenientBanner
                .setPages(new LauncherHolderCreator(), INTEGERS)
                .setPageIndicator(new int[]{R.drawable.dot_normal, R.drawable.dot_focus})
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL)
                .setOnItemClickListener(this)
                .setCanLoop(false);
    }

    @Override
    public Object setLayout() {
        mConvenientBanner = new ConvenientBanner<>(getContext());
        return mConvenientBanner;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        initBanner();
    }

    @Override
    public void onItemClick(int position) {
        // 标记首次进入,之后判断登录状态
        if(position == INTEGERS.size()-1) {
            LattePreference.setAppFlag(LauncherScrollTag.IF_HAS_LACHUN_APP.name(), true);
            checkSignState();
        }
    }

}
