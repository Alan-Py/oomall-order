package cn.edu.xmu.oomall.order.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "买家申请创建订单时提交的订单明细")
public class NewNormalOrderItemsPostVo {
    Integer productId;

    Integer onsaleId;

    Integer quantity;

    Integer couponActId;

    Integer couponId;
}