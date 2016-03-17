package com.demo.dao.impl;

import com.demo.dao.intf.UserDao;
import com.demo.entity.User;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

/**
 * Created by yy on 2016/3/8.
 * 用户数据处理
 */
@SuppressWarnings({"JpaQlInspection", "unchecked"})
@Repository
public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public List<User> getUsers() {
        return this.getSessionFactory().getCurrentSession()
                .createQuery("from User u")
                .list();
    }

    @Override
    public User getUser(User user) {
        return (User) this.getSessionFactory().getCurrentSession()
                .createQuery("from User u where (u.account=:account or u.phone=:phone or u.email=:email) and u.password=:password")
                .setParameter("account", user.getAccount())
                .setParameter("phone", user.getAccount())
                .setParameter("email", user.getAccount())
                .setParameter("password", user.getPassword())
                .list()
                .get(0);
    }

    @Override
    public User getUser(int userid) {
        return this.getSessionFactory().getCurrentSession()
                .get(User.class, userid);
    }

    @Override
    public int getUserId(String account){
        return (int) this.getSessionFactory().getCurrentSession()
                .createQuery("select u.id from User u where u.account=:account or u.phone=:account or u.email=:account")
                .setParameter("account", account)
                .uniqueResult();
    }

    @Override
    public Iterator checkLogin(String account) {
        String hql = "from User u where u.account=:account or u.phone=:account or u.email=:account";
        return this.getSessionFactory().getCurrentSession()
                .createQuery(hql)
                .setParameter("account", account)
                .iterate();
    }

    @Override
    public boolean checkPassword(int id, String password) {
        return this.getSessionFactory().getCurrentSession()
                .createQuery("from User u where u.id=:id and u.password=:password")
                .setParameter("id", id)
                .setParameter("password", password)
                .iterate()
                .hasNext();
    }

    @Override
    public long countUser() {
        return (long) this.getSessionFactory().getCurrentSession()
                .createQuery("select count(*) from User u")
                .uniqueResult();
    }

    @Override
    public Serializable addUser(User user) {
        return this.getSessionFactory().getCurrentSession()
                .save(user);
    }

    @Override
    public boolean updUser(User user) {
        return this.getSessionFactory().getCurrentSession()
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
    public boolean updUserPassword(User user) {
        return this.getSessionFactory().getCurrentSession()
                .createQuery("update User u set u.password=:password where u.id=:id")
                .setParameter("password", user.getPassword())
                .setParameter("id", user.getId())
                .executeUpdate() > 0;
    }

    @Override
    public boolean updUserAccount(User user) {
        return this.getSessionFactory().getCurrentSession()
                .createQuery("update User u set u.account=:account where u.id=:id")
                .setParameter("account", user.getAccount())
                .setParameter("id", user.getId())
                .executeUpdate() > 0;
    }

    @Override
    public boolean updUserName(User user) {
        return this.getSessionFactory().getCurrentSession()
                .createQuery("update User u set u.username=:username where u.id=:id")
                .setParameter("username", user.getUsername())
                .setParameter("id", user.getId())
                .executeUpdate() > 0;
    }

    @Override
    public boolean updUserPhone(User user) {
        return this.getSessionFactory().getCurrentSession()
                .createQuery("update User u set u.phone=:phone where u.id=:id")
                .setParameter("phone", user.getPhone())
                .setParameter("id", user.getId())
                .executeUpdate() > 0;
    }

    @Override
    public boolean updUserEmail(User user) {
        return this.getSessionFactory().getCurrentSession()
                .createQuery("update User u set u.email=:email where u.id=:id")
                .setParameter("email", user.getEmail())
                .setParameter("id", user.getId())
                .executeUpdate() > 0;
    }

    @Override
    public boolean hasUser(String account) {
        return this.getSessionFactory().getCurrentSession()
                .createQuery("from User u where u.account=:account or u.phone=:account or u.email=:account")
                .setParameter("account", account)
                .iterate()
                .hasNext();
    }

    @Override
    public boolean hasAccount(String account) {
        return this.getSessionFactory().getCurrentSession()
                .createQuery("from User u where u.account=:account")
                .setParameter("account", account)
                .iterate()
                .hasNext();
    }

    @Override
    public boolean hasUsername(String username) {
        return this.getSessionFactory().getCurrentSession()
                .createQuery("from User u where u.username=:username")
                .setParameter("username", username)
                .iterate()
                .hasNext();
    }

    @Override
    public boolean hasPhone(String phone) {
        return this.getSessionFactory().getCurrentSession()
                .createQuery("from User u where u.phone <> '' and u.phone=:phone")
                .setParameter("phone", phone)
                .iterate()
                .hasNext();
    }

    @Override
    public boolean hasEmail(String email) {
        return this.getSessionFactory().getCurrentSession()
                .createQuery("from User u where u.email <> '' and u.email=:email")
                .setParameter("email", email)
                .iterate()
                .hasNext();
    }
}
