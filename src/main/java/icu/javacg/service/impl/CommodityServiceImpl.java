package icu.javacg.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import icu.javacg.mapper.CommodityMapper;
import icu.javacg.mapper.OrderGoodsMapper;
import icu.javacg.pojo.Commodity;
import icu.javacg.pojo.OrderGoods;
import icu.javacg.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CommodityServiceImpl extends ServiceImpl<CommodityMapper,Commodity> implements CommodityService {

    @Autowired
    CommodityMapper commodityMapper;

    @Autowired
    OrderGoodsMapper orderGoodsMapper;

    @Override
    public List<Commodity> allCommodity() {
        return commodityMapper.selectList(null);
    }

    @Override
    public List<Commodity> getCommodityByName(String name) {
        Map<String, Object> map = new HashMap<>();
        map.put("gname",name);
        return commodityMapper.selectByMap(map);
    }

    @Override
    public Commodity getCommodityById(Integer id) {
        return commodityMapper.selectById(id);
    }

    @Override
    public Boolean updateCommodity(Integer id, Boolean addOrSubtract) {
        Commodity commodity = commodityMapper.selectById(id);
        if (addOrSubtract){
            commodity.setGamount(commodity.getGamount() + 1);
        }else {
            commodity.setGamount(commodity.getGamount() - 1);
        }
        return commodityMapper.updateById(commodity) > 0;
    }

    @Override
    public void addOrder(Integer uid, Integer gid) {
        QueryWrapper<OrderGoods> queryWrapper = new QueryWrapper<>();
        Commodity commodity = commodityMapper.selectById(gid);
        queryWrapper.eq("uid", uid).eq("gid", gid);
        OrderGoods orderGoods = orderGoodsMapper.selectOne(queryWrapper);
        if (orderGoods != null) {
            orderGoods.setOgamount(orderGoods.getOgamount() + 1);
            orderGoods.setOgtotalprice(orderGoods.getOgtotalprice() + commodity.getGprice());
            commodity.setGamount(commodity.getGamount() -1);
            orderGoodsMapper.updateById(orderGoods);
        }else {
            OrderGoods temp = new OrderGoods();
            temp.setOid(3);
            temp.setUid(uid);
            temp.setGid(gid);
            temp.setOgamount(1);
            temp.setOgtotalprice(commodity.getGprice());
            commodity.setGamount(commodity.getGamount() -1);
            orderGoodsMapper.insert(temp);
        }
        commodityMapper.updateById(commodity);
    }
}
