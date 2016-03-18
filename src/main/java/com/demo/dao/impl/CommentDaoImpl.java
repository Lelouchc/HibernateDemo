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
        return this.getEntityManager()
                .createQuery("from Comment c where c.blogid=:blogid", Comment.class)
                .setParameter("blogid", blogid)
                .getResultList();
    }

    @Override
    public List<Comment> getCommentsForUser(int userid) {
        return this.getEntityManager()
                .createQuery("from Comment c where c.userid=:userid", Comment.class)
                .setParameter("userid", userid)
                .getResultList();
    }

    @Override
    public Comment getComment(int commentid) {
        return this.getEntityManager()
                .createQuery("from Comment c where c.id=:commentid", Comment.class)
                .setParameter("commentid", commentid)
                .getSingleResult();
    }

    @Override
    public void addComment(Comment comment) {
        this.getEntityManager()
                .persist(comment);
    }

    @Override
    public boolean delComment(Comment comment) {
        try {
            this.getEntityManager()
                    .createQuery("delete from Comment c where c.userid=:userid and c.blogid=:blogid and c.createtime=:createtime")
                    .setParameter("userid", comment.getCommentPK().getUserid())
                    .setParameter("blogid", comment.getCommentPK().getBlogid())
                    .setParameter("createtime", comment.getCommentPK().getCreatetime())
                    .executeUpdate();
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
