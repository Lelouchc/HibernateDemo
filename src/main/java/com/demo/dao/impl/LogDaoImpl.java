package com.demo.dao.impl;

import com.demo.common.SystemUtil;
import com.demo.dao.intf.LogDao;
import com.demo.entity.Log;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * Created by yy on 2016/3/14.
 * 日志操作数据处理
 */
@SuppressWarnings({"JpaQlInspection", "unchecked"})
@Repository
public class LogDaoImpl extends BaseDao implements LogDao {
    @Override
    public List<Log> getLogs() {
        return this.getSessionFactory().getCurrentSession()
                .createQuery("select new Log(l.id,l.userid,l.operate,l.createtime,u.username) from Log l,User u where l.userid = u.id")
                .list();
    }

    @Override
    public List<Log> getLogs(int userid) {
        return this.getSessionFactory().getCurrentSession()
                .createQuery("select new Log(l.id,l.userid,l.operate,l.createtime,u.username) from Log l,User u where l.userid = u.id and l.userid=:userid")
                .setParameter("userid", userid)
                .list();
    }

    @Override
    public List<Log> getLogs(String datePre, String dateSub) {
        return this.getSessionFactory().getCurrentSession()
                .createQuery("select new Log(l.id,l.userid,l.operate,l.createtime,u.username) from Log l,User u where l.userid = u.id and l.createtime between :datePre and :dateSub")
                .setParameter("datePre", datePre)
                .setParameter("dateSub", dateSub)
                .list();
    }

    @Override
    public Serializable addLog(Log log) {
        return this.getSessionFactory().getCurrentSession()
                .save(log);
    }

    @Override
    public Serializable addLog(int userid, String operate) {
        return this.getSessionFactory().getCurrentSession()
                .save(new Log()
                        .setUserid(userid)
                        .setOperate(operate)
                        .setCreatetime(SystemUtil.TIME_NOW));
    }

    @Override
    public Serializable addLog(int userid, String operate, String createtime) {
        return this.getSessionFactory().getCurrentSession()
                .save(new Log()
                        .setUserid(userid)
                        .setOperate(operate)
                        .setCreatetime(createtime));
    }
}
