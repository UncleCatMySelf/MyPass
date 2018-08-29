package com.myself.passbook.passbook.constant;

import lombok.Getter;

/**
 * <h1>优惠券的状态</h1>
 * @Author:UncleCatMySelf
 * @Email：zhupeijie_java@126.com
 * @QQ:1341933031
 * @Date:Created in 14:50 2018\8\22 0022
 */
@Getter
public enum  PassStatus {
    UNUSED(1,"未被使用的"),
    USED(2,""),
    ALL(3,"");

    /** 状态码 */
    private Integer code;

    /** 状态描述 */
    private String desc;

    PassStatus(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }



}
