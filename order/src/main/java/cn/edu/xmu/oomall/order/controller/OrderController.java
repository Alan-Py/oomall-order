package cn.edu.xmu.oomall.order.controller;

import cn.edu.xmu.oomall.order.constant.Constants;
import cn.edu.xmu.oomall.order.model.bo.Order;
import cn.edu.xmu.oomall.order.model.vo.*;
import cn.edu.xmu.oomall.order.service.OrderService;
import cn.edu.xmu.privilegegateway.annotation.aop.Audit;
import cn.edu.xmu.privilegegateway.annotation.aop.LoginName;
import cn.edu.xmu.privilegegateway.annotation.aop.LoginUser;
import cn.edu.xmu.privilegegateway.annotation.util.Common;
import cn.edu.xmu.privilegegateway.annotation.util.ReturnObject;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

import static cn.edu.xmu.privilegegateway.annotation.util.Common.cloneVo;

@Api(value = "订单", tags = "order")
@RestController /*Restful的Controller对象*/
@RefreshScope
@RequestMapping(value = "/", produces = "application/json;charset=UTF-8")
@Component
public class OrderController {
    @Autowired
    private HttpServletResponse httpServletResponse;

    @Autowired
    private OrderService orderService;


    /**
     * Order Api 1
     *
     * @return
     * @Author: zyz
     * @Sn: 22920192204338
     * 获取订单的所有状态
     */
    @ApiOperation(value = "获取订单的所有状态", tags = "order")
    @ApiResponses(value = {
            @ApiResponse(code = 0, message = "成功")})
    @GetMapping(value = "/orders/states")
    public Object getorderState() {
        ReturnObject<List> returnObject = orderService.getOrderStates();
        return Common.decorateReturnObject(returnObject);
    }

//    @ApiOperation(value = "买家申请建立订单", tags = "order")
//    @ApiImplicitParams({
//            @ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户Token", required = true),
//            @ApiImplicitParam(paramType = "body", dataType = "NewNormalOrderPostVo", name = "orderInfo", value = "指定新订单的资料", required = false)
//    })
//    @ApiResponses(value = {
//            @ApiResponse(code = 0, message = "成功"),
//            @ApiResponse(code = 904, message = "库存不足")})
//    @Audit(departName = "orders")
//    @PostMapping(value = "/orders")
//    public Object customerPostNewNormalOrder(@Validated  @RequestBody NewNormalOrderPostVo body, BindingResult bindingResult,
//                                             @LoginUser Long loginUserId, @LoginName String loginUserName) {
//        var filedErrors = Common.processFieldErrors(bindingResult, httpServletResponse);
//        if (filedErrors != null)
//            return filedErrors;
//
//        ReturnObject ret;
//        ret = orderService.addOrder(body, loginUserId, loginUserName);
//
//        return Common.decorateReturnObject(ret);
//    }

//    /**
//     * Order Api 5
//     *
//     * @Author: zyz
//     * @Sn: 22920192204338
//     * 买家修改本人名下订单
//     * @param modifyOrderVo
//     * @param bindingResult
//     * @param id
//     * @param loginUser
//     * @param loginUserName
//     * @return
//     */
//    @ApiOperation(value = "买家修改本人名下订单", tags = "order")
//    @ApiImplicitParams({
//            @ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户Token", required = true),
//            @ApiImplicitParam(paramType = "path", dataType = "Integer", name = "id", value = "订单id", required = true),
//            @ApiImplicitParam(paramType = "body", dataType = "ModifyOrderVo", name = "body", value = "操作字段 (状态)", required = true)})
//    @ApiResponses(value = {
//            @ApiResponse(code = 0, message = "成功"),
//            @ApiResponse(code = 507, message = "当前状态禁止此操作"),
//            @ApiResponse(code = 801, message = "订单地址费用变化")})
//    @Audit(departName = "orders")
//    @PutMapping(value = "/orders/{id}")
//    public Object modifyOrder(@Validated @RequestBody ModifyOrderVo modifyOrderVo, BindingResult bindingResult,
//                              @PathVariable Long id, @LoginUser Long loginUser, @LoginName String loginUserName) {
//        var filedErrors = Common.processFieldErrors(bindingResult, httpServletResponse);
//        if (filedErrors != null)
//            return filedErrors;
//        ReturnObject ret = orderService.updateOrder(id, modifyOrderVo, loginUser, loginUserName);
//        return Common.decorateReturnObject(ret);
//    }

    /**
     * Order Api 7
     *
     * @param id
     * @param loginUser
     * @param loginUserName
     * @return
     * @Author: zyz
     * @Sn: 22920192204338
     * 买家取消本人名下订单
     */
    @ApiOperation(value = "买家取消本人名下订单", tags = "order")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户Token", required = true),
            @ApiImplicitParam(paramType = "path", dataType = "Integer", name = "id", value = "订单id", required = true)})
    @ApiResponses(value = {
            @ApiResponse(code = 0, message = "成功"),
            @ApiResponse(code = 507, message = "当前状态禁止此操作")})
    @Audit(departName = "orders")
    @PutMapping(value = "/orders/{id}/cancel")
    public Object cancelOrder(@PathVariable("id") Long id, @LoginUser Long loginUser, @LoginName String loginUserName) {
        ReturnObject ret = orderService.cancelOrder(id, loginUser, loginUserName);
        return Common.decorateReturnObject(ret);
    }

    /**
     * Order Api 13
     *
     * @param orderId
     * @param loginUser
     * @return
     * @Author: zyz
     * @Sn: 22920192204338
     * 获得自己订单的支付信息
     */
    @ApiOperation(value = "获得自己订单的支付信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户Token", required = true),
            @ApiImplicitParam(paramType = "path", dataType = "Integer", name = "id", value = "订单id", required = true)})
    @Audit(departName = "orders")
    @GetMapping(value = "/orders{id}/payment")
    public Object getOrderPayment(@PathVariable("id") Long orderId, @LoginUser Long loginUser) {
        ReturnObject ret = orderService.getOrderPayment(orderId, loginUser);
        return Common.decorateReturnObject(ret);
    }

    /**
     * Order Api 9
     *
     * @param loginUser
     * @param loginUsername
     * @param shopId
     * @param customerId
     * @param orderSn
     * @param beginTime
     * @param endTime
     * @param page
     * @param pageSize
     * @return
     * @Author: zyz
     * @Sn: 22920192204338
     * 店家查询商户所有订单(概要)
     */
    @ApiOperation(value = "店家查询商户所有订单(概要)")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户Token", required = true),
            @ApiImplicitParam(paramType = "path", dataType = "Integer", name = "shopId", value = "商户id(店员只能查询本店铺)", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "Integer", name = "customerId", value = "查询的购买者用户id", required = false),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "orderSn", value = "按订单Sn来查询", required = false),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "beginTime", value = "开始时间", required = false),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "endTime", value = "结束时间", required = false),
            @ApiImplicitParam(paramType = "query", dataType = "Integer", name = "page", value = "页码", required = false),
            @ApiImplicitParam(paramType = "query", dataType = "Integer", name = "pageSize", value = "每页数目", required = false)})
    @ApiResponse(code = 0, message = "成功")
    @GetMapping(value = "shops/{shopId}/orders")
    public Object shopGetAllSimpleOrders(@LoginUser Long loginUser, @LoginName String loginUsername,
                                         @PathVariable Long shopId, @RequestParam(required = false) Long customerId,
                                         @RequestParam(required = false) String orderSn,
                                         @RequestParam(required = false) @DateTimeFormat(pattern = Constants.DATE_TIME_FORMAT) LocalDateTime beginTime,
                                         @RequestParam(required = false) @DateTimeFormat(pattern = Constants.DATE_TIME_FORMAT) LocalDateTime endTime,
                                         @RequestParam(required = false, defaultValue = "1") Integer page,
                                         @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        ReturnObject ret = orderService.shopGetAllSimpleOrders(loginUser, shopId, customerId, orderSn, beginTime, endTime, page, pageSize);
        return Common.decorateReturnObject(ret);
    }

    /**
     * Order Api 15
     *
     * @param orderId
     * @param shopId
     * @param loginUser
     * @param loginUserName
     * @return
     * @Author: zyz
     * @Sn: 22920192204338
     * 确认团购订单
     */
    @ApiOperation(value = "确认团购订单", tags = "order")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户Token", required = true),
            @ApiImplicitParam(paramType = "path", dataType = "Integer", name = "orderId", value = "订单id", required = true),
            @ApiImplicitParam(paramType = "path", dataType = "Integer", name = "shopId", value = "商店id", required = true)})
    @ApiResponses(value = {
            @ApiResponse(code = 0, message = "成功"),
            @ApiResponse(code = 507, message = "当前状态禁止此操作")})
    @PutMapping(value = "/internal/shops/{shopId}/grouponorders/{id}/confirm")
    public Object confirmGroupOrders(@PathVariable Long orderId, @PathVariable Long shopId,
                                     @LoginUser Long loginUser, @LoginName String loginUserName) {
        ReturnObject ret = orderService.confirmGroupOrders(orderId, shopId, loginUser, loginUserName);
        return Common.decorateReturnObject(ret);
    }

    /**
     * Order Api 2
     *
     * @param loginUser
     * @param page
     * @param pageSize
     * @return
     * @Author: 潘越
     * @Sn: 22920192204259
     * 买家查看查询名下的订单(概要)
     */
    @ApiOperation(value = "买家查询订单(概要查询)")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "Token", required = true, dataType = "String", paramType = "header"),
            @ApiImplicitParam(name = "orderSn", value = "订单编号", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "state", value = "订单状态", required = false, dataType = "Long", paramType = "query"),
            @ApiImplicitParam(name = "beginTime", value = "开始时间", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "endTime", value = "结束时间", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "page", value = "页码", required = false, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页数目", required = false, dataType = "Integer", paramType = "query")
    })
    @ApiResponses({
            @ApiResponse(code = 0, message = "成功"),
            @ApiResponse(code = 504, message = "操作的资源id不存在")
    })
    @Audit(departName = "orders")
    @GetMapping(value = "/orders")
    public Object customerGetAllSimpleOrders(
            @LoginUser Long loginUser, @LoginName String loginUsername,
            @RequestParam(required = false) String orderSn,
            @RequestParam(required = false) Integer state,
            @RequestParam(required = false) @DateTimeFormat(pattern = Constants.DATE_TIME_FORMAT) LocalDateTime beginTime,
            @RequestParam(required = false) @DateTimeFormat(pattern = Constants.DATE_TIME_FORMAT) LocalDateTime endTime,
            @RequestParam(required = false, defaultValue = "1") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        ReturnObject ret = orderService.customerGetAllSimpleOrders(loginUser, orderSn, state, beginTime, endTime, page, pageSize);
        return Common.decorateReturnObject(ret);
    }

//    /**
//     * Order Api 4
//     * @Author: 潘越
//     * @Sn: 22920192204259
//     * 买家查询订单完整信息（普通，团购，预售）。
//     * @param id
//     * @return
//     */
//    @ApiOperation(value = "买家查询订单完整信息（普通，团购，预售）。")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name="authorization", value="Token", required = true, dataType="String", paramType="header"),
//            @ApiImplicitParam(name="id", value = "订单id",required = true, dataType="Long", paramType="path")
//    })
//    @ApiResponses({
//            @ApiResponse(code = 0, message = "成功"),
//    })
//    @Audit(departName = "orders")
//    @GetMapping(value = "/orders/{id}")
//    public Object customerGetOrderById(@PathVariable("id") Long id){
//        ReturnObject ret=orderService.customerGetOrderById(id);
//    }

    /**
     * Order Api 6
     *
     * @param id
     * @param loginUser
     * @param loginUserName
     * @return
     * @Author: 潘越
     * @Sn: 22920192204259
     * 买家逻辑删除本人名下的订单
     */
    @ApiOperation(value = "买家逻辑删除名下的订单", tags = "order")
    @ApiResponses(value = {
            @ApiResponse(code = 0, message = "成功"),
            @ApiResponse(code = 507, message = "当前状态禁止此操作")
    })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "Token", required = true, dataType = "String", paramType = "header"),
            @ApiImplicitParam(name = "id", value = "订单id", required = true, dataType = "Long", paramType = "path")
    })
    @DeleteMapping(value = "/orders/{id}")
    @Audit(departName = "orders")
    public Object customerDeleteOrder(@PathVariable("id") Long id, @LoginUser Long loginUser, @LoginName String loginUserName) {
        ReturnObject ret = orderService.customerDeleteOrder(id, loginUser, loginUserName);
        return Common.decorateReturnObject(ret);
    }

    /**
     * Order Api 8
     *
     * @Author: 潘越
     * @Sn: 22920192204259
     * 买家标记确认收货
     */
    @ApiOperation(value = "买家标记确认收货")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization ", value = "token", required = true, dataType = "String", paramType = "header"),
            @ApiImplicitParam(name = "id", value = "订单id", required = true, dataType = "Integer", paramType = "path")
    })
    @ApiResponses({
            @ApiResponse(code = 0, message = "成功"),
            @ApiResponse(code = 507, message = "当前状态禁止操作")
    })
    @Audit(departName = "orders")
    @PutMapping("/orders/{id}/confirm")
    public Object confirmOrder(@PathVariable("id") Long id, @LoginUser Long loginUser, @LoginName String loginUserName) {
        ReturnObject ret = orderService.customerConfirmOrder(id, loginUser, loginUserName);
        return Common.decorateReturnObject(ret);
    }

    /**
     * Order Api 10
     *
     * @param id
     * @param shopId
     * @param loginUser
     * @param loginUserName
     * @param OrderMessageVo
     * @param bindingResult
     * @return
     * @Author 潘越
     * @Sn: 22920192204259
     * 店家修改订单 (留言)。
     */
    @ApiOperation(value = "店家修改订单 (留言)。", produces = "application/json;charset=UTF-8")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization ", value = "token", required = true, dataType = "String", paramType = "header"),
            @ApiImplicitParam(name = "shopId", value = "商户id (店员只能查询本商铺)", required = true, dataType = "Integer", paramType = "path"),
            @ApiImplicitParam(name = "id", value = "指定订单id", required = true, dataType = "Integer", paramType = "path"),
            @ApiImplicitParam(paramType = "body", dataType = "Object", name = "body", value = "留言", required = true)
    })
    @ApiResponses({
            @ApiResponse(code = 0, message = "成功"),
            @ApiResponse(code = 507, message = "店铺无法修改该订单")
    })
    @Audit(departName = "orders")
    @PutMapping("/shops/{shopId}/orders/{id}")
    public Object ShopUpdateMessage(@PathVariable Long id, @PathVariable Long shopId,
                                    @LoginUser Long loginUser, @LoginName String loginUserName,
                                    @Validated @RequestBody OrderMessageVo OrderMessageVo, BindingResult bindingResult) {
        Object obj = Common.processFieldErrors(bindingResult, httpServletResponse);
        if (obj != null) {
            return obj;
        } else {
            ReturnObject ret = orderService.shopUpdateMessage(id, shopId, OrderMessageVo, loginUser, loginUserName);
            return Common.decorateReturnObject(ret);
        }
    }

    /**
     * Order Api 12
     *
     * @param id
     * @param shopId
     * @param loginUser
     * @param loginUserName
     * @param orderShipmentSnVo
     * @param bindingResult
     * @return
     * @Author 潘越
     * @Sn: 22920192204259
     * 店家对订单标记发货
     */

    @ApiOperation(value = "店家对订单标记发货", produces = "application/json;charset=UTF-8")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization ", value = "token", required = true, dataType = "String", paramType = "header"),
            @ApiImplicitParam(name = "shopId", value = "商户id (店员只能查询本商铺)", required = true, dataType = "Integer", paramType = "path"),
            @ApiImplicitParam(name = "id", value = "指定订单id", required = true, dataType = "Integer", paramType = "path"),
            @ApiImplicitParam(paramType = "body", dataType = "Object", name = "body", value = "指定发货资讯", required = true)
    })

    @ApiResponses({
            @ApiResponse(code = 0, message = "成功"),
            @ApiResponse(code = 507, message = "店铺无法修改该订单")
    })
    @Audit(departName = "orders")
    @PutMapping("/shops/{shopId}/orders/{id}/deliver")
    public Object postfreights(@PathVariable Long id, @PathVariable Long shopId,
                               @LoginUser Long loginUser, @LoginName String loginUserName,
                               @Validated @RequestBody OrderShipmentSnVo orderShipmentSnVo, BindingResult bindingResult) {
        Object obj = Common.processFieldErrors(bindingResult, httpServletResponse);
        if (obj != null) {
            return obj;
        } else {
            ReturnObject ret = orderService.postfreights(id, shopId, orderShipmentSnVo, loginUser, loginUserName);
            return Common.decorateReturnObject(ret);
        }
    }

    /**
     * Order Api 14
     * @param id
     * @param loginUser
     * @return
     * @Author 潘越
     * @Sn: 22920192204259
     * 查询自己订单的退款信息
     */
    @ApiOperation(value = "查询自己订单的退款信息", produces = "application/json;charset=UTF-8")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization ", value = "token", required = true, dataType = "String", paramType = "header"),
            @ApiImplicitParam(name = "id", value = "指定订单id", required = true, dataType = "Integer", paramType = "path")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 0, message = "成功"),
            @ApiResponse(code = 507, message = "当前状态禁止操作")
    })
    @Audit(departName = "orders")
    @GetMapping(value = "/orders/{id}/refund")
    public Object getOrderRefund(@PathVariable Long id, @LoginUser Long loginUser) {
        ReturnObject ret = orderService.getOrderRefund(loginUser, id);
        return Common.decorateReturnObject(ret);
    }

    /**
     * 内部api 自定义1
     * @param state
     * @param id
     * @param loginUser
     * @param loginUserName
     * @return
     * @Author 潘越
     * @Sn 22920192204259
     * 修改订单状态，可任意
     */
    @ApiOperation(value = "修改订单状态", produces = "application/json;charset=UTF-8")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization ", value = "token", required = true, dataType = "String", paramType = "header"),
            @ApiImplicitParam(name = "id", value = "指定订单id", required = true, dataType = "Integer", paramType = "path"),
            @ApiImplicitParam(paramType = "query", dataType = "Integer", name = "state", value = "目标状态", required = true)
    })
    @ApiResponses(value = {
            @ApiResponse(code = 0, message = "成功"),
            @ApiResponse(code = 507, message = "当前状态禁止操作")
    })
    @Audit(departName = "orders")
    @PutMapping(value = "/internal/orders/{id}/states")
    public Object UpdateAnyState(@RequestParam(required = true) Integer state, @PathVariable Long id,
                                 @LoginUser Long loginUser, @LoginName String loginUserName) {
        ReturnObject ret = orderService.UpdateAnyState(id, state, loginUser, loginUserName);
        return Common.decorateReturnObject(ret);
    }
}