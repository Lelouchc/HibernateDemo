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
     * 天际类别
     *
     * @param category 待添加类型信息
     * @return
     */
    boolean addCategory(Category category);

    /**
     * 删除类别
     *
     * @param name 待删除类别名称
     * @return
     */
    boolean delCategory(String name);

    /**
     * 判断类别下是否存在博客
     * @param id 类别ID
     * @return
     */
    boolean hasBlog(int id);

    boolean increase(String name);

    boolean decrease(String name);
}
