package com.demo.model;

/**
 * Created by yy on 2016/3/16.
 */
public enum SexType {
    male("男"),female("女");

    private String info;

    private SexType(String info){
        this.info = info;
    }

    public String getSex(){
        return info;
    }

    @Override
    public String toString() {
        return info;
    }
}
