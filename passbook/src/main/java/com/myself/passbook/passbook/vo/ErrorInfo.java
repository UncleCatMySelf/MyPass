package com.myself.passbook.passbook.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 统一的错误信息
 * @Author:UncleCatMySelf
 * @Email：zhupeijie_java@126.com
 * @QQ:1341933031
 * @Date:Created in 16:09 2018\8\23 0023
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorInfo<T> {

    /** 错误码 */
    public static final Integer ERROR = -1;

    /** 特定错误码 */
    private Integer code;

    /** 错误信息 */
    private String message;

    /** 请求 url */
    private String url;

    /** 请求返回的数据 */
    private T data;

}
