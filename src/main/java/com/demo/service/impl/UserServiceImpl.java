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
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @Transactional(value = "txManager")
    public List<User> getUsers() {
        return userDao.getUsers().stream().sorted(Comparator.comparing(User::getUsername)).collect(Collectors.toList());
    }

    @Transactional(value = "txManager")
    public Optional<User> getUser(int userid) {
        return userDao.getUser(userid);
    }

    @Transactional(value = "txManager")
    public long countUser() {
        return userDao.countUser();
    }

    @Transactional(value = "txManager")
    public int checkLogin(UserLogin userLogin) throws Exception {
        try {
            User user = userDao.checkLogin(userLogin.getAccount());
            if (user.getPassword().equals(EncryptionUtil.encryptMS1(userLogin.getPassword()))) {
                try {
                    logDao.addLog(user.getId(), "用户登陆");
                } catch (Exception e) {
                    e.printStackTrace();
                    throw new Exception("登陆失败");
                }
            }
            return user.getId();
        } catch (Exception e) {
            try {
                logDao.addLog(userDao.getUserId(userLogin.getAccount()), "用户登陆失败：用户名或密码错误");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            throw new Exception("用户名或密码错误");
        }
    }

    @Transactional(value = "txManager")
    public boolean addUser(UserModel user) throws Exception {
        if (userDao.hasAccount(user.getAccount()))
            throw new Exception("账号已存在");
        if (userDao.hasUsername(user.getUsername()))
            throw new Exception("昵称已存在");
        if (userDao.hasPhone(user.getPhone()))
            throw new Exception("电话已存在");
        if (userDao.hasEmail(user.getEmail()))
            throw new Exception("邮箱已存在");
        userDao.addUser(user.setPassword(EncryptionUtil.encryptMS1(user.getPassword())).cloneToUser());
        try {
            logDao.addLog(0, "用户注册");
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("注册失败");
        }
        return true;
    }

    @Transactional(value = "txManager")
    public boolean updUser(UserModel user) throws Exception {
        if (userDao.hasUsername(user.getUsername()))
            throw new Exception("昵称已存在");
        if (userDao.hasPhone(user.getPhone()))
            throw new Exception("电话已存在");
        if (userDao.hasEmail(user.getEmail()))
            throw new Exception("邮箱已存在");
        return userDao.updUser(user.cloneToUser());
    }

    @Transactional(value = "txManager")
    public boolean updUserWithVersion(UserModel userModel){
        return userDao.updUserWithVersion(userModel.cloneToUser());
    }

    @Transactional(value = "txManager")
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
