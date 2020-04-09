package com.zking.zzcloud.sysapi.controller;

import com.zking.zzcloud.sysfeign.dto.CalDTO;
import com.zking.zzcloud.sysfeign.feign.ICalFeign;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/cal")
@RestController
@Slf4j
public class CalController {

    @Autowired
    private ICalFeign calFeign;

    @RequestMapping("/add")
    public String add(CalDTO calDTO) {
        log.info("calDTO={}", calDTO);
        String data = calFeign.add(calDTO);
        return data;
    }

    @RequestMapping("/subtract")
    public String subtract(CalDTO calDTO) {
        log.info("calDTO={}", calDTO);
        String data = calFeign.subtract(calDTO);
        return data;
    }

    @RequestMapping("/multiply")
    public String multiply(CalDTO calDTO) {
        log.info("calDTO={}", calDTO);
        String data = calFeign.multiply(calDTO);
        return data;
    }

    @RequestMapping("/divide")
    public String divide(CalDTO calDTO) {
        log.info("calDTO={}", calDTO);
        String data = calFeign.divide(calDTO);
        return data;
    }

}
