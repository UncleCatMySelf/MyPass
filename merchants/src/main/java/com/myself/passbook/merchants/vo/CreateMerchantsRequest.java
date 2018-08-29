package com.myself.passbook.merchants.vo;

import com.myself.passbook.merchants.entity.Merchants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * 创建商户请求对象
 * @Author:UncleCatMySelf
 * @Email：zhupeijie_java@126.com
 * @QQ:1341933031
 * @Date:Created in 14:34 2018\8\21 0021
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateMerchantsRequest {

    /** 商户名称 */
    @NotNull
    private String name;

    /** 商户logo */
    @NotNull
    private String logoUrl;

    /** 商户营业执照 */
    @NotNull
    private String businessLicenseUrl;

    /** 商户联系电话 */
    @NotNull
    private String phone;

    /** 商户地址 */
    @NotNull
    private String address;

    /**
     * 将请求对象转换为商户对象
     * @return {@link Merchants}
     */
    public Merchants toMerchants(){
        Merchants merchants = new Merchants();

        merchants.setName(name);
        merchants.setLogoUrl(logoUrl);
        merchants.setBusinessLicenseUrl(businessLicenseUrl);
        merchants.setPhone(phone);
        merchants.setAddress(address);

        return merchants;
    }
}
