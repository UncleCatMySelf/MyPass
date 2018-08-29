package com.myself.passbook.merchants.dao;

import com.myself.passbook.merchants.entity.Merchants;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Merchants Dao 接口
 * @Author:UncleCatMySelf
 * @Email：zhupeijie_java@126.com
 * @QQ:1341933031
 * @Date:Created in 11:56 2018\8\21 0021
 */
public interface MerchantsDao extends JpaRepository<Merchants,Integer> {

    /**
     * 根据商户名称获取商户对象
     * @param name 商户名称
     * @return {@link Merchants}
     */
    Merchants findByName(String name);

}
