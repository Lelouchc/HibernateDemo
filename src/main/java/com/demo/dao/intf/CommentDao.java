package com.demo.dao.intf;

import com.demo.entity.Comment;

import java.util.List;

/**
 * Created by yy on 2016/3/12.
 */
public interface CommentDao {
    /**
     * 查询取选中博客的所有评论信息
     *
     * @param blogid 博客ID
     * @return
     */
    List<Comment> getCommentsForBlog(int blogid);

    /**
     * 查询你登陆用户的所有评论
     *
     * @param userid 用户ID
     * @return
     */
    List<Comment> getCommentsForUser(int userid);

    /**
     * 查询单条评论信息
     *
     * @param commentid 评论ID
     * @return
     */
    Comment getComment(int commentid);

    /**
     * 添加评论
     *
     * @param comment 待添加评论信息
     * @return
     */
    boolean addComment(Comment comment);

    /**
     * 更新评论信息
     *
     * @param comment 待更新评论信息
     * @return
     */
    boolean updComment(Comment comment);

    /**
     * 删除评论信息
     *
     * @param comment 待删除评论信息
     * @return
     */
    boolean delComment(Comment comment);
}
