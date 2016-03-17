package com.demo.model;

import com.demo.common.validator.First;
import com.demo.common.validator.Second;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.GroupSequence;

/**
 * Created by yy on 2016/3/14.
 */
@GroupSequence({First.class, Second.class, UserLogin.class})
public class UserLogin {
    @NotEmpty(message = "{login.account.null}", groups = {First.class})
    @Length(max = 20, message = "{user.account.limit}", groups = {Second.class})
    private String account;
    @NotEmpty(message = "{login.password.null}", groups = {First.class})
    @Length(min = 3, max = 20, message = "{user.password.limit}", groups = {Second.class})
    private String password;

    public String getAccount() {
        return account;
    }

    public UserLogin setAccount(String account) {
        this.account = account;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserLogin setPassword(String password) {
        this.password = password;
        return this;
    }
}
