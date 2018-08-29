package com.myself.passbook.passbook.constant;

import lombok.Getter;

/**
 * <h1>评论类型枚举</h1>
 * @Author:UncleCatMySelf
 * @Email：zhupeijie_java@126.com
 * @QQ:1341933031
 * @Date:Created in 14:54 2018\8\22 0022
 */
@Getter
public enum FeedbackType {

    PASS(1,"针对优惠券的评论"),
    APP(2,"针对卡包 APP 的评论");

    /** 评论类型编码 */
    private Integer code;

    /** 评论类型描述 */
    private String desc;

    FeedbackType(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
