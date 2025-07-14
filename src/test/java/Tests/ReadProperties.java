package Tests;

import Utilities.ProjUtil;

import java.util.Properties;

public class ReadProperties {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Properties getprops = ProjUtil.readTestData("Config.properties");
		
		System.out.println(getprops.get("Test_URL"));
		System.out.println(getprops.get("Username"));
		System.out.println(getprops.get("Password"));
		
		

	}

}
