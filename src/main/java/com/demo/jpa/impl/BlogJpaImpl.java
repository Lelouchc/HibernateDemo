package com.demo.jpa.impl;

import com.demo.entity.Blog;
import com.demo.jpa.intf.BlogJpa;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by yy on 2016/3/18.
 */
@SuppressWarnings("JpaQlInspection")
@Repository
public class BlogJpaImpl extends BaseJpa implements BlogJpa {
    @Override
    public List<Blog> getBlogs() {
        return getEntityManager().createQuery("from Blog b", Blog.class).getResultList();
    }
}
