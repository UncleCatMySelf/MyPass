package com.myself.passbook.merchants.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 创建商户响应对象
 * @Author:UncleCatMySelf
 * @Email：zhupeijie_java@126.com
 * @QQ:1341933031
 * @Date:Created in 14:45 2018\8\21 0021
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateMerchantsResponse {

    /** 商户 id： 创建失败则为 -1 */
    private Integer id;

}
