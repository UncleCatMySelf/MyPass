package com.myself.passbook.merchants.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 商户对象模型
 * @Author:UncleCatMySelf
 * @Email：zhupeijie_java@126.com
 * @QQ:1341933031
 * @Date:Created in 11:47 2018\8\21 0021
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "merchants")
public class Merchants implements Serializable {

    private static final long serialVersionUID = 6447730857299580370L;

    /** 商户id，主键 */
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Integer id;

    /** 商户名称，需要全局唯一 */
    @Basic
    @Column(name = "name",unique = true,nullable = false)
    private String name;

    /** 商户 logo */
    @Basic
    @Column(name = "logo_url",nullable = false)
    private String logoUrl;

    /** 商户营业执照 */
    @Basic
    @Column(name = "business_license_url",nullable = false)
    private String businessLicenseUrl;

    /** 商户的联系电话 */
    @Basic
    @Column(name = "phone",nullable = false)
    private String phone;

    /** 商户地址 */
    @Basic
    @Column(name = "address", nullable = false)
    private String address;

    /** 商户是否通过审核 */
    @Basic
    @Column(name = "is_audit",nullable = false)
    private Boolean isAudit = false;
}
