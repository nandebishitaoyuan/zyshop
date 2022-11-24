package icu.javacg.zyshop;

import icu.javacg.mapper.CommodityMapper;
import icu.javacg.mapper.OrderGoodsMapper;
import icu.javacg.pojo.Commodity;
import icu.javacg.pojo.OrderGoods;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TestMapper {
    @Autowired
    CommodityMapper commodityMapper;

    @Autowired
    OrderGoodsMapper orderGoodsMapper;
    @Autowired
    Commodity commodity;
    @Test
    public void testCommodity() throws Exception {
        List<Commodity> allCommodity = commodityMapper.getAllCommodity();
        allCommodity.forEach(System.out::println);
    }
    @Test
    public void testCommodity2() throws Exception {
        commodity.setGname("时间简史");
        List<Commodity> commodityList = commodityMapper.getCommodityByCondition(commodity);
        commodityList.forEach(System.out::println);
    }

    @Test
    public void testCommodity3() throws Exception {
        commodity.setGid(807200011);
        commodity.setGname("时间简史2");
        Integer commodityList = commodityMapper.updateCommodity(commodity);
        System.out.println(commodityList);
        testCommodity();
    }

    @Test
    public void testCommodity4() throws Exception {
        List<Commodity> commodityList = commodityMapper.getCommodityByName("功");
        commodityList.forEach(System.out::println);
    }

    @Test
    public void testOrderGoodsMapper1() throws Exception {
        List<OrderGoods> orderGoods = orderGoodsMapper.selectList(null);
        orderGoods.forEach(System.out::println);
    }

    @Test
    public void testOrderGoodsMapper2() throws Exception {
        List<OrderGoods> orderGoodsInfo = orderGoodsMapper.getOrderGoodsInfo(10003);
        for (int i = 0; i < orderGoodsInfo.size(); i++) {
            OrderGoods orderGoods = orderGoodsInfo.get(i);
            System.out.println(orderGoods.getCommodity().getGname());
        }
//        orderGoodsInfo.forEach(System.out::println);
    }
}
