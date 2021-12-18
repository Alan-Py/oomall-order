package cn.edu.xmu.oomall.order.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Order留言视图")
public class OrderMessageVo {
    @ApiModelProperty(value = "order留言")
    private String message;
}
