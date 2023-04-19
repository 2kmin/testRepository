package com.abc.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.logging.LogLevel;

@Slf4j
public class LogUtil {

    public static String getClassName(){
        return Thread.currentThread().getStackTrace()[2].getClassName();
    }

    public static String getMethodName(){
        return Thread.currentThread().getStackTrace()[2].getMethodName();
    }

    public static String getPrefix(){
        return Thread.currentThread().getStackTrace()[2].getClassName()
                +"."+Thread.currentThread().getStackTrace()[2].getMethodName();
    }
}
