package icu.javacg.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import icu.javacg.mapper.CommodityMapper;
import icu.javacg.mapper.OrderGoodsMapper;
import icu.javacg.pojo.Commodity;
import icu.javacg.pojo.OrderGoods;
import icu.javacg.service.OrderGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OrderGoodsServiceImpl extends ServiceImpl<OrderGoodsMapper,OrderGoods> implements OrderGoodsService {

    @Autowired
    OrderGoodsMapper orderGoodsMapper;

    @Autowired
    CommodityMapper commodityMapper;

    @Override
    public List<OrderGoods> getOrderGoodsByUid(Integer uid) {
        return orderGoodsMapper.getOrderGoodsInfo(uid);
    }

    @Override
    public Boolean OrderGoodsQuantity(Integer gid, Integer uid, Integer addOrSubtract) {
        QueryWrapper<OrderGoods> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("gid", gid).eq("uid", uid);
        OrderGoods orderGoods = getOne(queryWrapper);
        Commodity commodity = commodityMapper.selectById(gid);
        if (orderGoods.getOgamount() <= 0) {
            return false;
        } else {
            if (addOrSubtract == 1) {
                orderGoods.setOgamount(orderGoods.getOgamount() + 1);
                orderGoods.setOgtotalprice(orderGoods.getOgtotalprice() + commodity.getGprice());
            } else if (addOrSubtract == 0){
                orderGoods.setOgamount(orderGoods.getOgamount() - 1);
                orderGoods.setOgtotalprice(orderGoods.getOgtotalprice() - commodity.getGprice());
                if (orderGoods.getOgamount() <= 0){
                    UpdateWrapper<OrderGoods> delete = new UpdateWrapper<>();
                    delete.eq("ogid", orderGoods.getOgid());
                    orderGoodsMapper.delete(delete);
                }
            }
            UpdateWrapper<OrderGoods> updateWrapper = new UpdateWrapper<>();
            updateWrapper.eq("ogid", orderGoods.getOgid());
            update(orderGoods, updateWrapper);
            return true;
        }
    }
}
