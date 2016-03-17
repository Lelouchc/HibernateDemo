package com.demo.service.intf;

import com.demo.entity.User;
import com.demo.model.UserLogin;
import com.demo.model.UserModel;
import com.demo.model.UserUpdPassword;

import java.util.List;

/**
 * Created by yy on 2016/3/8.
 */
public interface UserService {
    /**
     * 获取用户列表
     *
     * @return
     */
    List<User> getUsers();

    /**
     * 获取用户详情
     *
     * @param userid
     * @return
     */
    User getUser(int userid);

    /**
     * 统计用户数量
     *
     * @return
     */
    long countUser();

    /**
     * 用户登录验证
     *
     * @param userLogin
     * @return
     * @throws Exception
     */
    int checkLogin(UserLogin userLogin) throws Exception;

    /**
     * 用户注册
     *
     * @param user
     * @return
     * @throws Exception
     */
    boolean addUser(UserModel user) throws Exception;

    /**
     * 修改用户信息
     *
     * @param user
     * @return
     * @throws Exception
     */
    boolean updUser(UserModel user) throws Exception;

    /**
     * 修改密码
     *
     * @param userUpdPassword
     * @return
     * @throws Exception
     */
    boolean updUserPassword(UserUpdPassword userUpdPassword) throws Exception;
}
