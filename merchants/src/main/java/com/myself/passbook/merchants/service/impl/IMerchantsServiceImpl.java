package com.myself.passbook.merchants.service.impl;

import com.alibaba.fastjson.JSON;
import com.myself.passbook.merchants.constant.Constants;
import com.myself.passbook.merchants.constant.ErrorCode;
import com.myself.passbook.merchants.dao.MerchantsDao;
import com.myself.passbook.merchants.entity.Merchants;
import com.myself.passbook.merchants.service.IMerchantsService;
import com.myself.passbook.merchants.vo.CreateMerchantsRequest;
import com.myself.passbook.merchants.vo.CreateMerchantsResponse;
import com.myself.passbook.merchants.vo.PassTemplate;
import com.myself.passbook.merchants.vo.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @Author:UncleCatMySelf
 * @Email：zhupeijie_java@126.com
 * @QQ:1341933031
 * @Date:Created in 10:06 2018\8\22 0022
 */
@Slf4j
@Service
public class IMerchantsServiceImpl implements IMerchantsService {

    /** Merchants 数据库接口 */
    private final MerchantsDao merchantsDao;

    /** kafka 客户端 */
    private final KafkaTemplate<String,String> kafkaTemplate;

    @Autowired
    public IMerchantsServiceImpl(MerchantsDao merchantsDao,
                                 KafkaTemplate<String,String> kafkaTemplate) {
        this.merchantsDao = merchantsDao;
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    @Transactional
    public Response createMerchants(CreateMerchantsRequest request) {
        Response response = new Response();
        CreateMerchantsResponse merchantsResponse = new CreateMerchantsResponse();
        merchantsResponse.setId(merchantsDao.save(request.toMerchants()).getId());
        response.setData(merchantsResponse);
        return response;
    }

    @Override
    public Response buildMerchantsInfoById(Integer id) {
        Response response = new Response();
        try {
            Merchants merchants = merchantsDao.findById(id).get();
            response.setData(merchants);
        }catch (Exception e){
            response.setErrorCode(ErrorCode.MERCHANTS_NOT_EXIST.getCode());
            response.setErrorMsg(ErrorCode.MERCHANTS_NOT_EXIST.getMsg());
        }
        return response;
    }

    @Override
    public Response dropPassTemplate(PassTemplate template) {

        Response response = new Response();

        String passTemplate = JSON.toJSONString(template);
        kafkaTemplate.send(
                Constants.TEMPLATE_TOPIC,
                Constants.TEMPLATE_TOPIC,
                passTemplate
        );
        log.info("DropPassTemplate: {}",passTemplate);


        return response;
    }
}
