package com.myself.passbook.passbook.controller;

import com.myself.passbook.passbook.log.LogConstants;
import com.myself.passbook.passbook.log.LogGenerator;
import com.myself.passbook.passbook.service.IUserService;
import com.myself.passbook.passbook.vo.Response;
import com.myself.passbook.passbook.vo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * 创建用户服务
 * @Author:UncleCatMySelf
 * @Email：zhupeijie_java@126.com
 * @QQ:1341933031
 * @Date:Created in 13:39 2018\8\28 0028
 */
@Slf4j
@RestController
@RequestMapping("/passbook")
public class CreateUserController {
    /** 创建用户服务 */
    private final IUserService userService;

    /** HttpServletRequest */
    private final HttpServletRequest httpServletRequest;

    public CreateUserController(IUserService userService,
                                HttpServletRequest httpServletRequest) {
        this.userService = userService;
        this.httpServletRequest = httpServletRequest;
    }

    /**
     * 创建用户
     * @param user {@link User}
     * @return {@link Response}
     * @throws Exception
     */
    @ResponseBody
    @PostMapping("/createuser")
    Response createUser(@RequestBody User user)throws Exception{
        LogGenerator.genLog(
                httpServletRequest,
                -1L,
                LogConstants.ActionName.CREATE_USER,
                user
        );
        return userService.createUser(user);
    }
}
