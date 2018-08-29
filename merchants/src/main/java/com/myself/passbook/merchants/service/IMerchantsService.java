package com.myself.passbook.merchants.service;

import com.myself.passbook.merchants.vo.CreateMerchantsRequest;
import com.myself.passbook.merchants.vo.PassTemplate;
import com.myself.passbook.merchants.vo.Response;

/**
 * 对商户服务接口定义
 * @Author:UncleCatMySelf
 * @Email：zhupeijie_java@126.com
 * @QQ:1341933031
 * @Date:Created in 14:49 2018\8\21 0021
 */
public interface IMerchantsService {

    /**
     * 创建商户服务
     * @param request {@link CreateMerchantsRequest} 创建商户请求
     * @return {@link Response}
     */
    Response createMerchants(CreateMerchantsRequest request);

    /**
     * <h2>根据 id 构造商户信息</h2>
     * @param id 商户 id
     * @return {@link Response}
     */
    Response buildMerchantsInfoById(Integer id);

    /**
     * <h2>投放优惠券</h2>
     * @param template {@link PassTemplate} 优惠券对象
     * @return {@link Response}
     */
    Response dropPassTemplate(PassTemplate template);
}
