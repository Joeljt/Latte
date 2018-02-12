package com.ljt.latte.ec.icon;

import com.joanzapata.iconify.Icon;

/**
 * Author: ljt@yonyou.com
 * Date&Time: 2018/02/12, 11:07
 * For：
 */

public enum EcIcons implements Icon {

    icon_alipay('\ue8e4'),
    icon_scan('\ue64b');

    private char character;

    EcIcons(char character) {
        this.character = character;
    }

    @Override
    public String key() {
        return name().replace('_', '-');
    }

    @Override
    public char character() {
        return character;
    }
}
