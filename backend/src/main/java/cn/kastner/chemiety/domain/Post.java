package cn.kastner.chemiety.domain;

import cn.kastner.chemiety.repository.PostRepository;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "post")
public class Post {

    @InitBinder
    protected void initBinder (WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }


    public Post () {
        super();
        this.commentNumber = 0;
        this.createDate = new Date();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long postId;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Temporal(TemporalType.DATE)
    private Date createDate;

    private int commentNumber;

    @ManyToOne
    private User user;

    private String title;

    @OneToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Comment> comments;

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
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

    public int getCommentNumber() {
        return commentNumber;
    }

    public void setCommentNumber(int commentNumber) {
        this.commentNumber = commentNumber;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
