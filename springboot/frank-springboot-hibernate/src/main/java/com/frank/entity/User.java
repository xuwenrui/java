package com.frank.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @description:
 * @author: xu.wr
 * @create: 2019-02-23 17:45
 **/
@Entity
@Table(name = "user")
public class User  implements Serializable {

    private static final long serialVersionUID = 8655851615465363473L;
    @Id
    @GeneratedValue
    private Integer id;
    private String username;
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(Integer id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }
}
