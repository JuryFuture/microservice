package com.example.microservicesimpleconsumermovie.controller;

import com.example.microservicesimpleconsumermovie.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("user")
public class MovieController {
    private static final Logger logger = LoggerFactory.getLogger(MovieController.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    /*@GetMapping("/{id}")
    public User findById(@PathVariable long id) {
        return restTemplate.getForObject("http://127.0.0.1:8000/user/"+id, User.class);
    }*/

    @GetMapping("/{id}")
    public User findById(@PathVariable long id) {
        return restTemplate.getForObject("http://microservice-provider-user/user/" + id, User.class);
    }

    @GetMapping("/log-instance")
    public void logUserInstance() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("microservice-provider-user");

        logger.info("{}:{}:{}", serviceInstance.getServiceId(), serviceInstance.getHost(), serviceInstance.getPort());
    }
}
