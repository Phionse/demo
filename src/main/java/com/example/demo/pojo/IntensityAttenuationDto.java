package com.example.demo.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author zsf
 * @Date 2023-5-19 17:16
 * @Version 1.0
 */

@Data
public class IntensityAttenuationDto {

    @ApiModelProperty(value = "烈度")
    private Integer intensity;

    @ApiModelProperty(value = "震级")
    private Double m;

    @ApiModelProperty(value = "长轴长度(km)")
    private Double Da;

    @ApiModelProperty(value = "短轴长度(km)")
    private Double Db;

    @ApiModelProperty(value = "震中距离")
    private Double distance;


}
