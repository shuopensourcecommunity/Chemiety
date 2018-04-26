package cn.kastner.chemiety.controller;

import cn.kastner.chemiety.domain.Comment;
import cn.kastner.chemiety.domain.Post;
import cn.kastner.chemiety.domain.User;
import cn.kastner.chemiety.repository.CommentRepository;
import cn.kastner.chemiety.repository.PostRepository;
import cn.kastner.chemiety.util.NetResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class PostController {

    @Autowired
    PostRepository postRepository;

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    NetResult netResult;

    /**
     * @param post {
     *             title: 标题
     *             content： 内容
     * }
     * @param session 会话
     * @return {
     *     0：发表成功
     *     -1：帖子内容为空
     *     -2：用户登陆状态过期或未登录
     * }
     */
    @RequestMapping(value = "/postAPost")
    public NetResult postAPost (Post post, HttpSession session) {
        NetResult netResult = new NetResult();
            User user = (User)session.getAttribute(User.CUR_USER);
            if (user != null) {
                if (post.getContent() != null &&
                        post.getTitle() != null) {
                    post.setUserId(user.getUserId());
                    postRepository.save(post);
                    netResult.status = 0;
                    netResult.result = "发表成功！";
                } else {
                    netResult.status = -1;
                    netResult.result = "帖子内容为空";
                }
            } else {
                netResult.status = -2;
                netResult.result = "登陆状态过期，请重新登录！";
            }
        return netResult;
    }

    /**
     * @param comment {
     *                content:内容
     * }
     * @param session 会话
     * @return {
     *     0: 评论成功
     *     -1: 评论内容为空
     *     -2: 未登录或登陆状态过期
     * }
     */
    @RequestMapping(value = "/postAComment")
    public NetResult postAComment (Comment comment, HttpSession session) {
        NetResult netResult = new NetResult();
        User user = (User)session.getAttribute(User.CUR_USER);
        if (user != null) {
            if (comment.getContent() != null) {
                comment.setUserId(user.getUserId());
                commentRepository.save(comment);
                netResult.status = 0;
                netResult.result = "评论成功！";
            } else {
                netResult.status = -1;
                netResult.result = "评论内容为空";
            }
        } else {
            netResult.status = -2;
            netResult.result = "登陆状态过期，请重新登录！";
        }
        return netResult;
    }

}
