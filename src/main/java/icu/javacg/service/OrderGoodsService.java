package icu.javacg.service;

import com.baomidou.mybatisplus.extension.service.IService;
import icu.javacg.pojo.OrderGoods;

import java.util.List;

public interface OrderGoodsService extends IService<OrderGoods> {

    List<OrderGoods> getOrderGoodsByUid(Integer uid);

    /**
     * 修改购物车商品数量
     * @param gid
     * @param uid
     * @param addOrSubtract 1==加 0==减
     * @return
     */
    Boolean OrderGoodsQuantity(Integer gid, Integer uid, Integer addOrSubtract);

}
