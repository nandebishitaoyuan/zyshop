package icu.javacg.zyshop;

import icu.javacg.mapper.OrderMapper;
import icu.javacg.pojo.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootTest
public class TestOrder {

    @Autowired
    OrderMapper orderMapper;
    @Autowired
    Order order;
    @Test
    public void testOrder() throws Exception {
        /*order.setUid(10003);
        List<Order> orderByUid = orderMapper.getOrderByUid(order);
        orderByUid.forEach(System.out::println);*/
    }
    @Test
    public void testOrder2() throws Exception {
       /* int i = orderMapper.deleteOrder(2);
        System.out.println(i);*/
    }

}
