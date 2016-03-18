package com.demo.dao.impl;

import com.demo.common.SystemUtil;
import com.demo.dao.intf.LogDao;
import com.demo.entity.Log;
import org.springframework.stereotype.Repository;

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
        return this.getEntityManager()
                .createQuery("select new Log(l.id,l.userid,l.operate,l.createtime,u.username) from Log l,User u where l.userid = u.id", Log.class)
                .getResultList();
    }

    @Override
    public List<Log> getLogs(int userid) {
        return this.getEntityManager()
                .createQuery("select new Log(l.id,l.userid,l.operate,l.createtime,u.username) from Log l,User u where l.userid = u.id and l.userid=:userid", Log.class)
                .setParameter("userid", userid)
                .getResultList();
    }

    @Override
    public List<Log> getLogs(String datePre, String dateSub) {
        return this.getEntityManager()
                .createQuery("select new Log(l.id,l.userid,l.operate,l.createtime,u.username) from Log l,User u where l.userid = u.id and l.createtime between :datePre and :dateSub", Log.class)
                .setParameter("datePre", datePre)
                .setParameter("dateSub", dateSub)
                .getResultList();
    }

    @Override
    public void addLog(Log log) {
        this.getEntityManager()
                .persist(log);
    }

    @Override
    public void addLog(int userid, String operate) {
        this.getEntityManager()
                .persist(new Log()
                        .setUserid(userid)
                        .setOperate(operate)
                        .setCreatetime(SystemUtil.TIME_NOW));
    }

    @Override
    public void addLog(int userid, String operate, String createtime) {
        this.getEntityManager()
                .persist(new Log()
                        .setUserid(userid)
                        .setOperate(operate)
                        .setCreatetime(createtime));
    }
}
