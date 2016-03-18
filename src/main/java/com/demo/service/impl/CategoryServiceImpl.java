package com.demo.service.impl;

import com.demo.dao.intf.CategoryDao;
import com.demo.entity.Category;
import com.demo.service.intf.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by yy on 2016/3/11.
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryDao categoryDao;

    @Transactional(value = "txManager")
    public List<Category> getCategories() {
        return categoryDao.getCategories();
    }

    @Transactional(value = "txManager")
    public void addCategory(Category category) {
        categoryDao.addCategory(category);
    }

    @Transactional(value = "txManager")
    public void updCategory(Category category) {
        categoryDao.updCategory(category);
    }

    @Transactional(value = "txManager")
    public void delCategory(Category category) {
        categoryDao.delCategory(category);
    }
}
