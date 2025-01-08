package com.diana.order.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;

public class FeignAuthRequestInterceptor implements RequestInterceptor {

    private String tokenId;

    public FeignAuthRequestInterceptor(String tokenId) {
        this.tokenId = tokenId;
    }

    @Override
    public void apply(RequestTemplate requestTemplate) {
        requestTemplate.header("Authorization", tokenId);
    }
}
