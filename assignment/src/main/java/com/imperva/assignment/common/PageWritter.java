package com.imperva.assignment.common;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.json.JSONArray;
import org.json.JSONObject;

import com.inperva.assignment.App;
/**
 * @author Debamrita
 */
public class PageWritter {
	private String fileLocation;
	private String node;
	public void setJson(JSONObject json) {
		fileLocation = getProperties("FileLocation");
		try {
	          File newTextFile = new File(fileLocation+new SimpleDateFormat("MMddyyyyHHmmsss").format(new Date())+".json");
	          FileWriter fw = new FileWriter(newTextFile);
	          fw.write(json.toString());
	          fw.close();

	      } catch (IOException iox) {
	          iox.printStackTrace();
	      }
	}
	
	public String getProperties(String param) {
		//Properties prop = new Properties();
		File configFile = new File("config.properties");
		String propertyValue = null; 
		try {
		    FileReader reader = new FileReader(configFile.getAbsoluteFile());
		    Properties props = new Properties();
		    props.load(reader);
		    propertyValue = props.getProperty(param);
		    reader.close();
		} catch (FileNotFoundException ex) {
		    // file does not exist
		} catch (IOException ex) {
		    // I/O error
		}
		return propertyValue;
	}
	

}
