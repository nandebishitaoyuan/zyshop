package icu.javacg.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import icu.javacg.pojo.OrderGoods;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderGoodsMapper extends BaseMapper<OrderGoods> {

    /**
     * 通过用户名获取该用户的购物车列表
     * @param uid
     * @return
     */
    List<OrderGoods> getOrderGoodsInfo(@Param("uid") Integer uid);
}
