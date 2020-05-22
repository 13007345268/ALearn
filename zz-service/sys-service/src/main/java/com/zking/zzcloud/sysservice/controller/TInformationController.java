package com.zking.zzcloud.sysservice.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zking.zzcloud.common.util.JsonData;
import com.zking.zzcloud.sysfeign.dto.TInformationDTO;
import com.zking.zzcloud.sysservice.model.TInformation;
import com.zking.zzcloud.sysservice.service.ITInformationService;
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
 * @since 2020-04-14
 */
@RestController
@RequestMapping("/information")
@Slf4j
public class TInformationController {
    @Autowired
    private ITInformationService informationService;

    @Autowired
    private MapperFactory mapperFactory;

    private JsonData jsonData = new JsonData();

    //增加和修改
    @RequestMapping("/saveAndupdate")
    public JsonData saveAndupdate(@RequestBody TInformationDTO informationDTO){
        //判断id是否为空 为空则增加 相反为修改
        if(informationDTO.getInformationId()==null){
            log.info("saveAndupdate1={}",informationDTO);
            MapperFacade mapper = mapperFactory.getMapperFacade();
            TInformation information = mapper.map(informationDTO, TInformation.class);
            boolean save = informationService.save(information);
            if (save == true) {
                jsonData.setCode(0);
                jsonData.setMessage("新增数据字典成功！");
            } else {
                jsonData.setCode(-1);
                jsonData.setMessage("新增数据字典失败！");
            }
            System.out.print("增加**************************************");
        }else {
            log.info("saveAndupdate2={}",informationDTO);
            UpdateWrapper<TInformation> updateWrapper=new UpdateWrapper<>();//条件构造器
            updateWrapper.eq("information_id",informationDTO.getInformationId());
            updateWrapper.set("information_titile",informationDTO.getInformationTitile());
            updateWrapper.set("information_label",informationDTO.getInformationLabel());
            updateWrapper.set("information_author",informationDTO.getInformationAuthor());

            updateWrapper.set("information_approver",informationDTO.getInformationApprover());
            updateWrapper.set("information_content",informationDTO.getInformationContent());
            updateWrapper.set("information_state",informationDTO.getInformationState());
            updateWrapper.set("information_datatime",informationDTO.getInformationDatatime());
            boolean update = informationService.update(updateWrapper);
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


    //删除指令
    @RequestMapping("/delete")
    public JsonData delete(@RequestBody TInformationDTO informationDTO){
        boolean remove = informationService.removeById(informationDTO.getInformationId());
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
    public JsonData get(@RequestBody TInformationDTO informationDTO){
        TInformation information = informationService.getById(informationDTO.getInformationId());
        if (information != null) {
            jsonData.setCode(0);
            jsonData.setResult(information);
            jsonData.setMessage("查询数据字典成功！");
        } else {
            jsonData.setCode(-1);
            jsonData.setMessage("不存在该数据字典！");
        }
        return jsonData;
    }

    //查所有指令
    @RequestMapping("/list")
    public JsonData list(@RequestBody TInformationDTO informationDTO){
        Page<TInformation> page=new Page<>(informationDTO.getPageNum(),informationDTO.getRows());
        QueryWrapper<TInformation> queryWrapper=new QueryWrapper<TInformation>();
        if(StringUtils.isNotBlank(informationDTO.getInformationTitile())){
            queryWrapper.like("information_titile",informationDTO.getInformationTitile());
        }
        queryWrapper.orderByDesc("information_titile");
        Page<TInformation> informationPage = informationService.page(page, queryWrapper);
        jsonData.setCode(0);
        jsonData.setTotal((int)informationPage.getTotal());
        jsonData.setResult(informationPage.getRecords());
        jsonData.setMessage("查询数据字典成功！");
        return jsonData;
    }


}
