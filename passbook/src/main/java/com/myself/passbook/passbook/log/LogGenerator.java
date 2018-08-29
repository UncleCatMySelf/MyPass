package com.myself.passbook.passbook.log;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author:UncleCatMySelf
 * @Email：zhupeijie_java@126.com
 * @QQ:1341933031
 * @Date:Created in 15:51 2018\8\22 0022
 */
@Slf4j
public class LogGenerator {

    /**
     * 生成 log
     * @param request {@link HttpServletRequest}
     * @param userId 用户 id
     * @param action 日志类型
     * @param info 日志信息 可以是null
     */
    public static void genLog(HttpServletRequest request, Long userId, String action,Object info){
        log.info(
                JSON.toJSONString(
                        new LogObject(action,userId,System.currentTimeMillis(),request.getRemoteAddr(),info)
                )
        );
    }

}
