package com.demo.model;

import com.demo.common.validator.RegexpCode;
import com.demo.entity.Blog;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Pattern;

/**
 * Created by yy on 2016/3/16.
 */
public class BlogModel {
    private int id;
    @NotEmpty(message = "{user.login.error}")
    private int userid;
    @NotEmpty(message = "{blog.title.null}")
    private String title;
    @Length(min = 10, message = "{blog.content.limit}")
    private String content;
    @Pattern(regexp = RegexpCode.TIME_CODE, message = "{common.createtime.format}")
    private String createtime;
    private String category;

    public int getId() {
        return id;
    }

    public BlogModel setId(int id) {
        this.id = id;
        return this;
    }

    public int getUserid() {
        return userid;
    }

    public BlogModel setUserid(int userid) {
        this.userid = userid;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public BlogModel setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getContent() {
        return content;
    }

    public BlogModel setContent(String content) {
        this.content = content;
        return this;
    }

    public String getCreatetime() {
        return createtime;
    }

    public BlogModel setCreatetime(String createtime) {
        this.createtime = createtime;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public BlogModel setCategory(String category) {
        this.category = category;
        return this;
    }

    @Override
    public String toString() {
        return "博客{" +
                "标题：'" + title + '\'' +
                ", 内容：'" + content.substring(0, 20) + '\'' +
                ", 创建时间：'" + createtime + '\'' +
                ", 类别：'" + category + '\'' +
                '}';
    }

    public Blog cloneToBlog(){
        return new Blog()
                .setId(id)
                .setUserid(userid)
                .setTitle(title)
                .setContent(content)
                .setCreatetime(createtime)
                .setCategory(category);
    }
}
