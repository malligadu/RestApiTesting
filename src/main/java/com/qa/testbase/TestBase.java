package com.qa.testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestBase {
	
	public Properties prop;
	 public TestBase() {
		 prop=new Properties();
		 try {
			FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/qa/config/config.properties");          
		    prop.load(fis);
		 } catch (FileNotFoundException e) {
		
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		 
	 }

}
