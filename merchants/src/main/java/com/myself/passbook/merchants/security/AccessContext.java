package com.myself.passbook.merchants.security;

/**
 * 用 ThreadLocal 去单独存储每个线程携带的 Token 信息
 * @Author:UncleCatMySelf
 * @Email：zhupeijie_java@126.com
 * @QQ:1341933031
 * @Date:Created in 11:35 2018\8\21 0021
 */
public class AccessContext {

    private static final ThreadLocal<String> token = new ThreadLocal<String>();

    public static String getToken(){
        return token.get();
    }

    public static void setToken(String tokenStr){
        token.set(tokenStr);
    }

    public static void clearAccessKey(){
        token.remove();
    }
}
