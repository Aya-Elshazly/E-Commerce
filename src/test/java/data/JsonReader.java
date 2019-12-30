package data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonReader {
	public String fname,lname,email,password;
	
	public void jsonReader() throws FileNotFoundException, IOException, ParseException{
		String filePath=System.getProperty("user.dir")+"\\src\\test\\java\\data\\UserData.json";
		File srcfile=new File(filePath);
		JSONParser parser=new JSONParser();
		JSONArray jarray=(JSONArray)parser.parse(new FileReader(srcfile));
		
		for(Object jsonObject:jarray){
			JSONObject person=(JSONObject)jsonObject;
			fname=(String) person.get("firstname");
			lname=(String) person.get("lastname");
			email=(String) person.get("email");
			password=(String) person.get("password");
		}
	}

}
