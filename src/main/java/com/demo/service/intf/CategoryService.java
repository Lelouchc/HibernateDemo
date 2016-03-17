package com.demo.service.intf;

import com.demo.entity.Category;

import java.util.List;

/**
 * Created by yy on 2016/3/11.
 */
public interface CategoryService {
    List<Category> getCategories();

    boolean addCategory(Category category);

    boolean delCategory(String name);
}
