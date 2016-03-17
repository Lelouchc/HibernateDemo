package com.demo.entity;

import com.demo.model.SexType;

import javax.persistence.*;

/**
 * Created by yy on 2016/3/8.
 * 用户表
 */
@Entity
@Table(name = "t_user")
@SequenceGenerator(name = "user_seq", sequenceName = "user_seq", initialValue = 1, allocationSize = 1)
public class User {
    /**
     * 用户ID
     */
    @Id
    @Column(insertable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    private int id;
    /**
     * 账号
     */
    @Column(length = 20)
    private String account;
    /**
     * 密码
     */
    @Column(length = 50)
    private String password;
    /**
     * 昵称
     */
    @Column(length = 30)
    private String username;
    /**
     * 性别
     */
    @Column(length = 10)
    private String sex;
    /**
     * 生日
     */
    @Column(length = 20)
    private String birthday;
    /**
     * 手机号
     */
    @Column(length = 16)
    private String phone;
    /**
     * 邮箱
     */
    @Column(length = 30)
    private String email;

    public int getId() {
        return id;
    }

    public User setId(int id) {
        this.id = id;
        return this;
    }

    public String getAccount() {
        return account;
    }

    public User setAccount(String account) {
        this.account = account;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getSex() {
        return sex;
    }

    public User setSex(String sex) {
        this.sex = sex;
        return this;
    }

    public String getBirthday() {
        return birthday;
    }

    public User setBirthday(String birthday) {
        this.birthday = birthday;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public User setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    @Override
    public String toString() {
        return "用户{" +
                "账号：'" + account + '\'' +
                ", 昵称：'" + username + '\'' +
                ", 性别：'" + SexType.valueOf(sex) + '\'' +
                ", 生日：'" + birthday + '\'' +
                ", 手机号：'" + phone + '\'' +
                ", 邮箱：'" + email + '\'' +
                '}';
    }
}
