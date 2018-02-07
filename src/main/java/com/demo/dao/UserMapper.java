package com.demo.dao;

import com.demo.bean.User;
import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface UserMapper extends ApplicationMapper<User> {
    User getUserById(String id);

    User getUserByUserName(String userName);

    int saveUser(User user);

    int updateUserByUserName(User user);
}
