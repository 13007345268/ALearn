package com.zking.zzcloud.sysfeign.feign;

import com.zking.zzcloud.sysfeign.dto.CalDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("sys-service")
public interface ICalFeign {
    @RequestMapping(value = "/cal/add", method = RequestMethod.POST)
    String add(CalDTO calDTO);

    @RequestMapping(value = "/cal/subtract", method = RequestMethod.POST)
    String subtract(CalDTO calDTO);

    @RequestMapping(value = "/cal/multiply", method = RequestMethod.POST)
    String multiply(CalDTO calDTO);

    @RequestMapping(value = "/cal/divide", method = RequestMethod.POST)
    String divide(CalDTO calDTO);
}
