package com.bw.utils;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class StreamUtil {

	static Scanner scanner = new Scanner(System.in);
	
	@SuppressWarnings("resource")
	public static void closeAll(FileInputStream fis) throws IOException {
		//TODO
		
		
		fis.close();
	}
	
	
	@SuppressWarnings("resource")
	public static void copy(InputStream src, OutputStream out, boolean isCloseInputStream, boolean isCloseOutputStream)  throws IOException{
	
		byte[] by=new byte[16*3];
		int count=0;
		while ((count=src.read(by))!=-1) {
			System.out.println();
			
			out.write(by, 0, count);
			out.flush();
		}
		src.close();
		out.close();
		
		BufferedReader br = new BufferedReader(new FileReader(new File("E:/copy.txt")));
		char[] ch=new char[8*8];
		String temp=null;
		while((temp=br.readLine())!=null){
			System.out.println(temp);
		}
		br.close();
		/*String readLine = br.readLine();
		System.out.println(readLine);*/
	}
	
	
	public static String readTextFile(InputStream src1) throws IOException{
		FileOutputStream fileOutputStream = new FileOutputStream(new File("E:/copy.txt"));
		StreamUtil.copy(src1,fileOutputStream,true, true);
		
		return "1";
	}
	
	
	public static String readTextFile(File txtFile) throws FileNotFoundException, IOException{
		FileInputStream fileInputStream = new FileInputStream(txtFile);
		return StreamUtil.readTextFile(fileInputStream);
	}
	
	
	public static String readStringFromSystemIn(String message){
		String next = scanner.next();
		System.out.println(next);
		return next;
		
	}
	
	
	public static int readIntFromSystemIn(String message){
		return 0;
		//TODO
		}
}
