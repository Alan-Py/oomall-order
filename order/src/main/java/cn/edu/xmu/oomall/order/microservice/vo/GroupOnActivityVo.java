package cn.edu.xmu.oomall.order.microservice.vo;

import cn.edu.xmu.oomall.order.constant.Constants;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class GroupOnActivityVo {
    private Long id;
    private String name;
    private Long shopId;
    private List<GroupOnStrategyVo> strategy;
    @JsonFormat(pattern = Constants.DATE_TIME_FORMAT, timezone = "GMT+8")
    private LocalDateTime beginTime;

    @JsonFormat(pattern = Constants.DATE_TIME_FORMAT, timezone = "GMT+8")
    private LocalDateTime endTime;
}
