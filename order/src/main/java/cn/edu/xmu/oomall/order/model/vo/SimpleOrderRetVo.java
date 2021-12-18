package cn.edu.xmu.oomall.order.model.vo;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class SimpleOrderRetVo {
    private Long id;
    private Long customerId;
    private Long shopId;
    private Long pid;
    private Integer state;
    private LocalDateTime gmtCreate;
    private Long originPrice;
    private Long discountPrice;
    private Long expressFee;
    private Long point;
    private Long grouponId;
    private Long advancesaleId;
    private String shipmentSn;
}