package com.demo.dao.intf;

import com.demo.entity.Category;

import java.util.List;

/**
 * Created by yy on 2016/3/11.
 */
public interface CategoryDao {
    /**
     * 查询类别列表
     *
     * @return
     */
    List<Category> getCategories();

    /**
     * 添加类别
     *
     * @param category 待添加类型信息
     * @return
     */
    void addCategory(Category category);

    void updCategory(Category category);

    /**
     * 删除类别
     *
     * @param category 待删除类别
     * @return
     */
    void delCategory(Category category);

    /**
     * 判断类别下是否存在博客
     * @param id 类别ID
     * @return
     */
    boolean hasBlog(int id);

    boolean increase(String name);

    boolean decrease(String name);
}
