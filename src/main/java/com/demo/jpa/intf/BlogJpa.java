package com.demo.jpa.intf;

import com.demo.entity.Blog;

import java.util.List;

/**
 * Created by yy on 2016/3/18.
 */
public interface BlogJpa {
    /**
     * 获取所有的博客的列表
     * @return 博客列表
     */
    List<Blog> getBlogs();


}
