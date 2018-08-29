package com.myself.passbook.merchants.constant;

import lombok.Getter;

/**
 * 错误码枚举定义
 * @Author:UncleCatMySelf
 * @Email：zhupeijie_java@126.com
 * @QQ:1341933031
 * @Date:Created in 11:26 2018\8\21 0021
 */
@Getter
public enum ErrorCode {
    SUCCESS(0,""),
    DUPLICATE_NAME(1,"商户名称重复"),
    EMPTY_LOGO(2,"商户 logo 为空"),
    EMPTY_BUSINESS_LICENSE(3,"商户营业执照为空"),
    ERROR_PHONE(4,"商户联系电话错误"),
    EMPTY_ADDRESS(5,"商户地址为空"),
    MERCHANTS_NOT_EXIST(6,"商户不存在");

    /** 错误码 */
    private Integer code;

    /** 错误描述 */
    private String msg;

    ErrorCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
