package com.lzy.test;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;

import com.lzy.utils.AssertUtils;

public class AssertTest {
	
	private Object obj;
		

	
	@Test
	public void Test(){
		try {
			AssertUtils.isTrue(false,"这不是个true");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void Test02(){
		try {
			AssertUtils.isFalse(true,"这是个true");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void Test03(){
		try {
			AssertUtils.isNull(obj,"这是个对象");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void Test04(){
		try {
			AssertUtils.isNull(null,"这是个空对象");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void Test05(){
		try {
			ArrayList<Integer> list = new ArrayList<Integer>();
			list.add(5);
			AssertUtils.isCollection(list, "是为空的集合");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void Test06(){
		try {
			HashMap<String,Object> hashMap = new HashMap<String,Object>();
		
			AssertUtils.isMap(hashMap, "是为空的MAP集合");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void Test07(){
		try {

			AssertUtils.isLength("", "是为空的字符串");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void Test08(){
		try {

			AssertUtils.isNum(-1,"该数小于0");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
