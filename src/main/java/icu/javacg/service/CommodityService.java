package icu.javacg.service;


import com.baomidou.mybatisplus.extension.service.IService;
import icu.javacg.mapper.CommodityMapper;
import icu.javacg.pojo.Commodity;

import java.util.List;

public interface CommodityService extends IService<Commodity> {

    /**
     * 查询全部商品
     * @return
     */
    List<Commodity> allCommodity();

    /**
     * 通过名字来查询商品
     * @param name
     * @return
     */
    List<Commodity> getCommodityByName(String name);

    /**
     * 通过ID来查询商品
     * @param id
     * @return
     */
    Commodity getCommodityById(Integer id);

    /**
     * 通过ID增加或删除商品库存
     * @param id
     * @return
     */
    Boolean updateCommodity(Integer id, Boolean AddOrSubtract);

    /**
     *通过uid和gid给当前用户添加商品进购物车
     * @param uid
     * @param gid
     * @return
     */
    void addOrder(Integer uid, Integer gid);
}
