package com.demo.common;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by yy on 2016/3/11.
 */
public final class SystemUtil {
    public static String ENCRYPT = "simpleTour";

    public static DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    public static String DATE_NOW = DATE_FORMAT.format(new Date());

    public static DateFormat TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String TIME_NOW = TIME_FORMAT.format(new Date());
}
