package com.demo.service.impl;

import com.demo.entity.Category;
import com.demo.dao.intf.CategoryDao;
import com.demo.service.intf.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yy on 2016/3/11.
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryDao categoryDao;

    @Override
    public List<Category> getCategories() {
        return categoryDao.getCategories();
    }

    @Override
    public boolean addCategory(Category category) {
        return categoryDao.addCategory(category);
    }

    @Override
    public boolean delCategory(String name) {
        return categoryDao.delCategory(name);
    }
}
