package com.demo.jpa.impl;

import com.demo.entity.User;
import com.demo.jpa.intf.UserJpa;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by yy on 2016/3/18.
 */
@SuppressWarnings("JpaQlInspection")
@Repository
public class UserJpaImpl extends BaseJpa implements UserJpa {
    @Override
    public List<User> getUsers() {
        System.out.println(getEntityManager());
        return getEntityManager().createQuery("from User u", User.class).getResultList();
    }

    @Override
    public User getUser(int userid) {
        System.out.println(getEntityManager());
        return getEntityManager().createQuery("from User u where id=:id", User.class).setParameter("id", userid).getSingleResult();
    }
}
