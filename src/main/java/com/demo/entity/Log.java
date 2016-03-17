package com.demo.entity;

import com.demo.common.validator.RegexpCode;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

/**
 * Created by yy on 2016/3/12.
 * 操作日志表
 */
@Entity
@Table(name = "t_log")
@SequenceGenerator(name = "log_seq", sequenceName = "log_seq", initialValue = 1, allocationSize = 1)
public class Log {
    public Log() {}

    public Log(int id, int userid, String operate, String createtime, String username) {
        this.id = id;
        this.userid = userid;
        this.operate = operate;
        this.createtime = createtime;
        this.username = username;
    }

    /**
     * 操作日志ID
     */
    @Id
    @Column(insertable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "log_seq")
    private int id;
    /**
     * 用户ID
     */
    @Column
    private int userid;
    /**
     * 操作
     */
    @Column(length = 100)
    private String operate;
    /**
     * 创建时间
     */
    @Column(length = 20)
    @Pattern(regexp = RegexpCode.TIME_CODE, message = "{common.createtime.format}")
    private String createtime;
    /**
     * 用户名
     */
    @Transient
    private String username;

    public int getId() {
        return id;
    }

    public Log setId(int id) {
        this.id = id;
        return this;
    }

    public int getUserid() {
        return userid;
    }

    public Log setUserid(int userid) {
        this.userid = userid;
        return this;
    }

    public String getOperate() {
        return operate;
    }

    public Log setOperate(String operate) {
        this.operate = operate;
        return this;
    }

    public String getCreatetime() {
        return createtime;
    }

    public Log setCreatetime(String createtime) {
        this.createtime = createtime;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public Log setUsername(String username) {
        this.username = username;
        return this;
    }

    @Override
    public String toString() {
        return id + ": [" + createtime + "] [" + username + "] " + operate;
    }
}
