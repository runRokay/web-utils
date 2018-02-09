package com.demo.controller;

import com.demo.bean.ResponseBean;
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
    public String loginPost(String userName, String password, HttpSession session) {
        ResponseBean bean = new ResponseBean(ResponseBean.FAULT, "用户名或密码错误");
//        if (loginService.login(userName, password, session)) {
//            bean = new ResponseBean(ConstantUtil.SUCCESS);
//        } else {
//            bean = new ResponseBean(ConstantUtil.FAULT, "用户名或密码错误");
//        }
        return bean.toString();
    }

}
