package com.qa.resthttpclient;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class RestHttpClient {
	
	public void get(String url) throws ClientProtocolException, IOException, JSONException {
		CloseableHttpClient chclient=HttpClients.createDefault();
		HttpGet hget=new HttpGet(url);
		CloseableHttpResponse chresponse=chclient.execute(hget);
		
		int statuscode=chresponse.getStatusLine().getStatusCode();
		System.out.println(statuscode);
		
		String resString=EntityUtils.toString(chresponse.getEntity(), "UTF-8");
		
		
		JSONObject jobj=new JSONObject(resString);
		System.out.println(jobj);
		
		Header[] header=chresponse.getAllHeaders();
		Map<String,String> m=new HashMap();
		for(Header h:header) {
			m.put(h.getName(), h.getValue());
		}
		System.out.println(m);
	}

}
