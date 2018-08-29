package com.myself.passbook.passbook.mapper;

import com.myself.passbook.passbook.constant.Constants;
import com.myself.passbook.passbook.vo.Feedback;
import com.spring4all.spring.boot.starter.hbase.api.RowMapper;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.util.Bytes;

/**
 * Feedback HBase Row To Object
 * @Author:UncleCatMySelf
 * @Email：zhupeijie_java@126.com
 * @QQ:1341933031
 * @Date:Created in 15:46 2018\8\23 0023
 */
public class FeedbackRowMapper implements RowMapper<Feedback> {

    private static byte[] FAMIL_I = Constants.FeedBack.FAMILY_I.getBytes();
    private static byte[] USER_ID = Constants.FeedBack.USER_ID.getBytes();
    private static byte[] TYPE = Constants.FeedBack.TYPE.getBytes();
    private static byte[] TEMPLATE_ID = Constants.FeedBack.TEMPLATE_ID.getBytes();
    private static byte[] COMMENT = Constants.FeedBack.COMMENT.getBytes();

    @Override
    public Feedback mapRow(Result result, int i) throws Exception {

        Feedback feedback = new Feedback();
        feedback.setUserId(Bytes.toLong(result.getValue(FAMIL_I,USER_ID)));
        feedback.setType(Bytes.toString(result.getValue(FAMIL_I,TYPE)));
        feedback.setTemplateId(Bytes.toString(result.getValue(FAMIL_I,TEMPLATE_ID)));
        feedback.setComment(Bytes.toString(result.getValue(FAMIL_I,COMMENT)));

        return feedback;
    }
}
