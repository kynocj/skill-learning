package com.diana.order.feignConfiguration;

import feign.Contract;
import feign.Logger;
import feign.Request;
import feign.codec.Decoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



//假如使用@Configuration注解，那么代表全局所有服务的访问都是用这个配置，不会区分是哪个服务的feign的log级别
//@Configuration
//也可以不在这里使用@Configuration注解，在Application启动点的@EnableFeignClients注解中
// 引入defaultConfiguration=UserFeignLogConfiguration.class也可实现全局配置
public class UserFeignLogConfiguration {


    @Bean
    public Logger.Level level() {
        return Logger.Level.FULL;
    }

    //契约，此种方式约定访问对端服务的restful形式，
    // Contract.Default()表示UserFeignClient使用类似@RequestLine("GET /getUserInfo")的形式的注解调用，
    // 也可以在application.yml中进行配置
//    @Bean
//    public Contract feignContract() {
//        return new Contract.Default();
//    }

    //编解码的配置，默认就是SpringDecoder，如果需要做特殊解码，则需要另外自定义CustomDecode，
    // 也可以使用application.yml进行配置
//    @Bean
//    public Decoder decoder(ObjectFactory<HttpMessageConverters> messageConverters) {
//        return new SpringDecoder(messageConverters);
//    }

    /**
     * 设置连接的超时时间，默认是连接超时10s，读超时60s
     * 这里设置的分别是2s和5秒
     * @return
     */
    @Bean
    public Request.Options options() {
        return  new Request.Options(2000,5000);
    }
}
