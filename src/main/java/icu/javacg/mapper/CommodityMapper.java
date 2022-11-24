package icu.javacg.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import icu.javacg.pojo.Commodity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface CommodityMapper extends BaseMapper<Commodity> {

    List<Commodity> getAllCommodity();

    List<Commodity> getCommodityByCondition(@Param("commodity") Commodity commodity);

    List<Commodity> getCommodityByName(@Param("name") String name);

    Integer updateCommodity(@Param("commodity") Commodity commodity);
}
