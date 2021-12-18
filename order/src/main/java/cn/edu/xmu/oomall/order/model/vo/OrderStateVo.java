package cn.edu.xmu.oomall.order.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
/**
 * 内部api 自定义
 * @Author 潘越
 * @Sn 22920192204259
 * 修改订单状态，可任意
 */
@Data
@ApiModel(value = "Order状态视图")
public class OrderStateVo {
    @ApiModelProperty(value = "order状态")
    private Integer state;
}
