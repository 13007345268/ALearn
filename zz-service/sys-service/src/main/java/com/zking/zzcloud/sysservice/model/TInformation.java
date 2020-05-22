package com.zking.zzcloud.sysservice.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhangshuai
 * @since 2020-04-14
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("t_information")
public class TInformation extends Model {

    private static final long serialVersionUID = 1L;

    /**
     * ID：主键
     */
    @TableId(value = "information_id", type = IdType.AUTO)
    private Long informationId;

    /**
     * 资讯标题
     */
    private String informationTitile;

    /**
     * 资讯标签
     */
    private String informationLabel;

    /**
     * 资讯作者
     */
    private String informationAuthor;

    /**
     * 资讯审批人
     */
    private String informationApprover;

    /**
     * 资讯内容
     */
    private String informationContent;

    /**
     * 资讯状态
     */
    private String informationState;

    /**
     * 发布时间
     */
    private String informationDatatime;


}
