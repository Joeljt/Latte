package com.ljt.latte.ec.sign;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import com.ljt.latte.delegates.LatteDelegate;
import com.ljt.latte.ec.R;
import com.ljt.latte.ec.R2;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by ljt on 2018/3/29.
 */

public class SignInDelegate extends LatteDelegate {

    @BindView(R2.id.sign_in_phone)
    TextInputEditText tvSignInPhone;
    @BindView(R2.id.sign_in_pwd)
    TextInputEditText tvSignInPwd;

    @OnClick(R2.id.sign_in_submit)
    public void onClickSubmit(){
        if (checkForm()){
            Toast.makeText(getContext(), "pass", Toast.LENGTH_LONG).show();
        }
    }

    @OnClick(R2.id.sign_in_go_sign_up)
    public void onClickGoSignUp(){
        startWithPop(new SignUpDelegate());
    }

    private boolean checkForm(){
        final String phone = tvSignInPhone.getText().toString();
        final String pwd = tvSignInPwd.getText().toString();

        boolean isPass = true;

        if (phone.isEmpty() || !Patterns.PHONE.matcher(phone).matches()){
            tvSignInPhone.setError("请输入正确的手机号");
            isPass = false;
        }else {
            tvSignInPhone.setError(null);
        }

        if (pwd.isEmpty() || pwd.length() < 6){
            tvSignInPwd.setError("请输入至少六位密码");
            isPass = false;
        }else {
            tvSignInPwd.setError(null);
        }

        return isPass;
    }


    @Override
    public Object setLayout() {
        return R.layout.delegate_sign_in;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }
}
