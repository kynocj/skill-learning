package com.diana.order.ribbonConfiguration;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;

public class UserRibbonConfiguration {

    //ribbon访问规则，随机访问、轮训访问等等
    @Bean
    public IRule ribbonRule() {
        return new RoundRobinRule();
    }

//    @Bean
//    public IPing ribbonPing() {
//        return new NoOpPing();
//    }

}
