package com.myself.passbook.passbook.vo;

import com.google.common.base.Enums;
import com.myself.passbook.passbook.constant.FeedbackType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户评论
 * @Author:UncleCatMySelf
 * @Email：zhupeijie_java@126.com
 * @QQ:1341933031
 * @Date:Created in 16:19 2018\8\22 0022
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Feedback {

    /** 用户 id */
    private Long userId;

    /** 评论类型 */
    private String type;

    /** PassTemplate RowKey 如果是 app 类型的评论，则没有 */
    private String templateId;

    /** 评论内容 */
    private String comment;

    public boolean validate(){
        FeedbackType feedbackType = Enums.getIfPresent(
                FeedbackType.class,this.type.toUpperCase()
        ).orNull();

        return !(null == feedbackType || null == comment);
    }

}
