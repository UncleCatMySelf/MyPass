package com.myself.passbook.passbook.service;

import com.myself.passbook.passbook.vo.PassTemplate;

/**
 * Pass Hbase 服务
 * @Author:UncleCatMySelf
 * @Email：zhupeijie_java@126.com
 * @QQ:1341933031
 * @Date:Created in 16:26 2018\8\23 0023
 */
public interface IHBasePassService {

    /**
     * 将 PassTemplate 写入 HBase
     * @param passTemplate {@link PassTemplate}
     * @return true/false
     */
    boolean dropPassTemplateToHBase(PassTemplate passTemplate);

}
