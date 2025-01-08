package com.diana.order.config;

import com.diana.order.ribbonConfiguration.UserRibbonConfiguration;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.Configuration;

@Configuration
//用于自定义ribbon规则的配置，比如IRule
//@RibbonClient(name = "diana-user",configuration = UserRibbonConfiguration.class) //单个配置可以这么用
@RibbonClients(
        @RibbonClient(name = "diana-user",configuration = UserRibbonConfiguration.class)  //如果是多个，可以使用逗号隔开
)
public class RibbonConfig {
}
