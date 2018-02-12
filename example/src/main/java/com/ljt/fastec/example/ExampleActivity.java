package com.ljt.fastec.example;

import com.ljt.latte.activities.ProxyActivity;
import com.ljt.latte.delegates.LatteDelegate;

public class ExampleActivity extends ProxyActivity {
    @Override
    public LatteDelegate setRootDelegate() {
        return new ExampleDelegate();
    }

}
