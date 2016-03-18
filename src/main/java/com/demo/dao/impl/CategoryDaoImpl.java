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
        return this.getEntityManager()
                .createQuery("from Category c", Category.class)
                .getResultList();
    }

    @Override
    public void addCategory(Category category) {
        this.getEntityManager()
                .persist(category);
    }

    @Override
    public void updCategory(Category category) {
        this.getEntityManager()
                .merge(category);
    }

    @Override
    public void delCategory(Category category) {
        this.getEntityManager()
                .remove(this.getEntityManager()
                        .find(Category.class, category.getName()));
    }

    @Override
    public boolean hasBlog(int id) {
        return this.getEntityManager()
                .createQuery("from Blog b where b.categoryid=:id")
                .setParameter("id", id)
                .getFirstResult() > 0;
    }

    @Override
    public boolean increase(String name) {
        return this.getEntityManager()
                .createQuery("update Category c set c.blogcount=c.blogcount+1 where c.name=:name")
                .setParameter("name", name)
                .executeUpdate() > 0;
    }

    @Override
    public boolean decrease(String name) {
        return this.getEntityManager()
                .createQuery("update Category c set c.blogcount=c.blogcount-1 where c.name=:name")
                .setParameter("name", name)
                .executeUpdate() > 0;
    }
}
