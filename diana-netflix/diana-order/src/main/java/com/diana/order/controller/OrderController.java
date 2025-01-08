package com.diana.order.controller;

import com.diana.order.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class OrderController {
    @Autowired
    private UserService userService;

    @RequestMapping("/createOrder")
    public String createOrder(String userId) {
        String userInfo = userService.getUserInfo(userId);
        log.info("用户{}创建订单成功！",userInfo);
        return "创建订单成功 用户信息 userId:" + userInfo;
    }
}
