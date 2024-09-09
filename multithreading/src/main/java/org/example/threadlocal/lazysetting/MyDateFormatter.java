package org.example.threadlocal.lazysetting;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyDateFormatter {

    private final ThreadLocal<SimpleDateFormat> threadLocal = new ThreadLocal<>();

    public String format(Date date) {
        SimpleDateFormat simpleDateFormat = getThreadLocalSimpleDateFormat();
        return simpleDateFormat.format(date);
    }


    private SimpleDateFormat getThreadLocalSimpleDateFormat() {
        SimpleDateFormat simpleDateFormat = threadLocal.get();
        if(simpleDateFormat == null) {
            simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            threadLocal.set(simpleDateFormat);
        }
        return simpleDateFormat;
    }
}
