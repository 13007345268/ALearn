package com.zking.zzcloud.sysapi.controller;

import com.zking.zzcloud.sysfeign.dto.DictDTO;
import com.zking.zzcloud.sysfeign.dto.TInformationDTO;
import com.zking.zzcloud.sysfeign.feign.ITInformationFeign;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/information")
@RestController
@Slf4j
public class TInformationController {

    @Autowired
    private ITInformationFeign informationFeign;

    @RequestMapping("/saveAndupdate")
    public String saveAndupdate(TInformationDTO informationDTO) {
        log.info("informationDTO={}", informationDTO);
        String data = informationFeign.saveAndupdate(informationDTO);
        return data;
    }

    @RequestMapping("/update")
    public String update(TInformationDTO informationDTO) {
        log.info("informationDTO={}", informationDTO);
        String data = informationFeign.update(informationDTO);
        return data;
    }


    @RequestMapping("/delete")
    public String delete(TInformationDTO informationDTO) {
        log.info("informationDTO={}", informationDTO);
        String data = informationFeign.delete(informationDTO);
        return data;
    }

    @RequestMapping("/get")
    public String get(TInformationDTO informationDTO) {
        log.info("informationDTO={}", informationDTO);
        String data = informationFeign.get(informationDTO);
        return data;
    }

    @RequestMapping("/list")
    public String list(TInformationDTO informationDTO) {
        log.info("informationDTO={}", informationDTO);
        String data = informationFeign.list(informationDTO);
        return data;
    }





}
