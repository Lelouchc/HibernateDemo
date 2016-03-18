package com.demo.jpa.intf;

import com.demo.entity.User;

import java.util.List;

/**
 * Created by yy on 2016/3/18.
 */
public interface UserJpa {
    List<User> getUsers();

    User getUser(int userid);
}
