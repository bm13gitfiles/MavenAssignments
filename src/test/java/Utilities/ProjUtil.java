package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ProjUtil {

	public static Properties readTestData(String FileName) {

		Properties props = new Properties();

		try {
			// To read the file using Java classes - FileInputStream

			FileInputStream fileInpStr = new FileInputStream(System.getProperty("user.dir") + "\\Config\\" + FileName);
			 
			
			//Load the properties from Config file
			props.load(fileInpStr);
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return props;

	}

}
