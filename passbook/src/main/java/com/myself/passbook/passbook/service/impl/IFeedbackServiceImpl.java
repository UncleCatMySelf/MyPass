package com.myself.passbook.passbook.service.impl;

import com.alibaba.fastjson.JSON;
import com.myself.passbook.passbook.constant.Constants;
import com.myself.passbook.passbook.mapper.FeedbackRowMapper;
import com.myself.passbook.passbook.service.IFeedbackService;
import com.myself.passbook.passbook.utils.RowKeyGenUtil;
import com.myself.passbook.passbook.vo.Feedback;
import com.myself.passbook.passbook.vo.Response;
import com.spring4all.spring.boot.starter.hbase.api.HbaseTemplate;
import lombok.extern.slf4j.Slf4j;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.filter.PrefixFilter;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 评论功能实现
 * @Author:UncleCatMySelf
 * @Email：zhupeijie_java@126.com
 * @QQ:1341933031
 * @Date:Created in 17:41 2018\8\23 0023
 */
@Slf4j
@Service
public class IFeedbackServiceImpl implements IFeedbackService {

    /** HBase 客户端 */
    private final HbaseTemplate hbaseTemplate;

    @Autowired
    public IFeedbackServiceImpl(HbaseTemplate hbaseTemplate) {
        this.hbaseTemplate = hbaseTemplate;
    }

    @Override
    public Response createFeedback(Feedback feedback) {
        if (!feedback.validate()){
            log.error("Feedback Error :{}", JSON.toJSONString(feedback));
            return Response.failure("Feedback Error");
        }
        Put put = new Put(Bytes.toBytes(RowKeyGenUtil.genFeedbackRowKey(feedback)));

        put.addColumn(
                Bytes.toBytes(Constants.FeedBack.FAMILY_I),
                Bytes.toBytes(Constants.FeedBack.USER_ID),
                Bytes.toBytes(feedback.getUserId())
        );
        put.addColumn(
                Bytes.toBytes(Constants.FeedBack.FAMILY_I),
                Bytes.toBytes(Constants.FeedBack.TYPE),
                Bytes.toBytes(feedback.getType())
        );
        put.addColumn(
                Bytes.toBytes(Constants.FeedBack.FAMILY_I),
                Bytes.toBytes(Constants.FeedBack.TEMPLATE_ID),
                Bytes.toBytes(feedback.getTemplateId())
        );
        put.addColumn(
                Bytes.toBytes(Constants.FeedBack.FAMILY_I),
                Bytes.toBytes(Constants.FeedBack.COMMENT),
                Bytes.toBytes(feedback.getComment())
        );

        hbaseTemplate.saveOrUpdate(Constants.FeedBack.TABLE_NAME,put);

        return Response.success();
    }

    @Override
    public Response getFeedback(Long userId) {

        byte[] reverseUserId = new StringBuilder(String.valueOf(userId)).reverse().toString().getBytes();
        Scan scan = new Scan();
        scan.setFilter(new PrefixFilter(reverseUserId));

        // find 多条  get 单条
        List<Feedback> feedbacks = hbaseTemplate.find(Constants.FeedBack.TABLE_NAME,scan,new FeedbackRowMapper());

        return new Response(feedbacks);
    }
}
