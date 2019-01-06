package TestingAPI;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.lang3.RandomStringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.Random;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.lang3.RandomStringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.util.Iterator;
import java.util.Random;
import java.util.UUID;


public class sampleRead {

	
	public static void main(String[] args) throws IOException, JSONException {
		
     Random rand = new Random();
     String result = RandomStringUtils.random(32, false, true);
     
     String jsonBody = generateStringFromResource("C:\\Users\\3691713\\Documents\\InputJsons\\Reconcilewaypoint.json");
	 JSONObject jsonObject_result = new JSONObject(jsonBody);
//	 System.out.println("--one-----" + jsonBody);
	 JSONArray waypointTask = jsonObject_result.getJSONArray("waypointTask");
	 
	 for (int i = 0; i < waypointTask.length(); i++) {
         JSONObject jsonObject2 = waypointTask.getJSONObject(i);
//         String taskUUID = jsonObject2.getString("taskUUID");
//         System.out.println("-------"+taskUUID);
         jsonObject2.remove("taskUUID");
         jsonObject2.put("taskUUID",RandomStringUtils.random(32, false, true));
         String taskUUID2 = jsonObject2.getString("taskUUID");
         jsonObject_result.toString();        
	   }
	 
	System.out.println("is it?" + jsonObject_result);

	}
	
	 public static String generateStringFromResource(String path) throws IOException {

		    return new String(Files.readAllBytes(Paths.get(path)));

		}
}
