package com.ljt.fastec.example;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.ljt.fastec.R;
import com.ljt.latte.delegates.LatteDelegate;

/**
 * Author: ljt@yonyou.com
 * Date&Time: 2018/02/12, 13:55
 * For：
 */

public class ExampleDelegate extends LatteDelegate {

    @Override
    public Object setLayout() {
        return R.layout.delegate_example;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }
}
