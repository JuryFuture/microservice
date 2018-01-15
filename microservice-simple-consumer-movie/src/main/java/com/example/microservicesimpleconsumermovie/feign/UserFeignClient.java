package com.example.microservicesimpleconsumermovie.feign;

import com.example.microservicesimpleconsumermovie.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "microservice-provider-user")
public interface UserFeignClient {
    @GetMapping("/user/{id}")
    User findById(@PathVariable("id") Long id);
}
