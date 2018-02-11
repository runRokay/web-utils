package com.demo.service.impl;

import com.demo.bean.User;
import com.demo.dao.UserMapper;
import com.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
@Transactional(value = "txManager")
public class UserServiceImpl implements com.demo.service.UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User findById(String id) {
        return null;
    }

    @Override
    public int insert(User user) {
        return 0;
    }

    @Override
    public int update(User user) {
        return 0;
    }

    @Override
    public int delete(String id) {
        return 0;
    }

    @Override
    public boolean login(User user, HttpSession session) {
        User src = userMapper.getUserByUserName(user.getUserName());
        if (src != null && src.getPassword().equals(user.getPassword())) {
            session.setAttribute("user", src);
            return true;
        } else {
            return false;
        }
    }

}
