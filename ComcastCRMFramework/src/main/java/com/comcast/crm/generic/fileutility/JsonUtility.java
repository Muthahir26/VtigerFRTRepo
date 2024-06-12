package com.comcast.crm.generic.fileutility;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonUtility {

	public String getDataFromJsonFile(String key) throws Throwable {
		FileReader fileR=new FileReader("./configAppData/appCommonData.JSON");
		JSONParser p=new JSONParser();
		Object obj = p.parse(fileR);
		JSONObject map= (JSONObject) obj ;
		String data=(String) map.get(key);  
		return data;
	}
}
