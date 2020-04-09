package com.zking.zzcloud.sysfeign.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DictDTO {
    /**
     * 字典ID
     */
    private Long dictId;

    /**
     * 字典名称
     */
    private String dictName;

    /**
     * 字典文本: 一般用来生成下拉框的文本
     */
    private String dictText;

    /**
     * 字典取值: 一般用来生成下拉框的值
     */
    private String dictValue;

    /**
     * 能否编辑: 1 可 0 不可
     */
    private Integer editable;

    private Integer pageNum=1;

    private Integer rows=5;
}
