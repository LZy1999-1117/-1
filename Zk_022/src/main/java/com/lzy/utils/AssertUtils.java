package com.lzy.utils;

import java.util.Collection;
import java.util.Map;

public class AssertUtils{
	
	
	
	/*
	 * 1.断言为真
	 * @param flag 
	 * @param message 
	 * */
	public static void isTrue(boolean flag,String message){
		
		if(!flag){
			throw new CRuntimeException(message);
		}
	}
	
	
	/*
	 * 1.断言为假
	 * @param flag 
	 * @param message 
	 * */
	public static void isFalse(boolean flag,String message){
		if(flag){
			throw new CRuntimeException(message);
		}
	}
	
	
	
	/*
	 * 3.断言不为空
	 * @param flag 
	 * @param message 
	 * */
	public static void isNull(Object obj,String messgae){
		if(obj==null){
			throw new CRuntimeException(messgae);
		}
		
	}
	
	/*
	 * 4.断言为空
	 * @param flag 
	 * @param message 
	 * */
	
	public static void isFNull(Object obj,String messgae){
		if(obj!=null){
			throw new CRuntimeException(messgae);
		}
		
	}
	
	/**
	 * 5. 断言 List 或 Set 集合不为空，没有元素也算空
	 * @param exp 为true或者false
	 * @param message 为错误信息
	 */
	public static void isCollection(Collection<?> col,String message){
		if(col==null ||col.size()==0){
			throw new CRuntimeException(message);
		}
	}
	
	/**
	 * 6. 断言 Map集合不为空，没有元素也算空
	 * @param exp 为true或者false
	 * @param message 为错误信息
	 */
	public static void isMap(Map<?, ?> map,String message){
		if(map==null ||map.size()==0){
			throw new CRuntimeException(message);
		}
	}
	
	/**
	 * 7. 断言字符串必须有值 去掉空格后 长度必须大于0
	 * @param exp 为true或者false
	 * @param message 为错误信息
	 */
	
	public  static void isLength(String str,String message){
		if(!(str.trim().length()>0)){
			throw new CRuntimeException(message);
		}
	}
	
	

	/**
	 * 8. 断言值必须是正数  大于0
	 * @param exp 为true或者false
	 * @param message 为错误信息
	 */
	public static void isNum(int num,String message){
		if(num<=0){
			throw new CRuntimeException(message);
		}
	}
}
