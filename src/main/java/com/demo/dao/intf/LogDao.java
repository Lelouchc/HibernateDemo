package com.demo.dao.intf;

import com.demo.entity.Log;

import java.util.List;

/**
 * Created by yy on 2016/3/14.
 */
public interface LogDao {
    /**
     * 获取日志列表（全部）
     *
     * @return
     */
    List<Log> getLogs();

    /**
     * 获取日志列表（单个用户）
     *
     * @param userid 用户ID
     * @return
     */
    List<Log> getLogs(int userid);

    /**
     * 获取日志列表（时间范围内）
     *
     * @param datePre
     * @param dateSub
     * @return
     */
    List<Log> getLogs(String datePre, String dateSub);

    /**
     * 新增日志
     *
     * @param log 日志对象
     * @return
     */
    void addLog(Log log);

    /**
     * 新增日志（当前时间）
     *
     * @param userid  用户ID
     * @param operate 操作
     * @return
     */
    void addLog(int userid, String operate);

    /**
     * 新增日志（指定时间）
     *
     * @param userid     用户ID
     * @param operate    操作
     * @param createtime 创建时间
     * @return
     */
    void addLog(int userid, String operate, String createtime);
}
