package cn.kastner.chemiety.controller;

import cn.kastner.chemiety.repository.UserRepository;
import cn.kastner.chemiety.domain.User;
import cn.kastner.chemiety.util.NetResult;
import cn.kastner.chemiety.util.StringMD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class UserRestController {

    @Autowired
    UserRepository userRepository;

    /**
     * @param loginUser 登陆用户
     * @param session 会话
     * @return 0正常 -1异常
     */
    @RequestMapping(value = "/login")
    public NetResult login(User loginUser, HttpSession session) {
        NetResult netResult = new NetResult();
        User user = userRepository.findByUserName(loginUser.getUsername());
        if (null == user) {
            netResult.status = -1;
            netResult.result = "用户不存在！";
        } else {
            String passwordMD5 = StringMD5.stringToMD5(loginUser.getPassword());
            if (passwordMD5 != null && passwordMD5.equals(user.getPassword())) {
                netResult.status = 0;
                netResult.result = "登陆成功！";
                session.setAttribute(User.CUR_USER, user);
            }
        }
        return netResult;
    }

    /**
     * @param session 会话
     * @return 0正常 -1 异常
     */
    @RequestMapping(value = "/logout")
    public NetResult logout(HttpSession session) {
        NetResult netResult = new NetResult();
        User currentUser = (User)session.getAttribute(User.CUR_USER);
        if (null != currentUser) {
            session.removeAttribute(User.CUR_USER);
            netResult.status = 0;
            netResult.result = "注销成功";
        } else {
            netResult.status = -1;
            netResult.result = "未登录或登陆状态已经过期，无需注销";
        }
        return netResult;
    }


}
