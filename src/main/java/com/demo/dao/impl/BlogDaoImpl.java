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
        return this.getEntityManager()
                .createQuery("from Blog b", Blog.class)
                .getResultList();
    }

    @Override
    public List<Blog> getBlogs(int userid) {
        return this.getEntityManager()
                .createQuery("from Blog b where b.userid=:userid", Blog.class)
                .setParameter("userid", userid)
                .getResultList();
    }

    @Override
    public List<Blog> getBlogs(String category) {
        return this.getEntityManager()
                .createQuery("from Blog b where b.category=:category", Blog.class)
                .setParameter("category", category)
                .getResultList();
    }

    @Override
    public List<Blog> getBlogs(int userid, String category) {
        return this.getEntityManager()
                .createQuery("from Blog b where b.userid=:userid and b.category=:category", Blog.class)
                .setParameter("userid", userid)
                .setParameter("category", category)
                .getResultList();
    }

    @Override
    public Blog getBlog(int blogid) {
        return this.getEntityManager()
                .find(Blog.class, blogid);
    }

    @Override
    public void addBlog(Blog blog) {
        this.getEntityManager()
                .persist(blog);
    }

    @Override
    public boolean updBlog(Blog blog) {
        try {
            this.getEntityManager()
                    .persist(blog);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean delBlog(int id) {
        try {
            return this.getEntityManager()
                    .createQuery("delete from Blog b where b.id=:id")
                    .setParameter("id", id)
                    .executeUpdate() > 0;
        } catch (Exception e) {
            return false;
        }
    }
}
