package com.ljt.fastec.example;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.view.Window;

import com.ljt.latte.activities.ProxyActivity;
import com.ljt.latte.delegates.LatteDelegate;
import com.ljt.latte.ec.launcher.LauncherDelegate;

public class ExampleActivity extends ProxyActivity {

    @Override
    public LatteDelegate setRootDelegate() {
        return new LauncherDelegate();
    }

}
