package com.ljt.fastec.example.generators;

import com.example.EntryGenerator;
import com.ljt.latte.wechat.template.WXEntryTemplate;

@EntryGenerator(
        packageName = "com.ljt.fastec",
        entryTemplate = WXEntryTemplate.class
)
public interface WechatEntry {
}
