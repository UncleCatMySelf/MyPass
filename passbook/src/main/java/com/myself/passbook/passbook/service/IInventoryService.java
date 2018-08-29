package com.myself.passbook.passbook.service;

import com.myself.passbook.passbook.vo.Response;

/**
 * 获取库存信息：只返回用户没有领取的，即优惠券库存功能实现接口定义
 * @Author:UncleCatMySelf
 * @Email：zhupeijie_java@126.com
 * @QQ:1341933031
 * @Date:Created in 14:32 2018\8\27 0027
 */
public interface IInventoryService {

    /**
     * 获取库存信息
     * @param userId 用户 id
     * @return {@link Response}
     * @throws Exception
     */
    Response getInventoryInfo(Long userId) throws Exception;

}
