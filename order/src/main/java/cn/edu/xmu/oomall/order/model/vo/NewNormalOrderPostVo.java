package cn.edu.xmu.oomall.order.model.vo;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "买家申请建立订单时的提交信息")
public class NewNormalOrderPostVo {
    private List<@Valid NewNormalOrderItemsPostVo> orderItems;

    private String consignee;

    private Integer regionId;

    private String address;

    private String mobile;

    private String message;

    private Integer advancesaleId;

    private Integer grouponId;
}