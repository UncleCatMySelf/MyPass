package com.myself.passbook.passbook.controller;

import com.myself.passbook.passbook.log.LogConstants;
import com.myself.passbook.passbook.log.LogGenerator;
import com.myself.passbook.passbook.service.IFeedbackService;
import com.myself.passbook.passbook.service.IGainPassTemplateService;
import com.myself.passbook.passbook.service.IInventoryService;
import com.myself.passbook.passbook.service.IUserPassService;
import com.myself.passbook.passbook.vo.Feedback;
import com.myself.passbook.passbook.vo.GainPassTemplateRequest;
import com.myself.passbook.passbook.vo.Pass;
import com.myself.passbook.passbook.vo.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Passbook Rest Controller
 * @Author:UncleCatMySelf
 * @Email：zhupeijie_java@126.com
 * @QQ:1341933031
 * @Date:Created in 11:39 2018\8\28 0028
 */
@Slf4j
@RestController
@RequestMapping("/passbook")
public class PassbookController {

    /** 用户优惠券服务 */
    private final IUserPassService userPassService;

    /** 优惠券库存服务 */
    private final IInventoryService inventoryService;

    /** 领取优惠券服务 */
    private final IGainPassTemplateService gainPassTemplateService;

    /** 反馈服务 */
    private final IFeedbackService feedbackService;

    /** HttpServletRequest */
    private final HttpServletRequest httpServletRequest;

    @Autowired
    public PassbookController(IUserPassService userPassService,
                              IInventoryService inventoryService,
                              IGainPassTemplateService gainPassTemplateService,
                              IFeedbackService feedbackService,
                              HttpServletRequest httpServletRequest) {
        this.userPassService = userPassService;
        this.inventoryService = inventoryService;
        this.gainPassTemplateService = gainPassTemplateService;
        this.feedbackService = feedbackService;
        this.httpServletRequest = httpServletRequest;
    }

    /**
     * 获取用户个人的优惠卷信息
     * @param userId 用户 id
     * @return {@link Response}
     * @throws Exception
     */
    @ResponseBody
    @GetMapping("/userpassinfo")
    Response userPassInfo(Long userId) throws Exception {
        LogGenerator.genLog(
                httpServletRequest,
                userId,
                LogConstants.ActionName.USER_PASS_INFO,
                null
        );
        return userPassService.getUserPassInfo(userId);
    }

    /**
     * 获取用户使用了的优惠券信息
     * @param userId 用户 id
     * @return {@link Response}
     * @throws Exception
     */
    @ResponseBody
    @GetMapping("/userusedpassinfo")
    Response userUsedPassInfo(Long userId) throws Exception{
        LogGenerator.genLog(
                httpServletRequest,
                userId,
                LogConstants.ActionName.USER_USED_PASS_INFO,
                null
        );
        return userPassService.getUserUsedPassInfo(userId);
    }

    /**
     * 用户使用优惠券
     * @param pass {@link Pass}
     * @return {@link Response}
     */
    @ResponseBody
    @PostMapping("/userusepass")
    Response userUsePass(Pass pass) throws Exception{
        LogGenerator.genLog(
                httpServletRequest,
                pass.getUserId(),
                LogConstants.ActionName.USER_USE_PASS,
                pass
        );
        return userPassService.userUsePass(pass);
    }

    /**
     * 获取库存信息
     * @param userId 用户 id
     * @return {@link Response}
     */
    @ResponseBody
    @GetMapping("/inventoryinfo")
    Response inventoryInfo(Long userId) throws Exception{
        LogGenerator.genLog(
                httpServletRequest,
                userId,
                LogConstants.ActionName.INVENTORY_INFO,
                null
        );
        return inventoryService.getInventoryInfo(userId);
    }

    /**
     * 用户领取优惠券
     * @param request {@link GainPassTemplateRequest}
     * @return {@link Response}
     * @throws Exception
     */
    @ResponseBody
    @PostMapping("/gainpasstemplate")
    Response gainPassTemplate(@RequestBody GainPassTemplateRequest request) throws Exception{
        LogGenerator.genLog(
                httpServletRequest,
                request.getUserId(),
                LogConstants.ActionName.GAIN_PASS_TEMPLATE,
                request
        );
        return gainPassTemplateService.gainPassTemplate(request);
    }

    /**
     * 用户创建评论
     * @param feedback {@link Feedback}
     * @return {@link Response}
     */
    @ResponseBody
    @PostMapping("/createfeedback")
    Response createFeedboack(@RequestBody Feedback feedback){
        LogGenerator.genLog(
                httpServletRequest,
                feedback.getUserId(),
                LogConstants.ActionName.CREATE_FEEDBACK,
                feedback
        );
        return feedbackService.createFeedback(feedback);
    }

    /**
     * 用户获取评论信息
     * @param userId 用户 id
     * @return {@link Response}
     */
    @ResponseBody
    @GetMapping("/getfeedback")
    Response getFeedback(Long userId){
        LogGenerator.genLog(
                httpServletRequest,
                userId,
                LogConstants.ActionName.GET_FEEDBACK,
                null
        );
        return feedbackService.getFeedback(userId);
    }

    /**
     * 异常演示接口
     * @return {@link Response}
     * @throws Exception
     */
    @ResponseBody
    @GetMapping("/exception")
    Response exception() throws Exception{
        throw new Exception("Welcome To PassBook!");
    }



}
