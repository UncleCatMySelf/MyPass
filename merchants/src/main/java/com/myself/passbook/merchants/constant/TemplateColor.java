package com.myself.passbook.merchants.constant;

import lombok.Getter;

/**
 * 优惠券背景颜色
 * @Author:UncleCatMySelf
 * @Email：zhupeijie_java@126.com
 * @QQ:1341933031
 * @Date:Created in 11:22 2018\8\21 0021
 */
@Getter
public enum TemplateColor {
    RED(1,"红色"),
    GREEN(2,"绿色"),
    BLUE(3,"蓝色");

    /** 颜色代码 */
    private Integer code;

    /** 颜色描述 */
    private String color;

    TemplateColor(Integer code, String color) {
        this.code = code;
        this.color = color;
    }
}
