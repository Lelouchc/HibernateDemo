package com.demo.dao.impl;

import com.demo.dao.intf.CategoryDao;
import com.demo.entity.Category;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by yy on 2016/3/11.
 * 类别数据处理
 */
@SuppressWarnings({"JpaQlInspection", "unchecked"})
@Repository
public class CategoryDaoImpl extends BaseDao implements CategoryDao {
    @Override
    public List<Category> getCategories() {
        return this.getSessionFactory().getCurrentSession()
                .createQuery("from Category c")
                .list();
    }

    @Override
    public boolean addCategory(Category category) {
        return this.getSessionFactory().getCurrentSession()
                .save(category) != null;
    }

    @Override
    public boolean delCategory(String name) {
        return this.getSessionFactory().getCurrentSession()
                .createQuery("delete from Category c where c.name=:name")
                .setParameter("name", name)
                .executeUpdate() > 0;
    }

    @Override
    public boolean hasBlog(int id) {
        return this.getSessionFactory().getCurrentSession()
                .createQuery("from Blog b where b.categoryid=:id")
                .setParameter("id", id)
                .iterate()
                .hasNext();
    }

    @Override
    public boolean increase(String name) {
        return this.getSessionFactory().getCurrentSession()
                .createQuery("update Category c set c.blogcount=c.blogcount+1 where c.name=:name")
                .setParameter("name", name)
                .executeUpdate() > 0;
    }

    @Override
    public boolean decrease(String name) {
        return this.getSessionFactory().getCurrentSession()
                .createQuery("update Category c set c.blogcount=c.blogcount-1 where c.name=:name")
                .setParameter("name", name)
                .executeUpdate() > 0;
    }
}
