package com.zking.zzcloud.sysservice.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zking.zzcloud.common.util.JsonData;
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

    private JsonData jsonData = new JsonData();

    //增加和修改
    @RequestMapping("/saveAndupdate")
    public JsonData saveAndupdate(@RequestBody DictDTO dictDTO){
        //判断id是否为空 为空则增加 相反为修改
        if(dictDTO.getDictId()==null){
            log.info("saveAndupdate1={}",dictDTO);
            MapperFacade mapper = mapperFactory.getMapperFacade();
            Dict dict = mapper.map(dictDTO, Dict.class);
            boolean save = dictService.save(dict);
            if (save == true) {
                jsonData.setCode(0);
                jsonData.setMessage("新增数据字典成功！");
            } else {
                jsonData.setCode(-1);
                jsonData.setMessage("新增数据字典失败！");
            }
            System.out.print("增加**************************************");
        }else {
            log.info("saveAndupdate2={}",dictDTO);
            UpdateWrapper<Dict> updateWrapper=new UpdateWrapper<>();//条件构造器
            updateWrapper.eq("dict_id",dictDTO.getDictId());
            updateWrapper.set("dict_name",dictDTO.getDictName());
            updateWrapper.set("dict_text",dictDTO.getDictText());
            updateWrapper.set("dict_value",dictDTO.getDictValue());
            updateWrapper.set("editable",dictDTO.getEditable());
            boolean update = dictService.update(updateWrapper);
            if (update == true) {
                jsonData.setCode(0);
                jsonData.setMessage("修改数据字典成功！");
            } else {
                jsonData.setCode(-1);
                jsonData.setMessage("修改数据字典失败！");
            }
            System.out.print("修改**************************************");
        }
        return jsonData;
    }


    //增加和修改
//    @RequestMapping("/update")
//    public JsonData update(@RequestBody DictDTO dictDTO){
//        log.info("update={}",dictDTO);
//        UpdateWrapper<Dict> updateWrapper=new UpdateWrapper<>();//条件构造器
//        updateWrapper.eq("dict_id",dictDTO.getDictId());
//        updateWrapper.set("dict_name",dictDTO.getDictName());
//        updateWrapper.set("dict_text",dictDTO.getDictText());
//        updateWrapper.set("dict_value",dictDTO.getDictValue());
//        updateWrapper.set("editable",dictDTO.getEditable());
//        boolean update = dictService.update(updateWrapper);
//        if (update == true) {
//            jsonData.setCode(0);
//            jsonData.setMessage("修改数据字典成功！");
//        } else {
//            jsonData.setCode(-1);
//            jsonData.setMessage("修改数据字典失败！");
//        }
//        System.out.print("修改**************************************");
//        return jsonData;
//    }

    //删除指令
    @RequestMapping("/delete")
    public JsonData delete(@RequestBody DictDTO dictDTO){
        boolean remove = dictService.removeById(dictDTO.getDictId());
        if (remove == true) {
            jsonData.setCode(0);
            jsonData.setMessage("删除数据字典成功！");
        } else {
            jsonData.setCode(-1);
            jsonData.setMessage("删除数据字典失败！");
        }
        return jsonData;
    }

    //查单个指令
    @RequestMapping("/get")
    public JsonData get(@RequestBody DictDTO dictDTO){
        Dict bict = dictService.getById(dictDTO.getDictId());
        if (bict != null) {
            jsonData.setCode(0);
            jsonData.setResult(bict);
            jsonData.setMessage("查询数据字典成功！");
        } else {
            jsonData.setCode(-1);
            jsonData.setMessage("不存在该数据字典！");
        }
        return jsonData;
    }

    //查所有指令
    @RequestMapping("/list")
    public JsonData list(@RequestBody DictDTO dictDTO){
        Page<Dict> page=new Page<>(dictDTO.getPageNum(),dictDTO.getRows());
        QueryWrapper<Dict> queryWrapper=new QueryWrapper<Dict>();
        if(StringUtils.isNotBlank(dictDTO.getDictName())){
            queryWrapper.like("dict_name",dictDTO.getDictName());
        }
        queryWrapper.orderByDesc("dict_name");
        Page<Dict> dictPage = dictService.page(page, queryWrapper);
        jsonData.setCode(0);
        jsonData.setTotal((int)dictPage.getTotal());
        jsonData.setResult(dictPage.getRecords());
        jsonData.setMessage("查询数据字典成功！");
        return jsonData;
    }



}
