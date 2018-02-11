package com.demo.controller;

import com.demo.bean.ResponseBean;
import com.demo.bean.User;
import com.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/")
public class MainController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String index(@SessionAttribute("user") String user, Model model) {
        model.addAttribute("name", user);
        return "index";
    }


    @RequestMapping("/login")
    public String login() {
        return "/login";
    }

    @RequestMapping(value = {"/loginPost"}, method = RequestMethod.POST)
    @ResponseBody
    public String loginPost(User user, HttpSession session) {
        ResponseBean bean;
        if (userService.login(user, session)) {
            bean = new ResponseBean(ResponseBean.SUCCESS);
        } else {
            bean = new ResponseBean(ResponseBean.FAULT, "用户名或密码错误");
        }
        return bean.toString();
    }

}
