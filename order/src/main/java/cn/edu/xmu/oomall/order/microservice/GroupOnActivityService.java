package cn.edu.xmu.oomall.order.microservice;

import cn.edu.xmu.privilegegateway.annotation.util.ReturnObject;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("Activity")
public interface GroupOnActivityService {
    @ApiOperation(value = "查询上线态团购活动详情")
    @GetMapping(value = "/groupons/{id}")
    ReturnObject getOnlineGroupOnActivity(@PathVariable Long id);
}
