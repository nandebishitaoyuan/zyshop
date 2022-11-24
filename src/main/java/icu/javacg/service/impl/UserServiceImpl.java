package icu.javacg.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import icu.javacg.mapper.UserMapper;
import icu.javacg.pojo.User;
import icu.javacg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> login(String username, String password) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("uname", username).eq("upwd", password);
        return userMapper.selectList(queryWrapper);
    }

    @Override
    public Boolean register(String username, String password, String email) {
        List<User> allUser = userMapper.selectList(null);
        for (User user : allUser) {
            if (user.getUname().equals(username)) {
                return false;
            }
        }
        return userMapper.insert(new User(null, username, password, email)) > 0;
    }

    @Override
    public Boolean update(Integer uid, String username, String password, String email) {
        return userMapper.updateById(new User(uid, username, password, email)) > 0;
    }

    @Override
    public Boolean delete(Integer uid) {
        return userMapper.deleteById(uid) >0 ;
    }
}
