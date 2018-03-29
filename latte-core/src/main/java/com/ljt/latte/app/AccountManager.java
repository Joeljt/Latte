package com.ljt.latte.app;

import com.ljt.latte.util.storage.LattePreference;

/**
 * Created by ljt on 2018/3/29.
 */

public class AccountManager {

    public static void setSignTag(boolean isSignIn){
        LattePreference.setAppFlag(SignState.SIGN_TAG.name(), isSignIn);
    }

    public static boolean isSignIn(){
        return LattePreference.getAppFlag(SignState.SIGN_TAG.name());
    }

    public static void checkAccount(IUserChecker checker){
        if (isSignIn()){
            checker.onSignUp();
        }else{
            checker.onNotSignUp();
        }
    }

}
