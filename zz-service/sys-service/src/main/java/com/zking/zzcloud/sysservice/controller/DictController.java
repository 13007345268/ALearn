package com.zking.zzcloud.sysservice.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zking.zzcloud.common.util.RestResponse;
import com.zking.zzcloud.sysfeign.dto.DictDTO;
import com.zking.zzcloud.sysservice.model.Dict;
import com.zking.zzcloud.sysservice.service.IDictService;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhangshuai
 * @since 2020-04-08
 */
@RestController
@RequestMapping("/dict")
@Slf4j
public class DictController {

    @Autowired
    private IDictService dictService;

    @Autowired
    private MapperFactory mapperFactory;

    //增加
    @RequestMapping("/save")
    public RestResponse save(@RequestBody DictDTO dictDTO){
        MapperFacade mapper = mapperFactory.getMapperFacade();
        Dict dict = mapper.map(dictDTO, Dict.class);
        dictService.save(dict);
        return RestResponse.succuess();
    }


    //修改指令
    @RequestMapping("/update")
    public RestResponse update(@RequestBody DictDTO dictDTO){
        log.info("生产者,dictDTO={}",dictDTO);
        UpdateWrapper<Dict> updateWrapper=new UpdateWrapper<Dict>();//条件构造器
        updateWrapper.eq("dict_id",dictDTO.getDictId());
        updateWrapper.set("dict_name",dictDTO.getDictName());
        updateWrapper.set("dict_text",dictDTO.getDictText());
        updateWrapper.set("dict_value",dictDTO.getDictValue());
//        updateWrapper.set("editable",dictDTO.getEditable());
        dictService.update(updateWrapper);
        return RestResponse.succuess();
    }

    //删除指令
    @RequestMapping("/delete")
    public RestResponse delete(@RequestBody DictDTO dictDTO){
        dictService.removeById(dictDTO.getDictId());
        return RestResponse.succuess();
    }

    //查单个指令
    @RequestMapping("/get")
    public RestResponse get(@RequestBody DictDTO dictDTO){
        Dict bict = dictService.getById(dictDTO.getDictId());
        return RestResponse.succuess(bict);
    }

    //查所有指令
    @RequestMapping("/list")
    public RestResponse list(@RequestBody DictDTO dictDTO){
        Page<Dict> page=new Page<>(dictDTO.getPageNum(),dictDTO.getRows());
        QueryWrapper<Dict> queryWrapper=new QueryWrapper<Dict>();
        if(StringUtils.isNotBlank(dictDTO.getDictName())){
            queryWrapper.like("name",dictDTO.getDictName());
        }
        queryWrapper.orderByDesc("dict_name");
        Page<Dict> dictPage = dictService.page(page, queryWrapper);

        return RestResponse.succuess(dictPage);
    }



}
