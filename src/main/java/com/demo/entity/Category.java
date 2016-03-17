package com.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by yy on 2016/3/11.
 * 类别表
 */
@Entity
@Table(name = "t_category")
public class Category {
    /**
     * 类别名称
     */
    @Id
    @Column(length = 10)
    private String name;
    /**
     * 类别下博客总数
     */
    @Column
    private int blogcount = 0;

    public String getName() {
        return name;
    }

    public Category setName(String name) {
        this.name = name;
        return this;
    }

    public int getBlogcount() {
        return blogcount;
    }

    public Category setBlogcount(int blogcount) {
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
}
