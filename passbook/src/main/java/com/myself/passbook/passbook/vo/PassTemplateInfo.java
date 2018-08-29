package com.myself.passbook.passbook.vo;

import com.myself.passbook.passbook.entity.Merchants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 优惠券模板信息
 * @Author:UncleCatMySelf
 * @Email：zhupeijie_java@126.com
 * @QQ:1341933031
 * @Date:Created in 14:20 2018\8\27 0027
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PassTemplateInfo extends PassTemplate {

    /** 优惠券模板 */
    private PassTemplate passTemplate;

    /** 优惠券对应的商户 */
    private Merchants merchants;



}
