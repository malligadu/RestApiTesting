package com.qa.test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.resthttpclient.RestHttpClient;
import com.qa.testbase.TestBase;

public class ExampleTest extends TestBase{

	public TestBase tb;
	public String uri;
	
	@BeforeMethod
	public void setUp() {
		tb=new TestBase();
		String url=prop.getProperty("url");
		String serviceurl=prop.getProperty("serviceurl");
		
		uri=url+serviceurl;
	}
	
	@Test
	public void testGet() throws Exception {
		RestHttpClient rhc=new RestHttpClient();
		rhc.get(uri);
		
	}
}
