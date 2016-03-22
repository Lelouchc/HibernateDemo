package com.demo.model;

import com.demo.common.validator.First;
import com.demo.common.validator.RegexpCode;
import com.demo.common.validator.Second;
import com.demo.entity.User;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.GroupSequence;
import javax.validation.constraints.Pattern;

/**
 * Created by yy on 2016/3/16.
 */
@GroupSequence({First.class, Second.class, UserModel.class})
public class UserModel {
    private int id;
    @NotEmpty(message = "{user.account.null}", groups = {First.class})
    @Length(max = 20, message = "{user.account.limit}", groups = {First.class})
    private String account;
    @Length(min = 3, max = 20, message = "{user.password.limit}", groups = {First.class})
    private String password;
    @NotEmpty(message = "{user.username.null}", groups = {First.class, Second.class})
    private String username;
    private String sex;
    @Pattern(regexp = RegexpCode.DATE_CODE, message = "{user.birthday.format}", groups = {First.class, Second.class})
    private String birthday;
    @Pattern(regexp = RegexpCode.PHONE_CODE, message = "{user.phone.format}", groups = {First.class, Second.class})
    private String phone;
    @Email(message = "{user.email.format}", groups = {First.class, Second.class})
    private String email;
    private int version;

    public int getId() {
        return id;
    }

    public UserModel setId(int id) {
        this.id = id;
        return this;
    }

    public String getAccount() {
        return account;
    }

    public UserModel setAccount(String account) {
        this.account = account;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getSex() {
        return sex;
    }

    public UserModel setSex(String sex) {
        this.sex = sex;
        return this;
    }

    public String getBirthday() {
        return birthday;
    }

    public UserModel setBirthday(String birthday) {
        this.birthday = birthday;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public UserModel setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public int getVersion() {
        return version;
    }

    public UserModel setVersion(int version) {
        this.version = version;
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

    public User cloneToUser() {
        return new User().setId(id)
                .setAccount(account)
                .setPassword(password)
                .setUsername(username)
                .setSex(sex)
                .setBirthday(birthday)
                .setPhone(phone)
                .setEmail(email)
                .setVersion(version);
    }
}
