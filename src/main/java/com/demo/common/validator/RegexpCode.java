package com.demo.common.validator;

/**
 * Created by yy on 2016/3/16.
 */
public class RegexpCode {
    /** 手机号格式 */
    public static final String PHONE_CODE = "^|(1[34578])\\d{9}$";
    /** 日期格式 */
    public static final String DATE_CODE = "^|(\\d{3}[1-9]|\\d{2}[1-9]\\d|\\d[1-9]\\d{2}|[1-9]\\d{3})-((0[1-9]|[1-9])|1[1,2])-(\\d|[0-2]\\d|3[0,1])$";
    /** 时间格式 */
    public static final String TIME_CODE = "^|((\\d{3}[1-9]|\\d{2}[1-9]\\d|\\d[1-9]\\d{2}|[1-9]\\d{3})-((0[1-9]|[1-9])|1[1,2])-(\\d|[0-2]\\d|3[0,1]) (\\d|[0,1]\\d|2[0-3]):(\\d|[0-5]\\d):(\\d|[0-5]\\d))$";
}
