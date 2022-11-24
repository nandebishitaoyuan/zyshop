package icu.javacg.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import icu.javacg.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Mapper
public interface UserMapper extends BaseMapper<User> {

    /**
     * 查询全部用户
     * @return
     */
    List<User> getAllUser();

    /**
     * 条件查询用户
     * @return
     */
    List<User> getUserByCondition(@Param("user") User user);

    /**
     * 修改用户
     * @param user
     * @return
     */
    Integer updateUser(@Param("user") User user);

    /**
     * 通过id删除用户
     * @param uid
     * @return
     */
    Integer deleteUser(@Param("uid") Integer uid);

    /**
     * 增加用户
     * @param user
     * @return
     */
    Integer insetUser(@Param("user") User user);
}
