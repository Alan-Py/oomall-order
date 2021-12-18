package cn.edu.xmu.oomall.order.dao;

import cn.edu.xmu.oomall.order.mapper.OrderPoMapper;
import cn.edu.xmu.oomall.order.model.bo.Order;
import cn.edu.xmu.oomall.order.model.po.OrderPo;
import cn.edu.xmu.oomall.order.model.po.OrderPoExample;
import cn.edu.xmu.oomall.order.model.vo.PageInfoVo;
import cn.edu.xmu.oomall.order.model.vo.SimpleOrderRetVo;
import cn.edu.xmu.privilegegateway.annotation.util.Common;
import cn.edu.xmu.privilegegateway.annotation.util.ReturnNo;
import cn.edu.xmu.privilegegateway.annotation.util.ReturnObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import static cn.edu.xmu.privilegegateway.annotation.util.Common.cloneVo;

import java.awt.color.ICC_Profile;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

@Repository
public class OrderDao {
    @Autowired
    private OrderPoMapper orderPoMapper;

    public ReturnObject<Order> getOrderById(Long id) {
        OrderPo orderPo;
        try {
            orderPo = orderPoMapper.selectByPrimaryKey(id);
            Order order = (Order) cloneVo(orderPo, Order.class);
            return new ReturnObject<>(order);
        } catch (Exception e) {
            return new ReturnObject<>(ReturnNo.INTERNAL_SERVER_ERR);
        }

    }

    /**
     * Order Api 1
     *
     * @return
     * @Author: zyz
     * @Sn: 22920192204338
     * 获取订单的所有状态
     */
    public ReturnObject getOrderState() {
        List<Map<String, Object>> stateList = new ArrayList<>();
        for (Order.State state : Order.State.values()) {
            Map<String, Object> temp = new HashMap<>();
            temp.put("code", state.getCode());
            temp.put("name", state.getDescription());
            stateList.add(temp);
        }
        return new ReturnObject<>(stateList);
    }



    /**
     * Order Api 7
     *
     * @param order
     * @return
     * @Author: zyz
     * @Sn: 22920192204388
     * 买家取消本人名下订单
     */
    public ReturnObject updateOrderState(Order order) {
        OrderPo orderPo = (OrderPo) cloneVo(order, OrderPo.class);
        int ret;
        try {
            ret = orderPoMapper.updateByPrimaryKeySelective(orderPo);
        } catch (Exception e) {
            return new ReturnObject<>(ReturnNo.INTERNAL_SERVER_ERR);
        }
        if (ret == 0) {
            return new ReturnObject(ReturnNo.FIELD_NOTVALID);
        } else return new ReturnObject();
    }

    /**
     * Order Api 2
     *
     * @param example
     * @param pageNum
     * @param pageSize
     * @return
     * @Author: 潘越
     * @Sn: 22920192204259
     * 买家查看查询名下的订单(概要)
     */
    public ReturnObject customerGetAllSimpleOrders(OrderPoExample example, Integer pageNum, Integer pageSize) {
        try {
            List<OrderPo> orderPos = new ArrayList<>();
            PageHelper.startPage(pageNum, pageSize);
            orderPos = orderPoMapper.selectByExample(example);
            var orderVos = new ArrayList<SimpleOrderRetVo>();
            for (var orderpo : orderPos) {
                orderVos.add((SimpleOrderRetVo) Common.cloneVo(orderpo, SimpleOrderRetVo.class));
            }
            var pageInfo = new PageInfo<>(orderVos);
            pageInfo.setPages(PageInfo.of(orderPos).getPages());
            pageInfo.setTotal(PageInfo.of(orderPos).getTotal());
            pageInfo.setPageNum(pageNum);
            pageInfo.setPageSize(pageSize);
            return new ReturnObject(new PageInfoVo<>(pageInfo));
        } catch (DataAccessException e) {
            return new ReturnObject<>(ReturnNo.RESOURCE_ID_NOTEXIST, e.getMessage());
        }
    }

    /**
     * Order Api 6
     *
     * @param order
     * @return
     * @Author: 潘越
     * @Sn: 22920192204259
     * 买家逻辑删除本人名下的订单
     */
    public ReturnObject updateOrderIsDeleted(Order order) {
        OrderPo orderPo = (OrderPo) cloneVo(order, OrderPo.class);
        int ret;
        try {
            ret = orderPoMapper.updateByPrimaryKeySelective(orderPo);
        } catch (Exception e) {
            return new ReturnObject<>(ReturnNo.INTERNAL_SERVER_ERR);
        }
        if (ret == 0) {
            return new ReturnObject(ReturnNo.FIELD_NOTVALID);
        } else return new ReturnObject();
    }

    /**
     * Order Api 9
     *
     * @param example
     * @param page
     * @param pageSize
     * @return
     * @Author: zyz
     * @Sn: 22920192204338
     * 店家查询商户所有订单(概要)
     */
    public ReturnObject shopGetAllSimpleOrders(OrderPoExample example, Integer page, Integer pageSize) {
        try {
            List<OrderPo> orderPos = new ArrayList<>();
            PageHelper.startPage(page, pageSize);
            orderPos = orderPoMapper.selectByExample(example);
            var orderVos = new ArrayList<SimpleOrderRetVo>();
            for (var orderPo : orderPos) {
                orderVos.add((SimpleOrderRetVo) Common.cloneVo(orderPo, SimpleOrderRetVo.class));
            }
            var pageInfo = new PageInfo<>(orderVos);
            pageInfo.setPages(PageInfo.of(orderPos).getPages());
            pageInfo.setTotal(PageInfo.of(orderPos).getTotal());
            pageInfo.setPageNum(page);
            pageInfo.setPageSize(pageSize);
            return new ReturnObject(new PageInfoVo<>(pageInfo));
        } catch (DataAccessException e) {
            return new ReturnObject<>(ReturnNo.RESOURCE_ID_NOTEXIST, e.getMessage());
        }
    }

    /**
     * Order Api 10
     *
     * @param id
     * @param order
     * @return
     * @Author 潘越
     * @Sn: 22920192204259
     * 店家修改订单 (留言)
     */
    public ReturnObject updateOrderMessage(Long id, Order order) {
        int ret;
        try {
            OrderPo orderPo = orderPoMapper.selectByPrimaryKey(id);

            orderPo.setMessage(order.getMessage());

            if (orderPo.getShopId().equals(order.getShopId())) {
                orderPo.setGmtModified(LocalDateTime.now());
                ret = orderPoMapper.updateByPrimaryKeySelective(orderPo);
            } else {
                return new ReturnObject(ReturnNo.STATENOTALLOW, "该订单不属于该商铺");
            }
        } catch (Exception e) {
            return new ReturnObject<>(ReturnNo.INTERNAL_SERVER_ERR);
        }
        if (ret == 0) {
            return new ReturnObject(ReturnNo.FIELD_NOTVALID);
        } else {
            return new ReturnObject();
        }
    }

    /**
     * Order Api 12
     *
     * @param order
     * @return
     * @Author 潘越
     * @Sn: 22920192204259
     * 店家对订单标记发货
     */
    public ReturnObject postfreights(Long id, Order order) {
        int ret;
        try {
            OrderPo orderPo = orderPoMapper.selectByPrimaryKey(id);
            if (orderPo.getState().equals(Order.State.PENDING_DELIVERY.getCode())) {
                if (orderPo.getShopId().equals(order.getShopId())) {
                    orderPo.setShipmentSn(order.getShipmentSn());
                    orderPo.setState(order.getState());
                    orderPo.setGmtModified(LocalDateTime.now());
                    ret = orderPoMapper.updateByPrimaryKeySelective(orderPo);
                } else {
                    return new ReturnObject(ReturnNo.STATENOTALLOW, "该订单不属于该商铺");
                }
            } else {
                return new ReturnObject(ReturnNo.STATENOTALLOW, "状态错误");
            }
        } catch (Exception e) {
            return new ReturnObject<>(ReturnNo.INTERNAL_SERVER_ERR);
        }
        if (ret == 0) {
            return new ReturnObject(ReturnNo.FIELD_NOTVALID);
        } else {
            return new ReturnObject();
        }
    }

    /**
     * Order Api 5
     *
     * @Author: zyz
     * @Sn: 22920192204338
     * 买家修改本人名下订单
     * @param order
     * @return
     */
    public ReturnObject updateOrderRegionId(Order order) {
        OrderPo orderPo = (OrderPo) cloneVo(order, OrderPo.class);
        int ret;
        try {
            ret = orderPoMapper.updateByPrimaryKeySelective(orderPo);
        } catch (Exception e) {
            return new ReturnObject<>(ReturnNo.INTERNAL_SERVER_ERR);
        }
        if (ret == 0) {
            return new ReturnObject(ReturnNo.FIELD_NOTVALID);
        } else return new ReturnObject();
    }
}