package com.myself.passbook.merchants.controller;

import com.alibaba.fastjson.JSON;
import com.myself.passbook.merchants.constant.ErrorCode;
import com.myself.passbook.merchants.service.IMerchantsService;
import com.myself.passbook.merchants.vo.CreateMerchantsRequest;
import com.myself.passbook.merchants.vo.PassTemplate;
import com.myself.passbook.merchants.vo.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

/**
 * <h1>商户服务Controller</h1>
 * @Author:UncleCatMySelf
 * @Email：zhupeijie_java@126.com
 * @QQ:1341933031
 * @Date:Created in 11:00 2018\8\22 0022
 */
@Slf4j
@RestController
@RequestMapping("/merchants")
public class MerchantsController {

    private final IMerchantsService merchantsService;

    @Autowired
    public MerchantsController(IMerchantsService merchantsService) {
        this.merchantsService = merchantsService;
    }

    @ResponseBody
    @PostMapping("/create")
    public Response createMerchants(@RequestBody CreateMerchantsRequest request, BindingResult bindingResult){
        Response response = new Response();
        log.info("CreateMerchants: {}", JSON.toJSONString(request));
        if (bindingResult.hasErrors()){
            response.setErrorCode(ErrorCode.DUPLICATE_NAME.getCode());
            response.setErrorMsg(bindingResult.getFieldError().getField());
            return response;
        }
        return merchantsService.createMerchants(request);
    }

    @ResponseBody
    @GetMapping("/{id}")
    public Response buildMerchantsInfo(@PathVariable Integer id){
        log.info("BuildMerchantsInfo: {}",id);
        return merchantsService.buildMerchantsInfoById(id);
    }

    @ResponseBody
    @PostMapping("/drop")
    public Response dropPassTemplate(@RequestBody PassTemplate passTemplate, BindingResult bindingResult){
        log.info("DropPassTemplate: {}",passTemplate);
        Response response = new Response();
        if (bindingResult.hasErrors()){
            response.setErrorCode(ErrorCode.DUPLICATE_NAME.getCode());
            response.setErrorMsg(bindingResult.getFieldError().getField());
            return response;
        }
        return merchantsService.dropPassTemplate(passTemplate);
    }
}
