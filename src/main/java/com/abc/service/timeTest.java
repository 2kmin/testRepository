package com.abc.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class timeTest {

    public void timeTestService() throws ParseException {

        String targetStr = "2022-5-16 23:59:59";

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date date = format.parse(targetStr);

        System.out.println(date);

    }
}
