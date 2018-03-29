package com.ljt.latte.ec.sign;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ljt.latte.app.AccountManager;
import com.ljt.latte.ec.database.DatabaseManager;
import com.ljt.latte.ec.database.UserProfile;


/**
 * Created by ljt on 2018/3/29.
 */

public class SignHandler {

    public static void onSignIn(String response, ISignListener signListener){
        final JSONObject profileJson = JSON.parseObject(response).getJSONObject("data");
        final String name = profileJson.getString("name");

        UserProfile userProfile = new UserProfile(123, name, "", "", "");
        DatabaseManager.getInstance().getUserProfile().insert(userProfile);

        // 标记登录状态，注册成功直接登录
        AccountManager.setSignTag(true);
        // 响应回调
        if (signListener != null)
            signListener.onSignInSuccess();

    }

    public static void onSignUp(String response, ISignListener signListener){
        final JSONObject profileJson = JSON.parseObject(response).getJSONObject("data");
        final String name = profileJson.getString("name");

        UserProfile userProfile = new UserProfile(123, name, "", "", "");
        DatabaseManager.getInstance().getUserProfile().insert(userProfile);

        // 标记登录状态，注册成功直接登录
        AccountManager.setSignTag(true);
        // 响应回调
        if (signListener != null)
            signListener.onSignUpSuccess();

    }

}
