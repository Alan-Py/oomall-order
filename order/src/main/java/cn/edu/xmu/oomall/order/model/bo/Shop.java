package cn.edu.xmu.oomall.order.model.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Shop {
    private Long id;
    private String name;

    public Shop(Long shopId) {
        this.id = shopId;
    }
}