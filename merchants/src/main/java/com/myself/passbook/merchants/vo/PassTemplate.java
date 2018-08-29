package com.myself.passbook.merchants.vo;

import com.myself.passbook.merchants.constant.ErrorCode;
import com.myself.passbook.merchants.dao.MerchantsDao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 投放的优惠券对象定义
 * @Author:UncleCatMySelf
 * @Email：zhupeijie_java@126.com
 * @QQ:1341933031
 * @Date:Created in 14:09 2018\8\21 0021
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PassTemplate {

    /** 所属商户 Id */
    @NotNull
    private Integer id;

    /** 优惠券标题 */
    private String title;

    /** 优惠券摘要 */
    private String summary;

    /** 优惠券的详细信息 */
    private String desc;

    /** 最大个数限制 */
    private Long limit;

    /** 优惠券是否有 Token，用于商户核销 */
    private Boolean hasToken;// token 存储于Redis Set中，每次领取从 Redis 中获取

    /** 优惠券背景色 */
    private Integer background;

    /** 优惠券开始时间 */
    private Date start;

    /** 优惠券结束时间 */
    private Date end;

    /**
     * 校验优惠券对象的有效性_@NotNull
     * @param merchantsDao {@link MerchantsDao}
     * @return {@link ErrorCode}
     */
//    public ErrorCode validate(MerchantsDao merchantsDao){
//        if (null == merchantsDao.findById(id).get()){
//            return ErrorCode.MERCHANTS_NOT_EXIST;
//        }
//    }
}
