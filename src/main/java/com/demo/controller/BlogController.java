package com.demo.controller;

import com.demo.service.intf.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by yy on 2016/3/16.
 */
@Controller
@RequestMapping("blog")
public class BlogController {
    @Autowired
    private BlogService blogService;

    @RequestMapping("/getBlogs")
    public String getBlogs(Model model) {
        model.addAttribute("list", blogService.getBlogs(0, ""));
        return "items/blog_list";
    }

    public void demo() {
        System.out.println("22");
    }
}
