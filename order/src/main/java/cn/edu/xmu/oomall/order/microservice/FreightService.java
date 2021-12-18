package cn.edu.xmu.oomall.order.microservice;

import cn.edu.xmu.oomall.core.util.ReturnObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @Author: zyz
 */
@FeignClient(name = "Freight")
public interface FreightService {
    @PostMapping("/regions/{rid}/price")
    ReturnObject getFreight(@PathVariable Long rid);
}
