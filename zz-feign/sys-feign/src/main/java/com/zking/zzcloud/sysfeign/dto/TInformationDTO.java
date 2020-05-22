package com.zking.zzcloud.sysfeign.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TInformationDTO {
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

    private Integer pageNum=1;

    private Integer rows=5;
}
