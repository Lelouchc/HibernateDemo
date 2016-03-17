package com.demo.entity;

import com.demo.common.validator.RegexpCode;

import javax.persistence.Column;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Objects;

/**
 * Created by yy on 2016/3/11.
 * 回复主键类
 */
public class CommentPK implements Serializable {
    /**
     * 用户ID
     */
    private int userid;
    /**
     * 文章ID
     */
    private int blogid;
    /**
     * 回复时间
     */
    @Column(length = 20)
    @Pattern(regexp = RegexpCode.TIME_CODE, message = "{common.createtime.format}")
    private String createtime;

    public int getUserid() {
        return userid;
    }

    public CommentPK setUserid(int userid) {
        this.userid = userid;
        return this;
    }

    public int getBlogid() {
        return blogid;
    }

    public CommentPK setBlogid(int blogid) {
        this.blogid = blogid;
        return this;
    }

    public String getCreatetime() {
        return createtime;
    }

    public CommentPK setCreatetime(String createtime) {
        this.createtime = createtime;
        return this;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof CommentPK) {
            CommentPK pk = (CommentPK) obj;
            if (this.userid == pk.getUserid() && this.blogid == pk.getBlogid() && Objects.equals(this.createtime, pk.getCreatetime())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "用户ID：" + userid + " 文章ID：" + blogid + " 创建时间：" + createtime;
    }
}
