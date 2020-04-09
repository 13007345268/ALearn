package com.zking.zzcloud.sysservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Cal implements Serializable {
    private Double num1;
    private Double num2;
}
