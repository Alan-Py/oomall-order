package cn.edu.xmu.oomall.order.dao;

import cn.edu.xmu.oomall.order.mapper.OrderPoMapper;
import cn.edu.xmu.oomall.order.model.bo.Order;
import cn.edu.xmu.oomall.order.model.po.OrderPo;
import cn.edu.xmu.oomall.order.model.po.OrderPoExample;
import cn.edu.xmu.privilegegateway.annotation.util.ReturnObject;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static cn.edu.xmu.privilegegateway.annotation.util.Common.cloneVo;
import static cn.edu.xmu.privilegegateway.annotation.util.Common.setPoModifiedFields;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
class OrderDaoTest {

    @Autowired
    OrderDao orderDao;
    @Autowired
    OrderPoMapper orderPoMapper;
    @Test
    void customerGetAllSimpleOrders() {
        //通过example进行查询
        OrderPoExample example = new OrderPoExample();
        OrderPoExample.Criteria criteria=example.createCriteria();
        criteria.andIdEqualTo(2400L);
        var a = orderDao.customerGetAllSimpleOrders(example,1,5);
        List<OrderPo> orderPos = (List<OrderPo>) a.getData();
        System.out.println(orderPos.get(0).toString());
        System.out.println(a.getCode());
        System.out.println(a.getErrmsg());
    }
    @Test
    void select(){
        OrderPoExample example=new OrderPoExample();
        OrderPoExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(2400L);
        List<OrderPo> orderPos = orderPoMapper.selectByExample(example);
        System.out.println(orderPos.get(0));
    }

    //测试orderDao.updateOrderIsDeleted以及对应service
    @Test
    void TestUpdate(){
        Order order =(Order) orderDao.getOrderById(2401L).getData();
        setPoModifiedFields(order, 1, "admin");
        System.out.println(order.getState());
        System.out.println(Order.State.COMPLETED.getCode());
        if(order.getState().equals(Order.State.COMPLETED.getCode()) || order.getState().equals(Order.State.CANCELED.getCode())){
            System.out.println("HHHHHHHHH");
            order.setBeDeleted((byte)1);
//            System.out.println("before" + order);
//            OrderPo orderPo = (OrderPo) cloneVo(order, OrderPo.class);
//            int ret = orderPoMapper.updateByPrimaryKeySelective(orderPo);
//            var a = orderDao.getOrderById(2401L).getCode();
//            var b = orderDao.getOrderById(2401L).getErrmsg();
//            order =(Order) orderDao.getOrderById(2401L).getData();
//            System.out.println("after" + order);
//            System.out.println("code" + a);
//            System.out.println("errmsg" + b);
            ReturnObject ret = orderDao.updateOrderIsDeleted(order);
            System.out.println(ret.getCode() + ret.getErrmsg() + ret.getData());

        }else {
            System.out.println("NNNNNNNN");
        }
//        var c = new ReturnObject();
//        System.out.println(c.getCode()+c.getErrmsg()+c.getData());
    }

    /**
     * 内部api 自定义
     * @return
     * @Author 潘越
     * @Sn 22920192204259
     * 修改订单状态，可任意
     */
    @Test
    void UpdateAnyState(){
        Order order = orderDao.getOrderById(2401L).getData();
        System.out.println(order.toString());
        setPoModifiedFields(order, 1L, "admin");
        order.setState(101);
        ReturnObject ret = orderDao.updateOrderState(order);
        System.out.println(order.toString());
        System.out.println(ret.getCode()+ret.getErrmsg());
    }

    /**
     * Order Api 10
     * @Author 潘越
     * @Sn: 22920192204259
     * 店家修改订单 (留言)
     * @return
     */
    @Test
    void shopUpdateMessage(){
        Order order = new Order();
        order.setId(2401L);
        order.setShopId(2L);
        order.setMessage("HHHHH");
        setPoModifiedFields(order, 1, "admin");
        ReturnObject ret = orderDao.updateOrderMessage(2401L, order);
        System.out.println(ret.getCode()+ret.getErrmsg()+ret.getData());
    }
}