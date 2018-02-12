package com.ljt.fastec.example;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.ljt.fastec.R;
import com.ljt.latte.delegates.LatteDelegate;
import com.ljt.latte.net.RestClient;
import com.ljt.latte.net.callback.IRequest;
import com.ljt.latte.net.callback.ISuccess;
import com.ljt.latte.ui.LatteLoader;

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
        testRestClient();
    }

    private void testRestClient() {
        RestClient.builder()
                .url("http://news.baidu.com")
                .request(new IRequest() {
                    @Override
                    public void onRequestStart() {
                        LatteLoader.showLoading(getContext(),"");
                    }

                    @Override
                    public void onRequestEnd() {

                    }
                })
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {
//                        Toast.makeText(getContext(), response, Toast.LENGTH_SHORT).show();
                    }
                })
                .build()
                .get();
    }

}
