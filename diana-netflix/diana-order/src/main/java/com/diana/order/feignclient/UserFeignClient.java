package com.diana.order.feignclient;

import com.diana.order.feignConfiguration.UserFeignLogConfiguration;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//configuration也可以不写，可以直接配置application文件进行属性配置
@FeignClient(name = "diana-user", configuration = UserFeignLogConfiguration.class)
public interface UserFeignClient {

//    @RequestLine("GET /getUserInfo")//契约使用Contract.Default()时，配对使用这个注解，
//    也可以在application.yml中进行配置
    @RequestMapping("/getUserInfo") //与@GetMapping("/getUserInfo")一样
    String getUserInfo(@RequestParam("userId") String userId);
}
