package com.demo.model;

import com.demo.common.validator.First;
import com.demo.common.validator.Second;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.GroupSequence;

/**
 * Created by yy on 2016/3/14.
 */
@GroupSequence({First.class, Second.class, UserUpdPassword.class})
public class UserUpdPassword {
    private int userid;
    @NotEmpty(message = "{updPassword.oldPwd.null}", groups = {First.class})
    @Length(min = 3, max = 20, message = "{user.password.limit}", groups = {Second.class})
    private String oldPwd;
    @NotEmpty(message = "{updPassword.newPwd.null}", groups = {First.class})
    @Length(min = 3, max = 20, message = "{user.password.limit}", groups = {Second.class})
    private String newPwd;
    @NotEmpty(message = "{updPassword.newPwdRepeat.null}", groups = {First.class})
    @Length(min = 3, max = 20, message = "{user.password.limit}", groups = {Second.class})
    private String newPwdRepeat;

    public int getUserid() {
        return userid;
    }

    public UserUpdPassword setUserid(int userid) {
        this.userid = userid;
        return this;
    }

    public String getOldPwd() {
        return oldPwd;
    }

    public UserUpdPassword setOldPwd(String oldPwd) {
        this.oldPwd = oldPwd;
        return this;
    }

    public String getNewPwd() {
        return newPwd;
    }

    public UserUpdPassword setNewPwd(String newPwd) {
        this.newPwd = newPwd;
        return this;
    }

    public String getNewPwdRepeat() {
        return newPwdRepeat;
    }

    public UserUpdPassword setNewPwdRepeat(String newPwdRepeat) {
        this.newPwdRepeat = newPwdRepeat;
        return this;
    }
}
