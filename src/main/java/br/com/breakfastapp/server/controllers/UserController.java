package br.com.breakfastapp.server.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @RequestMapping("/users")
    @ResponseBody
    public String getUsers() {
        return "Hello, it's ok.";
    }
}
