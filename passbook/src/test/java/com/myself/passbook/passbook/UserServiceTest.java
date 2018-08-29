package com.myself.passbook.passbook;

import com.alibaba.fastjson.JSON;
import com.myself.passbook.passbook.service.IUserService;
import com.myself.passbook.passbook.vo.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author:UncleCatMySelf
 * @Email：zhupeijie_java@126.com
 * @QQ:1341933031
 * @Date:Created in 14:02 2018\8\28 0028
 */
public class UserServiceTest extends PassbookApplicationTests {

    @Autowired
    private IUserService userService;

    @Test
    public void testCreateUser() throws Exception{
        User user = new User();
        user.setBaseInfo(
                new User.BaseInfo("myself",10,"m")
        );
        user.setOtherInfo(
                new User.OtherInfo("1111","where")
        );
        System.out.println(JSON.toJSONString(userService.createUser(user)));
    }

}
