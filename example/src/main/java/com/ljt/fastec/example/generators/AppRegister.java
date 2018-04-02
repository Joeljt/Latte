package com.ljt.fastec.example.generators;

import com.example.AppRegisterGenerator;
import com.ljt.latte.wechat.template.AppRegisterTemplate;

/**
 * Author: ljt@yonyou.com
 * Date&Time: 2018/03/30, 00:03
 * For：
 */

@AppRegisterGenerator(
        packageName = "com.ljt.fastec",
        registerTemplate = AppRegisterTemplate.class
)
public interface AppRegister {
}
