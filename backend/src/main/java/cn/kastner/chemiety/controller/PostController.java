package cn.kastner.chemiety.controller;

import cn.kastner.chemiety.domain.Comment;
import cn.kastner.chemiety.domain.Post;
import cn.kastner.chemiety.domain.User;
import cn.kastner.chemiety.repository.CommentRepository;
import cn.kastner.chemiety.repository.PostRepository;
import cn.kastner.chemiety.repository.UserRepository;
import cn.kastner.chemiety.util.NetResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class PostController {

    @InitBinder
    protected void initBinder (WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @Autowired
    UserRepository userRepository;

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
    @RequestMapping(value = "/postPost")
    public NetResult postAPost (Post post, HttpSession session) {
        User user = (User)session.getAttribute(User.CUR_USER);
        if (user != null) {
            if (post.getContent() != null &&
                    post.getTitle() != null) {
                post.setCreateDate(new Date());
                post.setUser(user);
                postRepository.save(post);
                netResult.status = 0;
                netResult.result = post;
            } else {
                netResult.status = -1;
                netResult.result = "帖子内容/主题为空";
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
    @RequestMapping(value = "/postComment")
    public NetResult postAComment (Comment comment, @RequestParam Long postId, HttpSession session) {
        User user = (User)session.getAttribute(User.CUR_USER);
        if (user != null) {
            Post exPost = postRepository.findByPostId(postId);
            if (comment.getContent() == null){
                netResult.status = -2;
                netResult.result = "评论内容为空";
            }else if (exPost == null) {
                netResult.status = -1;
                netResult.result = "评论对象异常";
            }else {
                comment.setUser(user);
                comment.setCreateDate(new Date());
                int commentNumber = exPost.getCommentNumber();
                exPost.setCommentNumber(++commentNumber);
                postRepository.save(exPost);
                comment.setPost(exPost);
                commentRepository.save(comment);
                netResult.status = 0;
                netResult.result = comment;
            }
        }
        return netResult;
    }

    @RequestMapping(value = "/getPosts")
    public NetResult getPosts (HttpSession session) {
        List<Post> posts = postRepository.findByContentIsNotNull();
        for (Post post: posts) {
            post.setComments(commentRepository.findByPost(post));
        }
        netResult.status = 0;
        netResult.result = posts;
        return netResult;
    }

    @RequestMapping(value = "/getMyPosts")
    public NetResult getMyPosts (HttpSession session) {
        User user = (User) session.getAttribute(User.CUR_USER);
        if (user != null) {
            List<Post> posts = postRepository.findByUser(user);
            for (Post post: posts) {
                post.setComments(commentRepository.findByPost(post));
            }
            netResult.status = 0;
            netResult.result = posts;
        } else {
            netResult.status = -2;
            netResult.result = "登陆状态过期，请重新登录！";
        }
        return netResult;
    }

    @RequestMapping(value = "/admin/deletePost")
    public NetResult deletePost (HttpSession session, @RequestParam Long postId) {
        User user = (User) session.getAttribute(User.CUR_USER);
        if (user != null) {
            if (user.getRoles() == User.Role.TEACHER) {
                Post post = postRepository.findByPostId(postId);
                if (post != null) {
                    postRepository.delete(post);
                    netResult.status = 0;
                    netResult.result = "删除成功！";
                } else {
                    netResult.status = -1;
                    netResult.result = "参数错误！";
                }
            } else {
                netResult.status = -2;
                netResult.result = "无权限！";
            }
        } else {
            netResult.status = -3;
            netResult.result = "登录状态过期，请重新登录！";
        }
        return netResult;
    }

}
