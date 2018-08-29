package com.myself.passbook.passbook.service;

import com.myself.passbook.passbook.vo.Feedback;
import com.myself.passbook.passbook.vo.Response;

/**
 * 评论功能： 即用户评论相关功能实现
 * @Author:UncleCatMySelf
 * @Email：zhupeijie_java@126.com
 * @QQ:1341933031
 * @Date:Created in 17:39 2018\8\23 0023
 */
public interface IFeedbackService {

    /**
     * 创建评论
     * @param feedback {@link Feedback}
     * @return {@link Response}
     */
    Response createFeedback(Feedback feedback);

    /**
     * 获取用户评论
     * @param userId 用户 id
     * @return {@link Response}
     */
    Response getFeedback(Long userId);
}
