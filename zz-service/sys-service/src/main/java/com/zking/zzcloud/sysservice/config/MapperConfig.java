package com.zking.zzcloud.sysservice.config;

import com.zking.zzcloud.sysfeign.dto.CalDTO;
import com.zking.zzcloud.sysfeign.dto.DictDTO;
import com.zking.zzcloud.sysservice.model.Cal;
import com.zking.zzcloud.sysservice.model.Dict;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置PO对象与DTO对象的映射关系
 */
@Configuration
public class MapperConfig {

    @Bean
    public MapperFactory mapperFactory() {
        return new DefaultMapperFactory.Builder().build();
    }

    @Autowired
    public void config(MapperFactory mapperFactory) {
        //注册Cal和CalDTO的字段映射
        mapperFactory.classMap(Cal.class, CalDTO.class)
                //.field("firstName", "givenName")//源对象与目的地对象的属性不一致时
                //.field("lastName", "sirName")
                .byDefault()
                .register();
        //注册Dict和DictDTO的字段映射
        mapperFactory.classMap(Dict.class, DictDTO.class)
                .byDefault()
                .register();
    }

}