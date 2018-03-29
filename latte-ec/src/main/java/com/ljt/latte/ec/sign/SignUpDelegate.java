package com.ljt.latte.ec.sign;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.util.Patterns;
import android.view.View;

import com.alibaba.fastjson.JSONObject;
import com.ljt.latte.delegates.LatteDelegate;
import com.ljt.latte.ec.R;
import com.ljt.latte.ec.R2;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by ljt on 2018/3/29.
 */

public class SignUpDelegate extends SignDelegate {

    @BindView(R2.id.sign_up_name)
    TextInputEditText tvSignUpName;
    @BindView(R2.id.sign_up_phone)
    TextInputEditText tvSignUpPhone;
    @BindView(R2.id.sign_up_email)
    TextInputEditText tvSignUpEmail;
    @BindView(R2.id.sign_up_pwd)
    TextInputEditText tvSignUpPwd;
    @BindView(R2.id.sign_up_pwd_again)
    TextInputEditText tvSignUpPwdAgain;

    @OnClick(R2.id.sign_up_submit)
    public void onClickSubmit(){
        if (checkForm()){
            String json = "{\"data\":{\"name\":\"lijiateng\"}}";
            SignHandler.onSignUp(json, mSignListener);
        }
    }

    @OnClick(R2.id.sign_up_login)
    public void onClickGoLogin(){
        startWithPop(new SignInDelegate());
    }

    private boolean checkForm(){
        final String name = tvSignUpName.getText().toString();
        final String phone = tvSignUpPhone.getText().toString();
        final String email = tvSignUpEmail.getText().toString();
        final String pwd = tvSignUpPwd.getText().toString();
        final String pwdAgain = tvSignUpPwdAgain.getText().toString();

        boolean isPass = true;

        if (name.isEmpty()){
            tvSignUpName.setError("请输入姓名");
            isPass = false;
        }else {
            tvSignUpName.setError(null);
        }

        if (phone.isEmpty() || !Patterns.PHONE.matcher(phone).matches()){
            tvSignUpPhone.setError("请输入正确的手机号");
            isPass = false;
        }else {
            tvSignUpPhone.setError(null);
        }

        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            tvSignUpEmail.setError("请输入正确的邮箱格式");
            isPass = false;
        }else {
            tvSignUpEmail.setError(null);
        }

        if (pwd.isEmpty() || pwd.length() < 6){
            tvSignUpName.setError("请输入至少六位密码");
            isPass = false;
        }else {
            tvSignUpName.setError(null);
        }

        if (!pwdAgain.equals(pwd)){
            tvSignUpName.setError("两次密码输入不一致，请检查");
            isPass = false;
        }else {
            tvSignUpName.setError(null);
        }

        return isPass;
    }


    @Override
    public Object setLayout() {
        return R.layout.delegate_sign_up;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }
}
