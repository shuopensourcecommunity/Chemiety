package cn.kastner.chemiety.domain;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "comment")
public class Comment {

    /**
     * 评论id 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long commentId;

    /**
     * 发布用户id 外键
     */
    private Long userId;

    /**
     * 评论内容
     */
    @Column(columnDefinition = "TEXT")
    private String content;

    /**
     * 帖子id 外键
     */
    private Long postId;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }
}
