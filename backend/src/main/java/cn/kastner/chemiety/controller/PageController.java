package cn.kastner.chemiety.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import cn.kastner.chemiety.domain.User;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Response;


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

    @RequestMapping(value = "/info")
    public String info (HttpSession session) {
        User user = (User) session.getAttribute(User.CUR_USER);
        if (User.Role.TEACHER == user.getRoles()) {
            return "info";
        } else {
            return "权限不足";
        }
    }

    @RequestMapping(value = "/fileUpload")
    public String fileUpload (HttpSession session) {
        User user = (User) session.getAttribute(User.CUR_USER);
        if (User.Role.TEACHER == user.getRoles()) {
            return "fileUpload";
        } else {
            return "权限不足";
        }
    }
}
