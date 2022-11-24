package icu.javacg.service;

import com.baomidou.mybatisplus.extension.service.IService;
import icu.javacg.pojo.User;

import java.util.List;

public interface UserService extends IService<User> {

    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    List<User> login(String username, String password);

    /**
     * 注册
     * @param username
     * @param password
     * @param email
     * @return
     */
    Boolean register(String username, String password, String email);

    /**
     * 修改
     * @param username
     * @param password
     * @param email
     * @return
     */
    Boolean update(Integer uid, String username, String password, String email);

    /**
     * 删除
     * @param uid
     * @return
     */
    Boolean delete(Integer uid);
}
