package com.doctorAdvice.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TableProperties {
	private static final String proPath = "config/table_struct.properties";
	public static final Properties tableStruct = new Properties();
	static {
		try {
			InputStream is = new FileInputStream(proPath);
			tableStruct.load(is);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
