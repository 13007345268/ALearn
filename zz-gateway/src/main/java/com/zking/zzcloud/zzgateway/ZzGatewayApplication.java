package com.zking.zzcloud.zzgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ZzGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZzGatewayApplication.class, args);
    }

}
