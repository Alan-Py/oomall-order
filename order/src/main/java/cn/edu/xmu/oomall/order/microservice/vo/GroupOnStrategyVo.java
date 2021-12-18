package cn.edu.xmu.oomall.order.microservice.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
@NoArgsConstructor
public class GroupOnStrategyVo {
    @Min(-1)
    Integer quantity;

    @Min(0)
    @Max(1000)
    Integer percentage;
}
