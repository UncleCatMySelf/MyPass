package com.myself.passbook.passbook.log;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 日志对象
 * @Author:UncleCatMySelf
 * @Email：zhupeijie_java@126.com
 * @QQ:1341933031
 * @Date:Created in 15:48 2018\8\22 0022
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LogObject {

    /** 日志动作类型 */
    private String action;

    /** 用户 id */
    private Long userId;

    /** 当前时间戳 */
    private Long timestamp;

    /** 客户端 ip 地址 */
    private String remoteIp;

    /** 日志信息 */
    private Object info = null;

}
