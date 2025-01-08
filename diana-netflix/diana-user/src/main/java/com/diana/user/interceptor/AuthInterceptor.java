package com.diana.user.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 在继承了WebMvcConfigurationSupport类的addinterceptor方法里面添加这个拦截器
@Slf4j
public class AuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String tokenId = request.getHeader("Authorization");
        log.info("获取的额认证信息 Authorization:{}", tokenId);

        if(!StringUtils.isEmpty(tokenId)) {
            return true;
        }

//        return HandlerInterceptor.super.preHandle(request, response, handler);
        return false;
    }
}
