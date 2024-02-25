package Utilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import Utilities.LoggerLoad;

public class ConfigReader {

	private static Properties pro = null;
	private static void initialize() {



		try {
			pro = new Properties();
			FileReader file;
			file = new FileReader("src/test/resources/Config/Config.properties");
			pro.load(file);
		}catch(IOException e) {
			LoggerLoad.error("Error while loading the properties file."+ e.getMessage());

		}

	}


	public static Properties getProperty() {
		if(pro == null) {
			initialize();
		}
		return pro;
	}
	
	
}
