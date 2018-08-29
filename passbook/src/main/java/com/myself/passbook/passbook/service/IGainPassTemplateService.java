package com.myself.passbook.passbook.service;

import com.myself.passbook.passbook.vo.GainPassTemplateRequest;
import com.myself.passbook.passbook.vo.Response;

/**
 * 用户领取优惠券功能实现
 * @Author:UncleCatMySelf
 * @Email：zhupeijie_java@126.com
 * @QQ:1341933031
 * @Date:Created in 14:35 2018\8\27 0027
 */
public interface IGainPassTemplateService {

    /**
     * 用户领取优惠券
     * @param request {@link GainPassTemplateRequest}
     * @return {@link Response}
     * @throws Exception
     */
    Response gainPassTemplate(GainPassTemplateRequest request) throws Exception;

}
