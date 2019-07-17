package com.bw.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	
	
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Date date = new Date();
		String localeString = date.toLocaleString();
		System.out.println(localeString);
		Date date2 = new Date(2020, 12, 11);
		
	}
	
	
	//根据传入的日期获取年龄
	@SuppressWarnings("deprecation")
	public static int getAge (Date src) {
		Date date = new Date(2019, 7, 17);
		int year = date.getYear();
		System.out.println(year);
		int year2 = src.getYear();
		System.out.println(year2);
		int age=year-year2;
		System.out.println(age);
		return age;
	}
	
	
	//根据传入的参数获取该日期的月初日期，例如给定的日期为“2019-09-19 19:29:39”，返回“2019-09-01 00:00:00”
	@SuppressWarnings("deprecation")
	public static Date getDateByMonthInit (Date src) {
		int year = src.getYear();
		int month = src.getMonth();
		src.setYear(2019);
		src.setMonth(9-19);
		src.setHours(00);
		System.out.println(src);
	/*	SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd");
		String format2 = format.format(src);
		System.out.println(format2);*/
		return src;
	}

	//根据传入的参数获取该日器的月末日期，例如给定的日期为“2019-09-19 19:29:39”，返回“2019-09-30 23:59:59”，注意月大月小以及闰年。
	public static Date getDateByMonthLast(Date src) {
		src.setYear(2019);
		src.setMonth(9-30);
		src.setHours(11);
		src.setMinutes(59);
		System.out.println(src);
		return src;
	}
	
	
	//求未来日期离今天还剩的天数
	public static int getDaysByFuture (Date future) {
		Date date = new Date();
		long time = date.getTime();
		System.out.println(time);
		return 1;
	}
	
	
	
	//求过去日期离今天过去的天数
	public static int getDaysByDeparted (Date departed) {
		Date date = new Date();
		long time = date.getTime();
		System.out.println(time);
		return 1;
	}
}
