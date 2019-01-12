package com.whisky.henallux.whisky.controller;

import com.whisky.henallux.whisky.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.security.core.Authentication;

@Controller
@RequestMapping
public class LoginController {

    @Autowired
    public LoginController() { ; }

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String home(Model model) {
        model.addAttribute("user", new User());
        return "integrated:login";
    }

    @RequestMapping(method = RequestMethod.GET)
    public void getUserAuth(Authentication authentication)
    {
        authentication.getPrincipal();
    }

}
