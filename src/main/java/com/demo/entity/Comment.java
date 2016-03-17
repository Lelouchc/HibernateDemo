package com.demo.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by yy on 2016/3/11.
 * 回复表
 */
@Entity
@Table(name = "t_comment")
public class Comment {
    /**
     * 主键
     */
    @EmbeddedId
    private CommentPK commentPK;
    /**
     * 回复内容
     */
    @Column(columnDefinition = "text")
    @Length(min = 10, message = "{comment.content.limit}")
    private String content;
    /**
     * 引用回复ID
     */
    @Column
    private int commentid;

    public CommentPK getCommentPK() {
        return commentPK;
    }

    public Comment setCommentPK(CommentPK commentPK) {
        this.commentPK = commentPK;
        return this;
    }

    public String getContent() {
        return content;
    }

    public Comment setContent(String content) {
        this.content = content;
        return this;
    }

    public int getCommentid() {
        return commentid;
    }

    public Comment setCommentid(int commentid) {
        this.commentid = commentid;
        return this;
    }

    @Override
    public String toString() {
        return commentPK.toString();
    }
}
