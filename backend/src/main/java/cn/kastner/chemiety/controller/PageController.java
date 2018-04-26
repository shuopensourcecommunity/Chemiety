package cn.kastner.chemiety.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import cn.kastner.chemiety.domain.User;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/admin")
public class PageController {

    @RequestMapping(value = "/index")
    public String index (HttpSession session) {
        User user = (User) session.getAttribute(User.CUR_USER);
        if (User.Role.TEACHER == user.getRoles()) {
            return "admin";
        } else {
            return null;
        }
    }
}
