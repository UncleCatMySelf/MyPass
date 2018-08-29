package com.myself.passbook.merchants.security;

import com.myself.passbook.merchants.constant.Constants;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 权限拦截器
 * @Author:UncleCatMySelf
 * @Email：zhupeijie_java@126.com
 * @QQ:1341933031
 * @Date:Created in 11:39 2018\8\21 0021
 */
@Component
public class AuthCheckInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader(Constants.TOKEN_STRING);
        if (StringUtils.isEmpty(token)){
            throw new Exception("Header 中缺少" + Constants.TOKEN_STRING + "!");
        }
        if (!token.equals(Constants.TOKEN)){
            throw new Exception("Header 中" + Constants.TOKEN_STRING + "错误");
        }
        AccessContext.setToken(token);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler,
                           @Nullable ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler,
                                @Nullable Exception ex) throws Exception {
        AccessContext.clearAccessKey();
    }
}
