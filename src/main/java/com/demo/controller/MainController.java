package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;


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

}
