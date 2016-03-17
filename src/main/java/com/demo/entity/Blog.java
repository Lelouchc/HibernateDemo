package com.demo.entity;

import javax.persistence.*;

/**
 * Created by yy on 2016/3/11.
 * 博客表
 */
@Entity
@Table(name = "t_blog")
@SequenceGenerator(name = "blog_seq", sequenceName = "blog_seq", initialValue = 1, allocationSize = 1)
public class Blog {
    /**
     * 博客ID
     */
    @Id
    @Column(insertable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "blog_seq")
    private int id;
    /**
     * 用户ID
     */
    @Column
    private int userid;
    /**
     * 标题
     */
    @Column(length = 50)
    private String title;
    /**
     * 内容
     */
    @Column(columnDefinition = "text")
    private String content;
    /**
     * 创建时间
     */
    @Column(length = 20)
    private String createtime;
    /**
     * 所属类别
     */
    @Column(length = 10)
    private String category;

    public int getId() {
        return id;
    }

    public Blog setId(int id) {
        this.id = id;
        return this;
    }

    public int getUserid() {
        return userid;
    }

    public Blog setUserid(int userid) {
        this.userid = userid;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Blog setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getContent() {
        return content;
    }

    public Blog setContent(String content) {
        this.content = content;
        return this;
    }

    public String getCreatetime() {
        return createtime;
    }

    public Blog setCreatetime(String createtime) {
        this.createtime = createtime;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public Blog setCategory(String category) {
        this.category = category;
        return this;
    }

    @Override
    public String toString() {
        return "博客{" +
                "标题：'" + title + '\'' +
                ", 内容：'" + content.substring(0, 20) + '\'' +
                ", 创建时间：'" + createtime + '\'' +
                ", 所属类别：'" + category + '\'' +
                '}';
    }
}
