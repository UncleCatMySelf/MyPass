package com.myself.passbook.passbook.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 库存请求响应
 * @Author:UncleCatMySelf
 * @Email：zhupeijie_java@126.com
 * @QQ:1341933031
 * @Date:Created in 14:24 2018\8\27 0027
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventoryResponse {

    /** 用户 id */
    private Long userId;

    /** 优惠券模板信息 */
    private List<PassTemplateInfo> passTemplateInfos;



}
