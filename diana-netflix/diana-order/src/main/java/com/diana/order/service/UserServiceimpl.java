package com.diana.order.service;

import com.diana.order.feignclient.UserFeignClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Slf4j
@Service
public class UserServiceimpl implements UserService{

//    @Autowired
//    private RestTemplate restTemplate;

//    @Autowired  //eureka方式获取实例
//    private LoadBalancerClient eurekaClient; //使用ribbon做负载均衡时不能使用，否则自定义规则无法生效

//    @Autowired  //手动负载均衡获取客户端实例
//    private DiscoveryClient discoveryClient;

    @Autowired
    private UserFeignClient userFeignClient;

    private String HTTP = "http://";

    @Override
    public String getUserInfo(String userId) {
//        String hostName = "localhost";
//        int port = 9001;
//        String uri = "/getUserInfo?userId=" + userId;
//        String url = HTTP + hostName + ":" + port + uri;
//        String result = restTemplate.getForObject(url,String.class);
//        return result;


//        //使用eureka获取服务信息进行服务API的访问
//        ServiceInstance instance = eurekaClient.choose("diana-user");
//        String hostName = instance.getHost();
//        int port = instance.getPort();
//        String uri = "/getUserInfo?userId=" + userId;
//        String url = HTTP + hostName + ":" + port + uri;
//        String result = restTemplate.getForObject(url,String.class);
//        return result;

        //手动负载均衡作为客户端的服务
//        List<ServiceInstance> instances = discoveryClient.getInstances("diana-user");
//        List<String> targetUrls = instances.stream()
//                .map(instance -> instance.getUri().toString() + "/getUserInfo?userId=")
//                .collect(Collectors.toList());
//
//        int i = ThreadLocalRandom.current().nextInt(targetUrls.size());
//        String targetUrl = targetUrls.get(i);
//        log.info("请求目标的地址: {}" , targetUrl);
//        String result = restTemplate.getForObject(targetUrl + userId,String.class);
//        log.info("获取用户信息成功");
//        return result;


//        //restTemplate使用LoadBalanced注解能直接使用ribbon，只要配置ribbon的各个属性的规则即可
//        String hostName = "diana-user";
//        String uri = "/getUserInfo?userId=" + userId;
//        String url = HTTP + hostName + uri;
//        String result = restTemplate.getForObject(url,String.class);
//        return result;

        //openfeign中自带ribbon依赖，如果开发的项目对ribbon的规则进行了配置，规则也会生效
        String userInfo = userFeignClient.getUserInfo(userId);
        return userInfo;

    }
}
