package com.prestashop.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configuration {

	//private Configuration() {} // no one can mess with this class
	private static Properties properties= new Properties();
	
	static {
		
		try {
			 
			FileInputStream inputStream= new FileInputStream("./configuration.properties");
			properties.load(inputStream);
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
	
		}
		
		
		
	}
	
	public static String getProperty(String key) {
		
		return properties.getProperty(key); 
	}
	
	
}
