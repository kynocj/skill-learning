package com.diana.order;

import com.diana.order.feignConfiguration.UserFeignLogConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Hello world!
 *
 */

// @EnableEurekaClient 是netflix提供的，如果用这个注解只能服务于我们的eureka
@EnableDiscoveryClient //这里是spring cloud推荐使用的，以后切换至其他注册中心比如nacos，就可以直接切换，兼容性好
@SpringBootApplication
//@EnableFeignClients(defaultConfiguration = UserFeignLogConfiguration.class) //可以使用这种方式进行全局log级别属性配置
/// 也可以在application.yml中配置default的日志级别，用于代替此种方式实现全局log级别配置
@EnableFeignClients
public class DianaOrderApplication {
    public static void main( String[] args ) {
        SpringApplication.run(DianaOrderApplication.class);
    }
}
