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
            return "权限不足";
        }
    }

    @RequestMapping(value = "/checkPost")
    public String checkPost (HttpSession session) {
        User user = (User) session.getAttribute(User.CUR_USER);
        if (User.Role.TEACHER == user.getRoles()) {
            return "checkPost";
        } else {
            return "权限不足";
        }
    }

    @RequestMapping(value = "/settings")
    public String settings (HttpSession session) {
        User user = (User) session.getAttribute(User.CUR_USER);
        if (User.Role.TEACHER == user.getRoles()) {
            return "settings";
        } else {
            return "权限不足";
        }
    }
}
