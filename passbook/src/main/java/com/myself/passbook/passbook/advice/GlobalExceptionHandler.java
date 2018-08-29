package com.myself.passbook.passbook.advice;

import com.myself.passbook.passbook.vo.ErrorInfo;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常处理
 * @Author:UncleCatMySelf
 * @Email：zhupeijie_java@126.com
 * @QQ:1341933031
 * @Date:Created in 16:14 2018\8\23 0023
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public ErrorInfo<String> errorHandler(HttpServletRequest request,Exception ex) throws Exception{

        ErrorInfo<String> info = new ErrorInfo<String>();

        info.setCode(ErrorInfo.ERROR);
        info.setMessage(ex.getMessage());
        info.setData("Do Not Have Return Data");
        info.setUrl(request.getRequestURI().toString());

        return info;
    }

}
