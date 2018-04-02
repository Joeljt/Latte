package com.ljt.fastec.example.generators;


import com.example.PayEntryGenerator;
import com.ljt.latte.wechat.template.WXPayEntryTemplate;

@PayEntryGenerator(
        packageName = "com.ljt.fastec",
        payEntryTemplate = WXPayEntryTemplate.class
)
public interface WechatPayEntry {
}
