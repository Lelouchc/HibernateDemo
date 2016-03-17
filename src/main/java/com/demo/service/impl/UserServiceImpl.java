package com.demo.service.impl;

import com.demo.common.EncryptionUtil;
import com.demo.dao.intf.LogDao;
import com.demo.dao.intf.UserDao;
import com.demo.entity.User;
import com.demo.model.UserLogin;
import com.demo.model.UserModel;
import com.demo.model.UserUpdPassword;
import com.demo.service.intf.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

/**
 * Created by yy on 2016/3/8.
 * 用户业务类
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private LogDao logDao;

    @Override
    public List<User> getUsers() {
        return userDao.getUsers();
    }

    @Override
    public User getUser(int userid) {
        return userDao.getUser(userid);
    }

    @Override
    public long countUser() {
        return userDao.countUser();
    }

    @Override
    public int checkLogin(UserLogin userLogin) throws Exception {
        Iterator iterator = userDao.checkLogin(userLogin.getAccount());
        int uid = 0;
        while (iterator.hasNext()) {
            User user = (User) iterator.next();
            if (user.getPassword().equals(EncryptionUtil.encryptMS1(userLogin.getPassword()))) {
                uid = user.getId();
                try {
                    logDao.addLog(uid, "用户登陆");
                } catch (Exception e) {
                    e.printStackTrace();
                    throw new Exception("登陆失败");
                }
            }
        }
        if (uid == 0) {
            try {
                logDao.addLog(userDao.getUserId(userLogin.getAccount()), "用户登陆失败：用户名或密码错误");
            } catch (Exception e) {
                e.printStackTrace();
            }
            throw new Exception("用户名或密码错误");
        }
        return uid;
    }

    @Override
    public boolean addUser(UserModel user) throws Exception {
        if (userDao.hasAccount(user.getAccount()))
            throw new Exception("账号已存在");
        if (userDao.hasUsername(user.getUsername()))
            throw new Exception("昵称已存在");
        if (userDao.hasPhone(user.getPhone()))
            throw new Exception("电话已存在");
        if (userDao.hasEmail(user.getEmail()))
            throw new Exception("邮箱已存在");
        Serializable result = userDao.addUser(user.setPassword(EncryptionUtil.encryptMS1(user.getPassword())).cloneToUser());
        if (result instanceof Integer) {
            try {
                logDao.addLog((Integer) result, "用户注册");
            } catch (Exception e) {
                e.printStackTrace();
                throw new Exception("注册失败");
            }
        }
        return !(result instanceof Integer) || (Integer) result > 0;
    }

    @Override
    public boolean updUser(UserModel user) throws Exception {
        if (userDao.hasUsername(user.getUsername()))
            throw new Exception("昵称已存在");
        if (userDao.hasPhone(user.getPhone()))
            throw new Exception("电话已存在");
        if (userDao.hasEmail(user.getEmail()))
            throw new Exception("邮箱已存在");
        return userDao.updUser(user.cloneToUser());
    }

    @Override
    public boolean updUserPassword(UserUpdPassword userUpdPassword) throws Exception {
        if (!userUpdPassword.getNewPwd().equals(userUpdPassword.getNewPwdRepeat()))
            throw new Exception("两次输入不一致");
        if (userUpdPassword.getOldPwd().equals(userUpdPassword.getNewPwd()))
            throw new Exception("新密码和原密码一样");
        if (!userDao.checkPassword(userUpdPassword.getUserid(), EncryptionUtil.encryptMS1(userUpdPassword.getOldPwd())))
            throw new Exception("原密码错误");
        try {
            logDao.addLog(userUpdPassword.getUserid(), "修改密码");
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("修改失败");
        }
        return userDao.updUserPassword(new User()
                .setId(userUpdPassword.getUserid())
                .setPassword(EncryptionUtil.encryptMS1(userUpdPassword.getNewPwd())));
    }
}
