package com.example.demo.pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 *   设备信息
 * </p>
 *
 * @author zyk
 * @since 2020-08-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="DeviceInfo对象", description="")
public class DeviceInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "设备信息ID")
    @TableId(value = "id", type = IdType.AUTO)
    private String id;

    @ApiModelProperty(value = "设备名称")
    private String deviceName;
    @ApiModelProperty(value = "视频编码")
    private String indexCode;
    @ApiModelProperty(value = "巡检时间")
    private String collectTime;
    @ApiModelProperty(value = "位置")
    private String location;
    @ApiModelProperty(value = "在线状态")
    private String treatyType;
    @ApiModelProperty(value = "地区名字")
    private String regionName;
    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;
    @ApiModelProperty(value = "更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtUpdate;



}
