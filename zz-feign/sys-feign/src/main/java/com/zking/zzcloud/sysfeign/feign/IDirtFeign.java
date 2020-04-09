package com.zking.zzcloud.sysfeign.feign;

import com.zking.zzcloud.sysfeign.dto.DictDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("sys-service")
public interface IDirtFeign {
    @RequestMapping(value = "/dict/save", method = RequestMethod.POST)
    String save(DictDTO dictDTO);

    @RequestMapping(value = "/dict/update", method = RequestMethod.POST)
    String update(DictDTO dictDTO);

    @RequestMapping(value = "/dict/delete", method = RequestMethod.POST)
    String delete(DictDTO dictDTO);

    @RequestMapping(value = "/dict/get", method = RequestMethod.POST)
    String get(DictDTO dictDTO);

    @RequestMapping(value = "/dict/list", method = RequestMethod.POST)
    String list(DictDTO dictDTO);


}
