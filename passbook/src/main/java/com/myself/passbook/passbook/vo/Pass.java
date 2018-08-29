package com.myself.passbook.passbook.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 用户领取的优惠券
 * @Author:UncleCatMySelf
 * @Email：zhupeijie_java@126.com
 * @QQ:1341933031
 * @Date:Created in 16:06 2018\8\22 0022
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pass {

    /** 用户 id */
    private Long userId;

    /** pass 在HBase 中的RowKey */
    private String rowKey;

    /** PassTemplate 在 HBase 中的RowKey */
    private String templateId;

    /** 优惠券 token 有可能是null，则填充-1 */
    private String token;

    /** 领取日期 */
    private Date assignedDate;

    /** 消费日期，不为空代表已经被消费了 */
    private Date conDate;

}
