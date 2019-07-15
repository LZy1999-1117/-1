package com.lzy.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;

import com.lzy.utils.ArrsertUtil;

public class TestArrsert {
	
	private static Object obj;
	public static void main(String[] args) {
//		ArrsertUtil.isTrue(false,"断言为假,抛出异常");
//		ArrsertUtil.isFalse(true,"断言为真,抛出异常");
		
//		ArrsertUtil.notNull(obj,"断言为空,抛出异常");
		
//		ArrsertUtil.isNull("1","断言不为空,抛出异常");
		
		BigDecimal bigDecimal = new BigDecimal(0);
		ArrsertUtil.greaterThanZero(bigDecimal,"断言值为0或小于0,抛出异常");
	}
	
	@Test
	public void Test01(){
		
		ArrsertUtil.isTrue(false,"断言为假,抛出异常");
	}
	
	
	@Test
	public void Test02(){
		
		ArrsertUtil.isFalse(true,"断言为真,抛出异常");
	}
	
	@Test
	public void Test03(){
		
		ArrsertUtil.notNull(obj,"断言为空,抛出异常");
	}
	
	
	@Test
	public void Test04(){
		
		ArrsertUtil.isNull("1","断言不为空,抛出异常");
	}
	
	@Test
	public void Test05(){
		ArrayList<Integer> list = new ArrayList<Integer>();
//		list.add(1);
		ArrsertUtil.notEmpty(list,"断言为空,抛出异常");
	}
	
	@Test
	public void Test06(){
		HashMap<String, Object> map = new HashMap<String, Object>();
//		map.put("c", 1);
		ArrsertUtil.notEmpty(map,"断言为空,抛出异常");
	}
	

	@Test
	public void Test07(){
		
		ArrsertUtil.hasText(" ","断言字符串为空,抛出异常");
	}
	
	
	@Test
	public void Test08(){
		BigDecimal bigDecimal = new BigDecimal(0);
		ArrsertUtil.greaterThanZero(bigDecimal,"断言值为0或小于0,抛出异常");
	}
	
}
