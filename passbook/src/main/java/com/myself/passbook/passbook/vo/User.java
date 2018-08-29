package com.myself.passbook.passbook.vo;

import com.sun.xml.internal.rngom.parse.host.Base;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * User Object
 * @Author:UncleCatMySelf
 * @Email：zhupeijie_java@126.com
 * @QQ:1341933031
 * @Date:Created in 15:56 2018\8\22 0022
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    /** 用户 id */
    private Long id;

    /** 用户基本信息 */
    private BaseInfo baseInfo;

    /** 用户额外信息 */
    private OtherInfo otherInfo;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class BaseInfo {

        private String name;
        private Integer age;
        private String sex;

    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class OtherInfo{
        private String phone;
        private String address;
    }

}
