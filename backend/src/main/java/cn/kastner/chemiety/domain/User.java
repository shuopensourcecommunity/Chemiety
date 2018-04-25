package cn.kastner.chemiety.domain;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {

    public static final String CUR_USER = "currentUser";

    @Id
    private Long id;
    private String username;
    private String password;
    private String passwordConfirm;
    private Set<Role> roles;

    public User (String name, String password) {
        this.username = name;
        this.password = password;
    }



    public Long getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }
}
