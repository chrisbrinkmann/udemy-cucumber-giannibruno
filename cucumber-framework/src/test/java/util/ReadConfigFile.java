package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadConfigFile {

	protected InputStream inputStream = null;
	protected Properties prop = null;
	
	public ReadConfigFile() {
		try {
			inputStream = new FileInputStream(Constant.CONFIG_PROPERTIES_DIRECTORY + "/config.properties");
			prop = new Properties();
			prop.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getBrowserName() {
		if(prop.getProperty("browser.name") == null) {
			return "";
		}
		return prop.getProperty("browser.name");
	}

	public String getProperty(String prop_name) {
		if(prop.getProperty(prop_name) == null) {
			return "";
		}
		
		return prop.getProperty(prop_name);
	}
}
