package com.webdriver.framework.DataDrivenFramework.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;

public class ObjectMap {
	Properties properties;
	
	public ObjectMap(String propFile){
		properties = new Properties();
		try {
			FileInputStream in = new FileInputStream(propFile);
			properties.load(in);
			in.close();
		} catch (IOException e) {
			System.out.println("读取文件对象出错");
			e.printStackTrace();
		}
	}
	
	public By getLocator(String ElementNameInpropFile) throws Exception{
		String locator = properties.getProperty(ElementNameInpropFile);
		String locatorType = locator.split(">")[0];
		String locatorValue = locator.split(">")[1];
		locatorValue = new String(locatorValue.getBytes("ISO-8859-1"),"UTF-8");
		
	}
}
