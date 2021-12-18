package cn.edu.xmu.oomall.order.controller;

import cn.edu.xmu.oomall.order.OrderApplication;
import cn.edu.xmu.oomall.order.microservice.vo.RefundInfoVo;
import cn.edu.xmu.privilegegateway.annotation.util.JwtHelper;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = OrderApplication.class)
@AutoConfigureMockMvc
@Transactional
class OrderControllerTest {

    @Autowired
    private MockMvc mvc;


    private static JwtHelper jwtHelper = new JwtHelper();
    private static String adminToken = jwtHelper.createToken(1L, "admin", 0L, 0, 3600);

    /**
     * Order Api 1
     *
     * @throws Exception
     * @Author: zyz
     * @sn: 22920192204338
     * 获取订单的所有状态
     */
    @Test
    @Transactional
    public void getorderState() throws Exception {
        String responseString = this.mvc.perform(get("/orders/states"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andReturn().getResponse().getContentAsString();
        String expected = "{\"errno\":0,\"data\":[{\"code\":101,\"name\":\"新订单\"}, " +
                "{\"code\":100,\"name\":\"待付款\"}, {\"code\":102,\"name\":\"待支付尾款\"}," +
                "{\"code\":200,\"name\":\"待收货\"},{\"code\":201,\"name\":\"付款完成\"}," +
                "{\"code\":202,\"name\":\"待成团\"},{\"code\":300,\"name\":\"已发货\"}," +
                "{\"code\":500,\"name\":\"已取消\"},{\"code\":400,\"name\":\"已完成\"}],\"errmsg\":\"成功\"}";
        JSONAssert.assertEquals(expected, responseString, false);
    }

    /**
     * Order Api 2
     *
     * @throws Exception
     * @Author: 潘越
     * @Sn: 22920192204259
     * 买家查看查询名下的订单(概要)
     */
    @Test
    void customerGetAllSimpleOrders() throws Exception {

        String responseString = this.mvc.perform(get("/orders").contentType("application/json;charset=UTF-8")
                .header("authorization", adminToken)
                .queryParam("orderSn", "dsds")
                .queryParam("beginTime", "2021-11-11 00:00:00.000")
                .queryParam("endTime", "2023-11-11 00:00:00.000"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.errno").value(0))
                .andExpect(jsonPath("$.data.page").value(1))
                .andExpect(jsonPath("$.data.pageSize").value(10))
                .andExpect(jsonPath("$.data.pages").value(1))
                .andExpect(jsonPath("$.data.total").value(3))
                .andExpect(jsonPath("$.data.list[0].id").value(2400))
                .andExpect(jsonPath("$.data.list[0].customerId").value(1))
                .andExpect(jsonPath("$.data.list[0].shopId").value(2))
                .andExpect(jsonPath("$.data.list[0].pid").value(2))
                .andExpect(jsonPath("$.data.list[0].state").value(101))
                .andExpect(jsonPath("$.data.list[0].originPrice").value(212))
                .andExpect(jsonPath("$.data.list[0].discountPrice").value(2121))
                .andExpect(jsonPath("$.data.list[0].expressFee").value(212))
                .andExpect(jsonPath("$.data.list[0].point").value(212))
                .andExpect(jsonPath("$.data.list[0].grouponId").value(15151))
                .andExpect(jsonPath("$.data.list[0].advancesaleId").value(15155))
                .andExpect(jsonPath("$.data.list[0].shipmentSn").value(212))
                .andExpect(jsonPath("$.data.list[0].gmtCreate").value("2021-12-12T16:05:22"))
                .andReturn().getResponse().getContentAsString();
        System.out.println(responseString);
    }

    /**
     * Order Api 6
     *
     * @throws Exception
     * @Author: 潘越
     * @Sn: 22920192204259
     * 买家逻辑删除本人名下的订单
     */
    @Test
    void customerDeleteOrder() throws Exception {

        String responseString = this.mvc.perform(delete("/orders/2401").header("authorization", adminToken))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andReturn().getResponse().getContentAsString();

        String expected = "{\"errno\":0,\"errmsg\":\"成功\"}";
        JSONAssert.assertEquals(expected, responseString, false);
    }

    /**
     * Order Api 7
     *
     * @throws Exception
     * @Author: zyz
     * @Sn: 22920192204338
     * 买家取消本人名下订单
     */
    @Test
    @Transactional
    public void cancelOrder() throws Exception {
        String responseString = this.mvc.perform(put("/orders/2401/cancel")
                .header("authorization", adminToken)
                .contentType("application/json;charset=UTF-8"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andReturn().getResponse().getContentAsString();
        String expected = "{\"errno\":0,\"errmsg\":\"成功\"}";
        JSONAssert.assertEquals(expected, responseString, false);
    }

    /**
     * Order Api 8
     *
     * @throws Exception
     * @Author: 潘越
     * @Sn: 22920192204259
     * 买家标记确认收货
     */
    @Test
    void customerConfirmOrder() throws Exception {

        String responseString = this.mvc.perform(put("/orders/2403/confirm").header("authorization", adminToken))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andReturn().getResponse().getContentAsString();

        String expected = "{\"errno\":0,\"errmsg\":\"成功\"}";
        JSONAssert.assertEquals(expected, responseString, false);
    }

    @Test
    void shopGetAllSimpleOrders() throws Exception {
        String responseString = this.mvc.perform(get("/shops/2/orders").contentType("application/json;charset=UTF-8")
                .header("authorization", adminToken)
                .queryParam("customerId", "1")
                .queryParam("orderSn", "dsds")
                .queryParam("beginTime", "2021-11-11 00:00:00.000")
                .queryParam("endTime", "2023-11-11 00:00:00.000"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.errno").value(0))
                .andExpect(jsonPath("$.data.page").value(1))
                .andExpect(jsonPath("$.data.pageSize").value(10))
                .andExpect(jsonPath("$.data.pages").value(1))
                .andExpect(jsonPath("$.data.total").value(3))
                .andExpect(jsonPath("$.data.list[0].id").value(2400))
                .andExpect(jsonPath("$.data.list[0].customerId").value(1))
                .andExpect(jsonPath("$.data.list[0].shopId").value(2))
                .andExpect(jsonPath("$.data.list[0].pid").value(2))
                .andExpect(jsonPath("$.data.list[0].state").value(101))
                .andExpect(jsonPath("$.data.list[0].originPrice").value(212))
                .andExpect(jsonPath("$.data.list[0].discountPrice").value(2121))
                .andExpect(jsonPath("$.data.list[0].expressFee").value(212))
                .andExpect(jsonPath("$.data.list[0].point").value(212))
                .andExpect(jsonPath("$.data.list[0].grouponId").value(15151))
                .andExpect(jsonPath("$.data.list[0].advancesaleId").value(15155))
                .andExpect(jsonPath("$.data.list[0].shipmentSn").value(212))
                .andExpect(jsonPath("$.data.list[0].gmtCreate").value("2021-12-12T16:05:22"))
                .andReturn().getResponse().getContentAsString();
        System.out.println(responseString);
    }

    /**
     * Order Api 10
     *
     * @throws Exception
     * @Author: 潘越
     * @Sn: 22920192204259
     * 店家修改订单 (留言)
     */
    @Test
    void ShopUpdateMessage() throws Exception {
        adminToken = jwtHelper.createToken(1L, "admin", 0L, 0, 3600);
        String requestJson = "{\"message\": \"保国马\"}";
        String responseString = this.mvc.perform(put("/shops/2/orders/2403").contentType("application/json;charset=UTF-8").content(requestJson)
                .header("authorization", adminToken))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andReturn().getResponse().getContentAsString();

        String expected = "{\"errno\":0,\"errmsg\":\"成功\"}";
        JSONAssert.assertEquals(expected, responseString, false);
    }

    /**
     * Order Api 12
     *
     * @throws Exception
     * @Author: 潘越
     * @Sn: 22920192204259
     * 店家对订单标记发货
     */
    @Test
    void postfreights() throws Exception {
        adminToken = jwtHelper.createToken(1L, "admin", 0L, 0, 3600);
        String requestJson = "{\"shipmentSn\": \"锡特勒\"}";
        String responseString = this.mvc.perform(put("/shops/2/orders/2403/deliver").contentType("application/json;charset=UTF-8").content(requestJson)
                .header("authorization", adminToken))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andReturn().getResponse().getContentAsString();

        String expected = "{\"errno\":0,\"errmsg\":\"成功\"}";
        JSONAssert.assertEquals(expected, responseString, false);
    }

    /**
     * Order Api 14
     * @return
     * @Author 潘越
     * @Sn: 22920192204259
     * 查询自己订单的退款信息
     */
    @Test
    void getOrderRefund(){
        List<RefundInfoVo> refundInfoVoList =new ArrayList<>();
        RefundInfoVo refundInfoVo = new RefundInfoVo();
        refundInfoVo.setId(1L);
        refundInfoVo.setPaymentId(1L);
        refundInfoVo.setTradeSn("岛市老八");
        refundInfoVo.setPatternId(1L);
        refundInfoVo.setAmount(10000L);
        refundInfoVo.setState((byte) 1);
        refundInfoVo.setDocumentId("dds");
        refundInfoVo.setDocumentType((byte) 0);
    }
    /**
     * 内部api 自定义
     *
     * @return
     * @Author 潘越
     * @Sn 22920192204259
     * 修改订单状态，可任意
     */
    @Test
    void UpdateAnyState() throws Exception {
        String responseString = this.mvc.perform(put("/internal/orders/2403/states").header("authorization", adminToken)
                .queryParam("state", "101"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andReturn().getResponse().getContentAsString();
        String expected = "{\"errno\":0,\"errmsg\":\"成功\"}\n";
        JSONAssert.assertEquals(expected, responseString, false);
    }
}