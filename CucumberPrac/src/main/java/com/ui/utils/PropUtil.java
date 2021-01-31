package com.ui.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropUtil {

	private Properties prop;

	public PropUtil() {
		String baseFolder = System.getProperty("user.dir");
		String propFilePath = baseFolder + File.separator + "src\\test\\resources\\config\\application.properties";
		FileInputStream fis;
		try {
			fis = new FileInputStream(propFilePath);
			prop = new Properties();
			prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Properties getPropObj() {
		return prop;

	}

}
