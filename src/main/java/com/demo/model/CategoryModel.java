package com.demo.model;

import com.demo.entity.Category;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by yy on 2016/3/16.
 */
public class CategoryModel {
    @NotEmpty(message = "{category.name.null}")
    private String name;
    private int blogcount = 0;

    public String getName() {
        return name;
    }

    public CategoryModel setName(String name) {
        this.name = name;
        return this;
    }

    public int getBlogcount() {
        return blogcount;
    }

    public CategoryModel setBlogcount(int blogcount) {
        this.blogcount = blogcount;
        return this;
    }

    @Override
    public String toString() {
        return "类别{" +
                "名称：'" + name + '\'' +
                ", 博客数量" + blogcount +
                '}';
    }

    public Category cloneToCategory() {
        return new Category()
                .setName(name)
                .setBlogcount(blogcount);
    }
}
