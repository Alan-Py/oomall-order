package cn.edu.xmu.oomall.order.model.vo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;

/**
 * @Author: zyz
 */
@Data
@ApiModel(value = "修改订单操作字段(状态)")
public class ModifyOrderVo {
    @ApiModelProperty(value = "收货人")
    private String consignee;

    @ApiModelProperty(value = "地区Id")
    private Long regionId;

    @ApiModelProperty(value = "地址")
    private String address;

    @ApiModelProperty(value = "电话")
    private String mobile;
}
