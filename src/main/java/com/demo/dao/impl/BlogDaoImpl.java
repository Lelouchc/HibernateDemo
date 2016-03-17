package com.demo.dao.impl;

import com.demo.dao.intf.BlogDao;
import com.demo.entity.Blog;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by yy on 2016/3/12.
 * 博客数据处理
 */
@SuppressWarnings({"JpaQlInspection", "unchecked"})
@Repository
public class BlogDaoImpl extends BaseDao implements BlogDao {
    @Override
    public List<Blog> getBlogs() {
        return this.getSessionFactory().getCurrentSession()
                .createQuery("from Blog b")
                .list();
    }

    @Override
    public List<Blog> getBlogs(int userid) {
        return this.getSessionFactory().getCurrentSession()
                .createQuery("from Blog b where b.userid=:userid")
                .setParameter("userid", userid)
                .list();
    }

    @Override
    public List<Blog> getBlogs(String category) {
        return this.getSessionFactory().getCurrentSession()
                .createQuery("from Blog b where b.category=:category")
                .setParameter("category", category)
                .list();
    }

    @Override
    public List<Blog> getBlogs(int userid, String category) {
        return this.getSessionFactory().getCurrentSession()
                .createQuery("from Blog b where b.userid=:userid and b.category=:category")
                .setParameter("userid", userid)
                .setParameter("category", category)
                .list();
    }

    @Override
    public Blog getBlog(int blogid) {
        return this.getSessionFactory().getCurrentSession()
                .load(Blog.class, blogid);
    }

    @Override
    public boolean addBlog(Blog blog) {
        return (boolean) this.getSessionFactory().getCurrentSession()
                .save(blog);
    }

    @Override
    public boolean updBlog(Blog blog) {
        try {
            this.getSessionFactory().getCurrentSession()
                    .saveOrUpdate(blog);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean delBlog(int id) {
        try {
            return this.getSessionFactory().getCurrentSession()
                    .createQuery("delete from Blog b where b.id=:id")
                    .setParameter("id", id)
                    .executeUpdate() > 0;
        } catch (Exception e) {
            return false;
        }
    }
}
