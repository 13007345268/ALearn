package com.zking.zzcloud.sysapi.controller;

import com.zking.zzcloud.sysfeign.dto.CalDTO;
import com.zking.zzcloud.sysfeign.dto.DictDTO;
import com.zking.zzcloud.sysfeign.feign.ICalFeign;
import com.zking.zzcloud.sysfeign.feign.IDirtFeign;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/dict")
@RestController
@Slf4j
public class DictController {

    @Autowired
    private  IDirtFeign dictFeign;

    @RequestMapping("/save")
    public String add(DictDTO dictDTO) {
        log.info("dictDTO={}", dictDTO);
        String data = dictFeign.save(dictDTO);
        return data;
    }

    @RequestMapping("/update")
    public String update(DictDTO dictDTO) {
        log.info("dictDTO={}", dictDTO);
        String data = dictFeign.update(dictDTO);
        return data;
    }

    @RequestMapping("/delete")
    public String delete(DictDTO dictDTO) {
        log.info("dictDTO={}", dictDTO);
        String data = dictFeign.delete(dictDTO);
        return data;
    }

    @RequestMapping("/get")
    public String get(DictDTO dictDTO) {
        log.info("dictDTO={}", dictDTO);
        String data = dictFeign.get(dictDTO);
        return data;
    }

    @RequestMapping("/list")
    public String list(DictDTO dictDTO) {
        log.info("dictDTO={}", dictDTO);
        String data = dictFeign.list(dictDTO);
        return data;
    }





}
