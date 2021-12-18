package cn.edu.xmu.oomall.order.service;

import cn.edu.xmu.oomall.order.dao.OrderDao;
import cn.edu.xmu.oomall.order.microservice.GroupOnActivityService;
import cn.edu.xmu.oomall.order.microservice.PaymentService;
import cn.edu.xmu.oomall.order.microservice.ShopFeignService;
import cn.edu.xmu.oomall.order.microservice.vo.GroupOnActivityVo;
import cn.edu.xmu.oomall.order.microservice.vo.GroupOnStrategyVo;
import cn.edu.xmu.oomall.order.microservice.vo.RefundInfoVo;
import cn.edu.xmu.oomall.order.model.bo.Order;
import cn.edu.xmu.oomall.order.model.po.OrderPoExample;
import cn.edu.xmu.oomall.order.model.vo.*;
//import cn.edu.xmu.oomall.order.microservice.ShopFeignService;
import cn.edu.xmu.privilegegateway.annotation.util.Common;
import cn.edu.xmu.privilegegateway.annotation.util.ReturnNo;
import cn.edu.xmu.privilegegateway.annotation.util.ReturnObject;
import com.github.pagehelper.PageInfo;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;


import javax.annotation.Resource;

import static cn.edu.xmu.privilegegateway.annotation.util.Common.setPoModifiedFields;

@Service
public class OrderService {
    @Autowired
    private OrderDao orderDao;

//    @Autowired
//    private PaymentService paymentService;
//
//
//    @Resource
//     private ShopFeignService shopFeignService;
    @Resource
    private GroupOnActivityService groupOnActivityService;

    @Transactional(readOnly = true, rollbackFor = Exception.class)
    public ReturnObject<Order> getOrderByOrderId(Long OrderId) {
        return orderDao.getOrderById(OrderId);
    }

    /**
     * Order Api 1
     *
     * @Author: zyz
     * @Sn: 22920192204338
     * 获取订单的所有状态
     */
    @Transactional(readOnly = true, rollbackFor = Exception.class)
    public ReturnObject getOrderStates() {
        return orderDao.getOrderState();
    }


    //    @Transactional(rollbackFor = Exception.class)
//    public ReturnObject addOrder(NewNormalOrderPostVo body, Long createBy, String createName) {
//
//    }

//    /**
//     * Order Api 5
//     *
//     * @Author: zyz
//     * @Sn: 22920192204338
//     * 买家修改本人名下订单
//     * @param id
//     * @param modifyOrderVo
//     * @param loginUser
//     * @param loginUserName
//     * @return
//     */
//    @Transactional(rollbackFor = Exception.class)
//    public ReturnObject updateOrder(Long id, ModifyOrderVo modifyOrderVo, Long loginUser, String loginUserName) {
//        Order order = orderDao.getOrderById(id).getData();
//        setPoModifiedFields(order, loginUser, loginUserName);
//        if (order.getState().equals(Order.State.COMPLETED.getCode()) ||
//            order.getState().equals(Order.State.CANCELED.getCode()) ||
//            order.getState().equals(Order.State.SHIPPED.getCode())) {
//            return new ReturnObject(ReturnNo.STATENOTALLOW);
//        }
//        else {
//            Long originalRegionId = order.getRegionId();
//            Long curRegionId = modifyOrderVo.getRegionId();
//            order.setRegionId(curRegionId);
//            Double originalFreight = 0.0;
//            Double curFreight = 0.0;
//            if (originalFreight != curFreight)
//                return new ReturnObject(ReturnNo.ORDER_CHANGENOTALLOW);
//            else {
//                order.setRegionId(curRegionId);
//                ReturnObject ret = orderDao.updateOrderRegionId(order);
//                return ret;
//            }
//        }
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
    @Transactional(rollbackFor = Exception.class)
    public ReturnObject cancelOrder(Long id, Long loginUser, String loginUserName) {
        Order order = orderDao.getOrderById(id).getData();
        setPoModifiedFields(order, loginUser, loginUserName);

        if (!order.getState().equals(Order.State.COMPLETED.getCode())) {
            order.setState(Order.State.CANCELED.getCode());
            ReturnObject ret = orderDao.updateOrderState(order);
            return ret;
        } else return new ReturnObject(ReturnNo.STATENOTALLOW);
    }

    /**
     * Order Api 15
     *
     * @Author: zyz
     * @Sn: 22920192204338
     * 确认团购订单
     * @param orderId
     * @param shopId
     * @param loginUser
     * @param loginUserName
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public ReturnObject confirmGroupOrders(Long orderId, Long shopId, Long loginUser, String loginUserName) {
        Order order = orderDao.getOrderById(orderId).getData();
        setPoModifiedFields(order, loginUser, loginUserName);

        Long GrouponId = order.getGrouponId();
        ReturnObject groupOnActivity = groupOnActivityService.getOnlineGroupOnActivity(GrouponId);
        GroupOnActivityVo groupOrders = (GroupOnActivityVo) groupOnActivity.getData();
        if (shopId.longValue() != groupOrders.getShopId()) {
            return new ReturnObject(ReturnNo.RESOURCE_ID_OUTSCOPE);
        }
        List<GroupOnStrategyVo> strategy = groupOrders.getStrategy();
        for (GroupOnStrategyVo item: strategy) {
        }

        order.setState(Order.State.PAYMENT_COMPLETED.getCode());
        var x = getOrderByOrderId(orderId).getData();
        if (x.getState() == Order.State.PENDING_GROUPING.getCode().byteValue()) {
            ReturnObject ret = orderDao.updateOrderState(order);
            return ret;
        }
        else return new ReturnObject(ReturnNo.STATENOTALLOW);
    }

    /**
     * Order Api 2
     *
     * @param loginUser 用户ID
     * @param orderSn   订单编号
     * @param state     订单状态
     * @param beginTime 订单开始时间
     * @param endTime   订单结束时间
     * @param pageNum   页码
     * @param pageSize  页规格
     * @return
     * @Author: 潘越
     * @Sn: 22920192204259
     * 买家查看查询名下的订单(概要)
     * 根据条件查询订单
     */
    @Transactional(readOnly = true, rollbackFor = Exception.class)
    public ReturnObject customerGetAllSimpleOrders(Long loginUser, String orderSn, Integer state,
                                                   LocalDateTime beginTime, LocalDateTime endTime,
                                                   Integer pageNum, Integer pageSize) {
        //通过example进行查询
        OrderPoExample example = new OrderPoExample();
        OrderPoExample.Criteria criteria = example.createCriteria();
        criteria.andBeDeletedNotEqualTo((byte) 1);//暂时以1表示被删除，表示0存在
        example.setOrderByClause("gmt_create DESC");
        if (loginUser != null) {
            criteria.andCustomerIdEqualTo(loginUser);
        }
        if (orderSn != null) {
            criteria.andOrderSnEqualTo(orderSn);
        }
        if (state != null) {
            criteria.andStateEqualTo(state);
        }
        if (beginTime != null) {
            criteria.andGmtCreateGreaterThan(beginTime);
        }
        if (endTime != null) {
            criteria.andGmtCreateLessThan(endTime);
        }
        return orderDao.customerGetAllSimpleOrders(example, pageNum, pageSize);
    }

    /**
     * Order Api 4
     * @Author: 潘越
     * @Sn: 22920192204259
     * 买家查询订单完整信息（普通，团购，预售）。
     * @param id
     * @return
     */
    public ReturnObject customerGetOrderById(Long id) {

    }

    /**
     * Order Api 6
     * @Author: 潘越
     * @Sn: 22920192204259
     * 买家逻辑删除本人名下的订单
     * @param id
     * @param loginUser
     * @param loginUserName
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public ReturnObject customerDeleteOrder(Long id, Long loginUser, String loginUserName) {
        Order order = orderDao.getOrderById(id).getData();
        setPoModifiedFields(order, loginUser, loginUserName);
        if (order.getState().equals(Order.State.COMPLETED.getCode()) || order.getState().equals(Order.State.CANCELED.getCode())) {
            order.setBeDeleted((byte) 1);//暂时以1表示被删除，表示0存在
            ReturnObject ret = orderDao.updateOrderIsDeleted(order);
            return ret;
        } else return new ReturnObject(ReturnNo.STATENOTALLOW);
    }

    /**
     * Order Api 8
     *
     * @param id
     * @param loginUser
     * @param loginUserName
     * @return
     * @Author 潘越
     * @Sn: 22920192204259
     * 买家标记确认收货
     */
    @Transactional(rollbackFor = Exception.class)
    public ReturnObject customerConfirmOrder(Long id, Long loginUser, String loginUserName) {
        Order order = orderDao.getOrderById(id).getData();
        setPoModifiedFields(order, loginUser, loginUserName);
        if (order.getState().equals(Order.State.PENDING_DELIVERY.getCode())) {
            order.setState(Order.State.COMPLETED.getCode());
            ReturnObject ret = orderDao.updateOrderState(order);
            return ret;
        } else return new ReturnObject(ReturnNo.STATENOTALLOW);
    }

    /**
     * Order Api 9
     *
     * @param loginUser
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
    @Transactional(readOnly = true, rollbackFor = Exception.class)
    public ReturnObject shopGetAllSimpleOrders(Long loginUser, Long shopId, Long customerId, String orderSn, LocalDateTime beginTime, LocalDateTime endTime, Integer page, Integer pageSize) {
        OrderPoExample example = new OrderPoExample();
        OrderPoExample.Criteria criteria = example.createCriteria();
        example.setOrderByClause("gmt_create DESC");
        if (loginUser != null) {
            criteria.andIdEqualTo(loginUser);
        }
        if (shopId != null) {
            criteria.andShopIdEqualTo(shopId);
        }
        if (customerId != null) {
            criteria.andCustomerIdEqualTo(customerId);
        }
        if (orderSn != null) {
            criteria.andOrderSnEqualTo(orderSn);
        }
        if (beginTime != null) {
            criteria.andGmtCreateGreaterThan(beginTime);
        }
        if (endTime != null) {
            criteria.andGmtCreateLessThan(endTime);
        }
        return orderDao.shopGetAllSimpleOrders(example, page, pageSize);
    }

    /**
     * Order Api 10
     *
     * @param id
     * @param shopId
     * @param orderMessageVo
     * @param loginUser
     * @param loginUserName
     * @return
     * @Author 潘越
     * @Sn: 22920192204259
     * 店家修改订单 (留言)
     */
    @Transactional(rollbackFor = Exception.class)
    public ReturnObject shopUpdateMessage(Long id, Long shopId, OrderMessageVo orderMessageVo,
                                          Long loginUser, String loginUserName) {
        Order order = new Order();
        order.setId(id);
        order.setShopId(shopId);
        order.setMessage(orderMessageVo.getMessage());
        setPoModifiedFields(order, loginUser, loginUserName);
        ReturnObject ret = orderDao.updateOrderMessage(id, order);
        return ret;
    }


    /**
     * 内部api 自定义1
     *
     * @param id
     * @param loginUser
     * @param loginUserName
     * @return
     * @Author 潘越
     * @Sn 22920192204259
     * 修改订单状态，可任意
     */
    @Transactional(rollbackFor = Exception.class)
    public ReturnObject UpdateAnyState(Long id, Integer state, Long loginUser, String loginUserName) {
        if (orderDao.getOrderById(id).getData() != null) {
            Order order = orderDao.getOrderById(id).getData();
            setPoModifiedFields(order, loginUser, loginUserName);
            order.setState(state);
            ReturnObject ret = orderDao.updateOrderState(order);
            return ret;
        } else {
            return new ReturnObject(ReturnNo.STATENOTALLOW);
        }
    }

    /**
     * Order Api 12
     * @Author 潘越
     * @Sn 22920192204259
     * 店家对订单标记发货
     * @param id
     * @param shopId
     * @param orderShipmentSnVo
     * @param loginUser
     * @param loginUserName
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public ReturnObject postfreights(Long id, Long shopId, OrderShipmentSnVo orderShipmentSnVo, Long loginUser, String loginUserName) {
        if (orderDao.getOrderById(id).getData() != null) {
            Order order = orderDao.getOrderById(id).getData();
            setPoModifiedFields(order, loginUser, loginUserName);
            order.setState(Order.State.SHIPPED.getCode());
            order.setShipmentSn(orderShipmentSnVo.getShipmentSn());
            ReturnObject ret = orderDao.postfreights(id,order);
            return ret;
        } else {
            return new ReturnObject(ReturnNo.STATENOTALLOW);
        }
    }

    /**
     * Order Api 13
     * @Author: zyz
     * @Sn: 22920192204338
     * 获得自己订单的支付信息
     * @param orderId
     * @param loginUser
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public ReturnObject getOrderPayment(Long orderId, Long loginUser) {
        ReturnObject retOrder = getOrderByOrderId(orderId);
        if (retOrder.getData() == null) {
            return new ReturnObject(ReturnNo.RESOURCE_ID_NOTEXIST, "订单不存在");
        }
        Order order = (Order) retOrder.getData();
        String orderSn = order.getOrderSn();
        if (!order.getId().equals(orderId)) {
            return new ReturnObject(ReturnNo.RESOURCE_ID_OUTSCOPE);
        }


        return null;
    }

//    /**
//     * Order Api 14
//     * @Author 潘越
//     * @Sn: 22920192204259
//     * 查询自己订单的退款信息
//     * @param loginUser
//     * @param id
//     * @return
//     */
//    public ReturnObject getOrderRefund(Long loginUser, Long id) {
//        ReturnObject retOrder = getOrderByOrderId(id);
//        if(retOrder.getData()==null){
//            return new ReturnObject(ReturnNo.RESOURCE_ID_NOTEXIST,"订单不存在");
//        }
//        Order order = (Order) retOrder.getData();
//        String orderSn = order.getOrderSn();
//        if(order.getId()!=id){
//            return new ReturnObject(ReturnNo.RESOURCE_ID_OUTSCOPE);
//        }
//        ReturnObject retRefund = paymentService.getRefundByExample(loginUser,0L,orderSn, null,null,null,1,10);
//        if((((PageInfo<RefundInfoVo>)retRefund.getData()).getTotal())==0){
//            return new ReturnObject(ReturnNo.RESOURCE_ID_NOTEXIST,"退款不存在");
//        }
//        List<RefundInfoVo> refundInfoVos = ((PageInfo<RefundInfoVo>) retRefund.getData()).getList();
//        RefundInfoVo retVo = Common.cloneVo(refundInfoVos.get(0), RefundInfoVo.class);
//        return new ReturnObject(retVo);
//    }
}