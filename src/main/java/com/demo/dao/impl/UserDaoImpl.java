package com.demo.dao.impl;

import com.demo.dao.intf.UserDao;
import com.demo.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created by yy on 2016/3/8.
 * 用户数据处理
 */
@SuppressWarnings({"JpaQlInspection", "unchecked"})
@Repository
public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public List<User> getUsers() {
        return this.getEntityManager()
                .createQuery("from User u", User.class)
                .getResultList();
    }

    @Override
    public User getUser(User user) {
        return this.getEntityManager()
                .createQuery("from User u where (u.account=:account or u.phone=:phone or u.email=:email) and u.password=:password", User.class)
                .setParameter("account", user.getAccount())
                .setParameter("phone", user.getAccount())
                .setParameter("email", user.getAccount())
                .setParameter("password", user.getPassword())
                .getSingleResult();
    }

    @Override
    public Optional<User> getUser(int userid) {
        return Optional.ofNullable(this.getEntityManager()
                .createQuery("from User u where u.id=:id", User.class)
                .setParameter("id", userid)
                .getSingleResult());
    }

    @Override
    public int getUserId(String account) {
        return this.getEntityManager()
                .createQuery("select u.id from User u where u.account=:account or u.phone=:account or u.email=:account", Integer.class)
                .setParameter("account", account)
                .getSingleResult();
    }

    @Override
    public User checkLogin(String account) {
        return this.getEntityManager()
                .createQuery("from User u where u.account=:account or u.phone=:account or u.email=:account", User.class)
                .setParameter("account", account)
                .getSingleResult();
    }

    @Override
    public boolean checkPassword(int id, String password) {
        return this.getEntityManager()
                .createQuery("from User u where u.id=:id and u.password=:password")
                .setParameter("id", id)
                .setParameter("password", password)
                .getFirstResult() > 0;
    }

    @Override
    public long countUser() {
        return this.getEntityManager()
                .createQuery("select count(*) from User u", Long.class)
                .getSingleResult();
    }

    @Override
    public void addUser(User user) {
        this.getEntityManager()
                .persist(user);
    }

    @Override
    public boolean updUser(User user) {
        return this.getEntityManager()
                .createQuery("update User u set u.username=:username,u.sex=:sex,u.birthday=:birthday,u.phone=:phone,u.email=:email where u.id=:id")
                .setParameter("username", user.getUsername())
                .setParameter("sex", user.getSex())
                .setParameter("birthday", user.getBirthday())
                .setParameter("phone", user.getPhone())
                .setParameter("email", user.getEmail())
                .setParameter("id", user.getId())
                .executeUpdate() > 0;
    }

    @Override
    public boolean updUserWithVersion(User user){
        User u = getUser(user.getId()).get();
        u.setUsername(user.getUsername());
        this.getEntityManager().flush();
        return true;
    }

    @Override
    public boolean updUserPassword(User user) {
        return this.getEntityManager()
                .createQuery("update User u set u.password=:password where u.id=:id")
                .setParameter("password", user.getPassword())
                .setParameter("id", user.getId())
                .executeUpdate() > 0;
    }

    @Override
    public boolean updUserAccount(User user) {
        return this.getEntityManager()
                .createQuery("update User u set u.account=:account where u.id=:id")
                .setParameter("account", user.getAccount())
                .setParameter("id", user.getId())
                .executeUpdate() > 0;
    }

    @Override
    public boolean updUserName(User user) {
        return this.getEntityManager()
                .createQuery("update User u set u.username=:username where u.id=:id")
                .setParameter("username", user.getUsername())
                .setParameter("id", user.getId())
                .executeUpdate() > 0;
    }

    @Override
    public boolean updUserPhone(User user) {
        return this.getEntityManager()
                .createQuery("update User u set u.phone=:phone where u.id=:id")
                .setParameter("phone", user.getPhone())
                .setParameter("id", user.getId())
                .executeUpdate() > 0;
    }

    @Override
    public boolean updUserEmail(User user) {
        return this.getEntityManager()
                .createQuery("update User u set u.email=:email where u.id=:id")
                .setParameter("email", user.getEmail())
                .setParameter("id", user.getId())
                .executeUpdate() > 0;
    }

    @Override
    public boolean hasUser(String account) {
        return this.getEntityManager()
                .createQuery("from User u where u.account=:account or u.phone=:account or u.email=:account")
                .setParameter("account", account)
                .getFirstResult() > 0;
    }

    @Override
    public boolean hasAccount(String account) {
        return this.getEntityManager()
                .createQuery("from User u where u.account=:account")
                .setParameter("account", account)
                .getFirstResult() > 0;
    }

    @Override
    public boolean hasUsername(String username) {
        return this.getEntityManager()
                .createQuery("from User u where u.username=:username")
                .setParameter("username", username)
                .getFirstResult() > 0;
    }

    @Override
    public boolean hasPhone(String phone) {
        return this.getEntityManager()
                .createQuery("from User u where u.phone <> '' and u.phone=:phone")
                .setParameter("phone", phone)
                .getFirstResult() > 0;
    }

    @Override
    public boolean hasEmail(String email) {
        return this.getEntityManager()
                .createQuery("from User u where u.email <> '' and u.email=:email")
                .setParameter("email", email)
                .getFirstResult() > 0;
    }
}
