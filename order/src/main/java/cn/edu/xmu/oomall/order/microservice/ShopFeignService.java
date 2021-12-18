package cn.edu.xmu.oomall.order.microservice;

import cn.edu.xmu.privilegegateway.annotation.util.InternalReturnObject;
import cn.edu.xmu.oomall.order.model.bo.Shop;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "shop")
public interface ShopFeignService {
    @GetMapping(value = "/internal/shop/{id}")
    InternalReturnObject<Shop> getShopById(@PathVariable Long id);
}