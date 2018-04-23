package cn.kastner.chemiety.domain;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "user")
public class User {

    public static final String CUR_USER = "currentUser";

    @Id
    private String userId;

    private String userName;

    private String userPassword;

    public User (String userName, String userPassword) {
        this.userId = UUID.randomUUID().toString();
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public User () {
        this.userId = UUID.randomUUID().toString();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
