package com.diana.order.config;

import com.diana.order.interceptor.FeignAuthRequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    @Value("${user.tokenId}")
    private String tokenId;

    /**
     * 自定义拦截器FeignAuthRequestInterceptor，
     * 发送请求时会带上这个tokenid，对端会对tokenid进行校验，
     * 对端校验的类需要实现HandlerInterceptor类
     * @return
     */
    @Bean
    public FeignAuthRequestInterceptor feignAuthRequestInterceptor() {
        return new FeignAuthRequestInterceptor(tokenId);
    }
}
