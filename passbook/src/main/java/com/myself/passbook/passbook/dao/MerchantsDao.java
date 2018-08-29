package com.myself.passbook.passbook.dao;

import com.myself.passbook.passbook.entity.Merchants;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * <h1>Merchants Dao 接口</h1>
 * @Author:UncleCatMySelf
 * @Email：zhupeijie_java@126.com
 * @QQ:1341933031
 * @Date:Created in 15:34 2018\8\22 0022
 */
public interface MerchantsDao extends JpaRepository<Merchants,Integer> {

    /**
     * <h2>根据商户名称获取商户对象</h2>
     * @param name 商户名称
     * @return {@link Merchants}
     */
    Merchants findByName(String name);

    /**
     * <h2>根据商户 ids 获取商户对象</h2>
     * @param ids 商户ids
     * @return {@link Merchants}
     */
    List<Merchants> findByIdIn(List<Integer> ids);
}
