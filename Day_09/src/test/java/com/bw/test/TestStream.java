package com.bw.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;

import com.bw.utils.StreamUtil;

public class TestStream {
	
	
	@Test
	public void Test01() throws IOException{
		
		FileInputStream fileInputStream = new FileInputStream(new File("E:/file.txt"));
	
		FileOutputStream fileOutputStream = new FileOutputStream(new File("E:/copy.txt"));
		StreamUtil.copy(fileInputStream, fileOutputStream, true, true);
	}
	
	
	@Test
	public void Test02() throws IOException{
		FileInputStream fileInputStream = new FileInputStream(new File("E:/file.txt"));
		StreamUtil.readTextFile(fileInputStream);
		StreamUtil.closeAll(fileInputStream);
	}
	
	
	@Test
	public void Test03() throws FileNotFoundException, IOException{
		StreamUtil.readTextFile(new File("E:/file.txt"));
	}
}
