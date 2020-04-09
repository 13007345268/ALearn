package com.zking.zzcloud.sysapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
//配置feign，因为在其它子模块定义且所在包不一样，需要手动扫描引入
@EnableFeignClients({"com.zking.zzcloud.sysfeign.feign"})
public class SysApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SysApiApplication.class, args);
    }

}
