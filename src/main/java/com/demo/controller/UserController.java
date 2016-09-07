package com.demo.controller;

import com.demo.common.validator.Second;
import com.demo.entity.User;
import com.demo.model.UserLogin;
import com.demo.model.UserModel;
import com.demo.model.UserUpdPassword;
import com.demo.service.intf.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

/**
 * Created by yy on 2016/3/8.
 * 用户控制类
 */
@Controller
@RequestMapping("/user")
@SessionAttributes("userid")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 跳转到登陆页面
     *
     * @return
     */
    @RequestMapping(value = "/goLogin", method = RequestMethod.GET)
    public String goLogin(Model model) {
        model.addAttribute("userLogin", new UserLogin());
        return "login/login";
    }

    /**
     * 跳转到注册页面
     *
     * @return
     */
    @RequestMapping(value = "/goRegister", method = RequestMethod.GET)
    public String goRegister(Model model) {
        model.addAttribute("user", new User());
        return "login/register";
    }

    /**
     * 登陆接口
     *
     * @param userLogin
     * @param result
     * @param model
     * @return
     */
    @RequestMapping("/login")
    public String login(@Valid @ModelAttribute("userLogin") UserLogin userLogin, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "login/login";
        }
        try {
            int uid = userService.checkLogin(userLogin);
            model.addAttribute("userid", uid);
            return "main/home";
        } catch (Exception e) {
            model.addAttribute("logResult", e.getMessage());
            return "login/login";
        }
    }

    /**
     * 注册接口
     *
     * @param user
     * @param result
     * @param model
     * @return
     */
    @RequestMapping("/register")
    public String register(@Valid @ModelAttribute("user") UserModel user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "login/register";
        }
        try {
            if (userService.addUser(user)) {
                return "login/login";
            } else {
                model.addAttribute("regResult", "注册失败");
                return "login/register";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "common/error";
        }
    }

    /**
     * 登出接口
     *
     * @param sessionStatus
     * @return
     */
    @RequestMapping(value = "/logOff", method = RequestMethod.GET)
    public String logOff(SessionStatus sessionStatus, Model model) {
        sessionStatus.setComplete();
        model.addAttribute("userLogin", new UserLogin());
        return "login/login";
    }

    /**
     * 获取用户列表接口
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/getUsers", method = RequestMethod.GET)
    public String getUsers(Model model) {
        model.addAttribute("list", userService.getUsers());
        return "main/user_list";
    }

    /**
     * 跳转到修改密码页面
     *
     * @return
     */
    @RequestMapping(value = "/goChangePassword", method = RequestMethod.GET)
    public String goChangePassword() {
        return "user/change_password";
    }

    /**
     * 修改密码接口
     *
     * @param userUpdPassword
     * @param result
     * @param userid
     * @param model
     * @return
     */
    @RequestMapping("/updPassword")
    public String updPassword(
            @Valid @ModelAttribute("userUpdPassword") UserUpdPassword userUpdPassword,
            BindingResult result,
            @ModelAttribute("userid") Integer userid,
            Model model) {
        if (result.hasErrors()) {
            return "user/change_password";
        }
        try {
            if (userService.updUserPassword(userUpdPassword.setUserid(userid)))
                return "login/login";
            else
                return "user/change_password";
        } catch (Exception e) {
            model.addAttribute("pwdResult", e.getMessage());
            return "user/change_password";
        }
    }

    /**
     * 跳转到修改用户信息页面
     *
     * @return
     */
    @RequestMapping(value = "/goUpdUser", method = RequestMethod.GET)
    public String goUpdUser(@ModelAttribute("userid") Integer userid, Model model) {
        model.addAttribute("user", userService.getUser(userid).get());
        return "user/edit_user";
    }

    /**
     * 修改用户信息接口
     *
     * @param user
     * @param result
     * @param model
     * @return
     */
    @RequestMapping("/updUser")
    public String updUser(
            @Validated({Second.class}) @ModelAttribute("user") UserModel user,
            BindingResult result,
            @ModelAttribute("userid") Integer userid,
            Model model) {
        if (result.hasErrors()) {
            model.addAttribute("user", userService.getUser(userid).get());
            return "user/edit_user";
        }
        try {
            if (userService.updUser(user.setId(userid)))
                return "main/home";
            else
                return "user/edit_user";
        } catch (Exception e) {
            model.addAttribute("userResult", e.getMessage());
            return "user/edit_user";
        }
    }

    /**
     * 跳转到主页
     *
     * @return
     */
    @RequestMapping(value = "/goHome", method = RequestMethod.GET)
    public String goHome() {
        return "main/home";
    }
}
