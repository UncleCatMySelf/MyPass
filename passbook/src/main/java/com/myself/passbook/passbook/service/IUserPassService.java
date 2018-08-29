package com.myself.passbook.passbook.service;

import com.myself.passbook.passbook.vo.Pass;
import com.myself.passbook.passbook.vo.Response;

/**
 * 获取用户个人优惠券信息
 * @Author:UncleCatMySelf
 * @Email：zhupeijie_java@126.com
 * @QQ:1341933031
 * @Date:Created in 14:37 2018\8\27 0027
 */
public interface IUserPassService {

    /**
     * 获取用户个人优惠券信息，及我的优惠券功能实现
     * @param userId 用户 id
     * @return {@link Response}
     * @throws Exception
     */
    Response getUserPassInfo(Long userId) throws Exception;

    /**
     * 获取用户已经消费了的优惠券，即已使用优惠券功能实现
     * @param userId 用户 id
     * @return {@link Response}
     * @throws Exception
     */
    Response getUserUsedPassInfo(Long userId) throws Exception;

    /**
     * 获取用户所有的优惠券
     * @param userId 用户 id
     * @return {@link Response}
     * @throws Exception
     */
    Response getUserAllPassInfo(Long userId) throws Exception;

    /**
     * 用户使用优惠券
     * @param pass {@link Pass}
     * @return {@link Response}
     */
    Response userUsePass(Pass pass);

}
