package com.myself.passbook.merchants.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author:UncleCatMySelf
 * @Email：zhupeijie_java@126.com
 * @QQ:1341933031
 * @Date:Created in 14:28 2018\8\21 0021
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response {

    /** 错误码，正确返回 0 */
    private Integer errorCode = 0;

    /** 错误信息，正确返回空字符串 */
    private String errorMsg = "";

    /** 返回值对象 */
    private Object data;

    /**
     * 正确的响应构造函数
     * @param data 返回值对象
     */
    public Response(Object data) {
        this.data = data;
    }

}
