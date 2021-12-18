package cn.edu.xmu.oomall.order.model.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    public enum State {
        NEW_ORDER(101, "新订单"),
        PENDING_PAYMENT(100, "待付款"),
        PENDING_FINAL_PAYMENT(102, "待支付尾款"),
        PENDING_DELIVERY(200, "待收货"),
        PAYMENT_COMPLETED(201, "付款完成"),
        PENDING_GROUPING(202, "待成团"),
        SUBDIVIDED(203, "已分单"),
        SHIPPED(300, "已发货"),
        CANCELED(500, "已取消"),
        COMPLETED(400, "已完成");

        private static final Map<Integer, State> stateMap;
        static {
            stateMap = new HashMap<>();
            for (State enum1 : values()) {
                stateMap.put(enum1.code, enum1);
            }
        }

        private int code;
        private String description;

        State(int code, String description) {
            this.code = code;
            this.description = description;
        }

        public Integer getCode() {
            return code;
        }

        public String getDescription() {
            return description;
        }
    }

    /**
     * copy from Po
     */
    private Long id;
    private Long customerId;
    private Long shopId;
    private String orderSn;
    private Long pid;
    private String consignee;
    private Long regionId;
    private String address;
    private String mobile;
    private String message;
    private Long advancesaleId;
    private Long grouponId;
    private Long expressFee;
    private Long discountPrice;
    private Long originPrice;
    private Long point;
    private LocalDateTime confirmTime;
    private String shipmentSn;
    private Integer state;
    private Byte beDeleted;
    private Long creatorId;
    private String creatorName;
    private Long modifierId;
    private String modifierName;
    private LocalDateTime gmtCreate;
    private LocalDateTime gmtModified;
}