package com.ljt.fastec.example;
import android.widget.Toast;

import com.ljt.latte.activities.ProxyActivity;
import com.ljt.latte.app.SignState;
import com.ljt.latte.delegates.LatteDelegate;
import com.ljt.latte.ec.launcher.ILauncherListener;
import com.ljt.latte.ec.launcher.LauncherDelegate;
import com.ljt.latte.ec.sign.ISignListener;
import com.ljt.latte.ec.sign.SignInDelegate;

public class ExampleActivity extends ProxyActivity implements ILauncherListener,ISignListener{

    @Override
    public LatteDelegate setRootDelegate() {
        return new LauncherDelegate();
    }

    @Override
    public void onLaunchFinished(SignState signState) {
        switch (signState){
            case SIGN_IN:
                startWithPop(new ExampleDelegate());
                break;
            case NOT_SIGN_IN:
                startWithPop(new SignInDelegate());
                break;
        }
    }

    @Override
    public void onSignUpSuccess() {
        pop(); // 注册成功后出栈栈顶fragment，即注册页面
        Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSignInSuccess() {
        startWithPop(new ExampleDelegate()); // 登录成功后跳转主页面
        Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
    }


}
