package com.demo.service.intf;

import com.demo.entity.Blog;
import com.demo.model.BlogModel;

import java.util.List;

/**
 * Created by yy on 2016/3/16.
 */
public interface BlogService {
    List<Blog> getBlogs(int userid, String category);

    boolean addBlog(BlogModel blog);

    boolean delBlog(int id);
}
