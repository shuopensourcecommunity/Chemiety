package cn.kastner.chemiety.controller;

import cn.kastner.chemiety.domain.Info;
import cn.kastner.chemiety.domain.User;
import cn.kastner.chemiety.repository.CommentRepository;
import cn.kastner.chemiety.repository.InfoRepository;
import cn.kastner.chemiety.repository.PostRepository;
import cn.kastner.chemiety.repository.UserRepository;
import cn.kastner.chemiety.util.NetResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class InfoController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PostRepository postRepository;

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    InfoRepository infoRepository;

    @Autowired
    NetResult netResult;

    @RequestMapping(value = "/postInfo")
    public NetResult postInfo (Info info, HttpSession session) {
        User user = (User)session.getAttribute(User.CUR_USER);
        if (user != null) {
            if (user.getRoles() == User.Role.TEACHER) {
                if (info.getContent() != null) {
                    info.setUser(user);
                    infoRepository.save(info);
                    netResult.status = 0;
                    netResult.result = "发表成功！";
                } else {
                    netResult.status = -1;
                    netResult.result = "公告内容为空";
                }
            } else {
                netResult.status = -1;
                netResult.result = "无权限！";
            }
        } else {
            netResult.status = -2;
            netResult.result = "登陆状态过期，请重新登录！";
        }
        return netResult;
    }

    @RequestMapping(value = "/getAllInfo")
    public NetResult getAllInfo (HttpSession session) {
        User user = (User)session.getAttribute(User.CUR_USER);
        if (user != null) {
            if (user.getRoles() == User.Role.TEACHER) {
                List<Info> infos = infoRepository.findByContentIsNotNull();
                netResult.status = 0;
                netResult.result = infos;
            } else {
                netResult.status = -1;
                netResult.result = "无权限！";
            }
        } else {
            netResult.status = -2;
            netResult.result = "登陆状态过期，请重新登录！";
        }
        return netResult;
    }

    @RequestMapping(value = "/getFirstInfo")
    public NetResult getFirstInfo () {
        List<Info> infos = infoRepository.findByContentIsNotNull();
        if (infos.size() != 0) {
            netResult.status = 0;
            netResult.result = infos.get(infos.size());
        } else {
            netResult.status = -1;
            netResult.result = "数据异常！";
        }
        return netResult;
    }
}
