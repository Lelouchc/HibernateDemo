package com.demo.service.impl;

import com.demo.dao.intf.BlogDao;
import com.demo.dao.intf.CategoryDao;
import com.demo.entity.Blog;
import com.demo.model.BlogModel;
import com.demo.service.intf.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yy on 2016/3/16.
 */
@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogDao blogDao;

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public List<Blog> getBlogs(int userid, String category) {
        if (userid == 0 && category.isEmpty())
            return blogDao.getBlogs();
        else if (userid > 0 && category.isEmpty())
            return blogDao.getBlogs(userid);
        else if (userid == 0 && !category.isEmpty())
            return blogDao.getBlogs(category);
        else
            return blogDao.getBlogs(userid, category);
    }

    @Override
    public boolean addBlog(BlogModel blog){
        blogDao.addBlog(blog.cloneToBlog());
        categoryDao.increase(blog.getCategory());
        return true;
    }

    @Override
    public boolean delBlog(int id){
        return blogDao.delBlog(id);
    }
}
