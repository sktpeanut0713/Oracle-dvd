package com.TC25.tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigTest {

	public static void main(String[] args) {

		try {
			//构建properties对象
			Properties p = new Properties();

			File file = new File("config/config.properties");

			InputStream is = new FileInputStream(file);

			p.load(is);
			
			String driver = p.getProperty("DRIVER");
			String url = p.getProperty("URL");
			String user = p.getProperty("USER");
			String pwd = p.getProperty("PWD");
			
			System.out.println("Driver:\t"+driver);
			System.out.println("url:\t"+url);
			System.out.println("user:\t"+user);
			System.out.println("pwd:\t"+pwd);
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
