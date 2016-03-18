package com.demo.jpa.impl;

import com.demo.common.SystemUtil;
import com.demo.entity.Log;
import com.demo.jpa.intf.LogJpa;
import org.springframework.stereotype.Repository;

import javax.persistence.FlushModeType;
import java.util.List;

/**
 * Created by yy on 2016/3/18.
 */
@SuppressWarnings("JpaQlInspection")
@Repository
public class LogJpaImpl extends BaseJpa implements LogJpa {
    @Override
    public List<Log> getLogs() {
        System.out.println(getEntityManager());
        return getEntityManager().createQuery("from Log l", Log.class).getResultList();
    }

    @Override
    public void addLog(int userid, String operate) {
        getEntityManager().setFlushMode(FlushModeType.COMMIT);
        getEntityManager().persist(new Log()
                .setUserid(userid)
                .setOperate(operate)
                .setCreatetime(SystemUtil.TIME_NOW));
    }
}
