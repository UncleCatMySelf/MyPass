package com.myself.passbook.passbook.service;

import com.myself.passbook.passbook.vo.Response;
import com.myself.passbook.passbook.vo.User;

/**
 * 用户服务：创建 User 服务
 * @Author:UncleCatMySelf
 * @Email：zhupeijie_java@126.com
 * @QQ:1341933031
 * @Date:Created in 17:11 2018\8\23 0023
 */
public interface IUserService {

    /**
     * 创建用户
     * @param user {@link User}
     * @return {@link Response}
     * @throws Exception
     */
    Response createUser(User user) throws Exception;

}
