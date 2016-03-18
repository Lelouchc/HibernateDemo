package com.demo.dao.intf;

import com.demo.entity.Blog;

import java.util.List;

/**
 * Created by yy on 2016/3/12.
 */
public interface BlogDao {
    /**
     * 查询所有博客列表
     *
     * @return
     */
    List<Blog> getBlogs();

    /**
     * 查询用户博客列表
     *
     * @param userid 登陆用户ID
     * @return
     */
    List<Blog> getBlogs(int userid);

    /**
     * 查询所选类别的博客列表
     *
     * @param category 类别
     * @return
     */
    List<Blog> getBlogs(String category);

    /**
     * 查询用户所选类别的博客列表
     *
     * @param userid   用户ID
     * @param category 类别
     * @return
     */
    List<Blog> getBlogs(int userid, String category);

    /**
     * 查询选中博客信息
     *
     * @param blogid 博客ID
     * @return
     */
    Blog getBlog(int blogid);

    /**
     * 添加博客
     *
     * @param blog 待添加博客信息
     * @return
     */
    void addBlog(Blog blog);

    /**
     * 更新博客
     *
     * @param blog 待修改博客信息
     * @return
     */
    boolean updBlog(Blog blog);

    /**
     * 删除博客
     *
     * @param id 待删除博客ID
     * @return
     */
    boolean delBlog(int id);
}
