package com.example.demo.pojo;

import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
@ApiModel("其他资金明细excel实体")
public class OtherFundDetailsExcelDTO {

    @ApiModelProperty(value = "发生日期")
    @ExcelProperty(value = "发生日期", index = 0)
    private String happenDate;

    @ApiModelProperty(value = "交易所")
    @ExcelProperty(value = "交易所", index = 2)
    private String exchange;

    @ApiModelProperty(value = "类型")
    @ExcelProperty(value = "类型", index = 4)
    private String type;

    @ApiModelProperty(value = "金额")
    @ExcelProperty(value = "金额", index = 6)
    private BigDecimal money;

    @ApiModelProperty(value = "备注")
    @ExcelProperty(value = "备注", index = 8)
    private String remark;
}

