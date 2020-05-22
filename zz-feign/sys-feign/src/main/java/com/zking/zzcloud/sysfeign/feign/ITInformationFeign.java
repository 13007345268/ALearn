package com.zking.zzcloud.sysfeign.feign;

import com.zking.zzcloud.sysfeign.dto.TInformationDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("sys-service")
public interface ITInformationFeign {
    @RequestMapping(value = "/information/saveAndupdate", method = RequestMethod.POST)
    String saveAndupdate(TInformationDTO tinformationDTO);

    @RequestMapping(value = "/information/update", method = RequestMethod.POST)
    String update(TInformationDTO tinformationDTO);

    @RequestMapping(value = "/information/delete", method = RequestMethod.POST)
    String delete(TInformationDTO tinformationDTO);

    @RequestMapping(value = "/information/get", method = RequestMethod.POST)
    String get(TInformationDTO tinformationDTO);

    @RequestMapping(value = "/information/list", method = RequestMethod.POST)
    String list(TInformationDTO tinformationDTO);


}
