package cn.kastner.chemiety.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "admin")
public class UserController {

    @RequestMapping(value = "/admin")
    public String admin () {
        return "admin";
    }
}
