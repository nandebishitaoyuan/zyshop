package icu.javacg.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import icu.javacg.pojo.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;
import java.util.List;

@Mapper
public interface OrderMapper extends BaseMapper<Order> {

}
