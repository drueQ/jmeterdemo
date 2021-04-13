package com.xdclass.jmeterdemo.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private long Id;

    @Column(nullable = false ,unique = true)
    private String name;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String regtime;

    public User(){super();}

    public User(String name, String password, String regtime) {
        super();
        this.name = name;
        this.password = password;
        this.regtime = regtime;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getRegtime() {
        return regtime;
    }

    public void setRegtime(String regtime) {
        this.regtime = regtime;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", regtime='" + regtime + '\'' +
                '}';
    }
}
