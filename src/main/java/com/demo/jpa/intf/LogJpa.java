package com.demo.jpa.intf;

import com.demo.entity.Log;

import java.util.List;

/**
 * Created by yy on 2016/3/18.
 */
public interface LogJpa {
    List<Log> getLogs();

    void addLog(int userid, String operate);
}
