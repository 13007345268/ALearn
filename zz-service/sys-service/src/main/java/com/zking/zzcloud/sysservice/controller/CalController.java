package com.zking.zzcloud.sysservice.controller;

import com.zking.zzcloud.common.util.RestResponse;
import com.zking.zzcloud.sysfeign.dto.CalDTO;
import com.zking.zzcloud.sysservice.model.Cal;
import com.zking.zzcloud.sysservice.service.ICalService;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/cal")
@RestController
@Slf4j
public class CalController {

    @Autowired
    private MapperFactory mapperFactory;

    @Autowired
    private ICalService calService;

    @RequestMapping("/add")
    public RestResponse add(@RequestBody CalDTO calDTO) {
        log.info("calDTO={}", calDTO);

        MapperFacade mapper = mapperFactory.getMapperFacade();
        Cal cal = mapper.map(calDTO, Cal.class);

        Double d = calService.add(cal);

        return RestResponse.succuess(d);
    }

    @RequestMapping("/subtract")
    public RestResponse subtract(@RequestBody CalDTO calDTO) {
        MapperFacade mapper = mapperFactory.getMapperFacade();
        Cal cal = mapper.map(calDTO, Cal.class);

        Double d = calService.subtract(cal);

        return RestResponse.succuess(d);
    }

    @RequestMapping("/multiply")
    public RestResponse multiply(@RequestBody CalDTO calDTO) {
        MapperFacade mapper = mapperFactory.getMapperFacade();
        Cal cal = mapper.map(calDTO, Cal.class);

        Double d = calService.multiply(cal);

        return RestResponse.succuess(d);
    }

    @RequestMapping("/divide")
    public RestResponse divide(@RequestBody CalDTO calDTO) {
        MapperFacade mapper = mapperFactory.getMapperFacade();
        Cal cal = mapper.map(calDTO, Cal.class);

        Double d = calService.divide(cal);

        return RestResponse.succuess(d);
    }
}
