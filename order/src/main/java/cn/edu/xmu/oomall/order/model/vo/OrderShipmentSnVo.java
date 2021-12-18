package cn.edu.xmu.oomall.order.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Order发货快递单视图")
public class OrderShipmentSnVo {
    @ApiModelProperty(value = "order发货快递单号")
    private String shipmentSn;
}
