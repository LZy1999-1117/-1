package com.bw.test;

import java.util.Date;

import org.junit.Test;

import com.bw.utils.DateUtil;

public class TestUtil {
	
	
	@Test
	public void Test01(){
		Date date = new Date(1999, 9, 19);
		DateUtil.getAge(date);
	}
	
	
	
	@Test
	public void Test02(){
		Date date = new Date(2019, 9, 19);
		DateUtil.getDateByMonthInit(date);
	}
	

	@Test
	public void Test03(){
		Date date = new Date(2019, 9, 19);
		DateUtil.getDateByMonthLast(date);
	}
}
