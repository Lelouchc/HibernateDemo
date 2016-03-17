package com.demo.dao.impl;

import com.demo.entity.Comment;
import com.demo.dao.intf.CommentDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by yy on 2016/3/12.
 * 评论数据
 */
@SuppressWarnings({"JpaQlInspection", "unchecked"})
@Repository
public class CommentDaoImpl extends BaseDao implements CommentDao {
    @Override
    public List<Comment> getCommentsForBlog(int blogid) {
        return this.getSessionFactory().getCurrentSession()
                .createQuery("from Comment c where c.blogid=:blogid")
                .setParameter("blogid", blogid)
                .list();
    }

    @Override
    public List<Comment> getCommentsForUser(int userid) {
        return this.getSessionFactory().getCurrentSession()
                .createQuery("from Comment c where c.userid=:userid")
                .setParameter("userid", userid)
                .list();
    }

    @Override
    public Comment getComment(int commentid) {
        return this.getSessionFactory().getCurrentSession()
                .load(Comment.class, commentid);
    }

    @Override
    public boolean addComment(Comment comment) {
        return (boolean) this.getSessionFactory().getCurrentSession()
                .save(comment);
    }

    @Override
    public boolean updComment(Comment comment) {
        try {
            this.getSessionFactory().getCurrentSession()
                    .saveOrUpdate(comment);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean delComment(Comment comment) {
        try {
            this.getSessionFactory().getCurrentSession()
                    .delete(comment);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
