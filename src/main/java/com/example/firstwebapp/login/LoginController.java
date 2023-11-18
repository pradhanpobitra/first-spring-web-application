package com.example.firstwebapp.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private Logger logger = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping("/login-dummy")
    public String login(@RequestParam @Nullable String name, ModelMap model) {
        model.put("name", name);
        logger.debug("Request param is {}", name);
        System.out.println("Request param is " + name);
        return "login-dummy";
    }
}
