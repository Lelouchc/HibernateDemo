package com.demo.dao.intf;

import com.demo.entity.User;

import java.util.List;
import java.util.Optional;

/**
 * Created by yy on 2016/3/8.
 */
public interface UserDao {
    /**
     * 查询用户列表
     *
     * @return
     */
    List<User> getUsers();

    /**
     * 查询用户详细信息
     *
     * @param user 登陆信息
     * @return
     */
    User getUser(User user);

    /**
     * 通过ID查询用户信息
     *
     * @param userid 用户ID
     * @return
     */
    Optional<User> getUser(int userid);

    /**
     * 获取用户ID
     * @param account 账号/手机号/邮箱
     * @return
     */
    int getUserId(String account);

    /**
     * 验证登陆是否成功
     *
     * @param account  账号/手机号/邮箱
     * @return
     */
    User checkLogin(String account);

    /**
     * 验证原密码是否正确
     *
     * @param id       用户ID
     * @param password 原密码
     * @return
     */
    boolean checkPassword(int id, String password);

    /**
     * 统计用户数量
     *
     * @return
     */
    long countUser();

    /**
     * 添加用户（注册）
     *
     * @param user 待添加用户信息
     * @return
     */
    void addUser(User user);

    /**
     * 更新用户信息
     *
     * @param user 待更新用户信息
     * @return
     */
    boolean updUser(User user);

    boolean updUserWithVersion(User user);

    /**
     * 修改密码
     *
     * @param user 用户信息
     * @return
     */
    boolean updUserPassword(User user);

    /**
     * 修改账号
     *
     * @param user 用户信息
     * @return
     */
    boolean updUserAccount(User user);

    /**
     * 修改昵称
     *
     * @param user 用户信息
     * @return
     */
    boolean updUserName(User user);

    /**
     * 修改手机号
     *
     * @param user 用户信息
     * @return
     */
    boolean updUserPhone(User user);

    /**
     * 修改邮箱
     *
     * @param user 用户信息
     * @return
     */
    boolean updUserEmail(User user);

    /**
     * 验证用户是否存在
     *
     * @param account 账号/手机号/邮箱
     * @return
     */
    boolean hasUser(String account);

    /**
     * 验证账号是否存在
     *
     * @param account 账号
     * @return
     */
    boolean hasAccount(String account);

    /**
     * 验证昵称是否存在
     *
     * @param username 昵称
     * @return
     */
    boolean hasUsername(String username);

    /**
     * 验证手机号是否存在
     *
     * @param phone 手机号
     * @return
     */
    boolean hasPhone(String phone);

    /**
     * 验证邮箱是否存在
     *
     * @param email 邮箱
     * @return
     */
    boolean hasEmail(String email);
}
