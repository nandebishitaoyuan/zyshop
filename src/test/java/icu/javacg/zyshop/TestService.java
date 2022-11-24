package icu.javacg.zyshop;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import icu.javacg.mapper.CommodityMapper;
import icu.javacg.mapper.OrderGoodsMapper;
import icu.javacg.pojo.Commodity;
import icu.javacg.pojo.OrderGoods;
import icu.javacg.service.CommodityService;
import icu.javacg.service.OrderGoodsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class TestService {

    @Autowired
    OrderGoodsService orderGoodsService;
    @Autowired
    CommodityService commodityService;

    @Autowired
    OrderGoodsMapper orderGoodsMapper;

    @Autowired
    CommodityMapper commodityMapper;

    @Test
    public void test7() {
        QueryWrapper<OrderGoods> queryWrapper = new QueryWrapper<>();
        Commodity commodity = commodityMapper.selectById(807200011);
        queryWrapper.eq("uid", 10003).eq("gid", 807200011);
        OrderGoods orderGoods = orderGoodsMapper.selectOne(queryWrapper);
        if (orderGoods != null) {
            orderGoods.setOgamount(orderGoods.getOgamount() + 1);
            orderGoods.setOgtotalprice(orderGoods.getOgtotalprice() + commodity.getGprice());
            commodity.setGamount(commodity.getGamount() -1);
            orderGoodsMapper.updateById(orderGoods);
        }else {
            OrderGoods temp = new OrderGoods();
            temp.setOid(3);
            temp.setUid(10003);
            temp.setGid(807200011);
            temp.setOgamount(1);
            temp.setOgtotalprice(commodity.getGprice());
            commodity.setGamount(commodity.getGamount() -1);
            orderGoodsMapper.insert(temp);
        }
        commodityMapper.updateById(commodity);
    }

    @Test
    public void test6() throws Exception {
        commodityService.addOrder(10003,807200011);
    }
    @Test
    public void testUpdate() throws Exception {
        Boolean aBoolean = commodityService.updateCommodity(807200009, true);
        System.out.println(aBoolean);
    }

    @Test
    public void testUpdate2() throws Exception {
        List<Commodity> commodityByCondition = commodityService.getCommodityByName("时间");
        commodityByCondition.forEach(System.out::println);
    }

    @Test
    public void testUpdate3() throws Exception {
        List<Commodity> commodities = commodityService.allCommodity();
        commodities.forEach(System.out::println);
    }

    @Test
    public void test1(){
        QueryWrapper<OrderGoods> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("uid",10003);
        List<OrderGoods> orderGoods = orderGoodsService.list(queryWrapper);
        orderGoods.forEach(System.out::println);
    }

    @Test
    public void test2(){
        List<Commodity> gids = new ArrayList<>();
        QueryWrapper<OrderGoods> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("uid",10003);
        List<OrderGoods> list = orderGoodsService.list(queryWrapper);
        for (int i = 0; i < list.size(); i++) {
            gids.add(commodityMapper.selectById(list.get(i).getGid()));
        }
        gids.forEach(System.out::println);
    }

    @Test
    public void test3(){
        List orderGoodsByUid = orderGoodsService.getOrderGoodsByUid(10003);
        Object o = orderGoodsByUid.get(0);
        Object o1 = orderGoodsByUid.get(1);
    }

    @Test
    public void test4(){
        List<OrderGoods> orderGoodsByUid = orderGoodsService.getOrderGoodsByUid(10036);
        orderGoodsByUid.forEach(System.out::println);
    }

    @Test
    public void test5(){
        QueryWrapper<OrderGoods> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("gid",807200002);
        OrderGoods orderGoods = orderGoodsService.getOne(queryWrapper);
        orderGoods.setOgamount(orderGoods.getOgamount()-1);
        UpdateWrapper<OrderGoods> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("ogid",orderGoods.getOgid());
        orderGoodsService.update(orderGoods, updateWrapper);
    }
}
