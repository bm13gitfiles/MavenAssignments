package Selenium;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserActions {

	public static void main(String[] args) {
		
		
		// Launch the Browser
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		
		
		//Minimize the browser window
		
		driver.manage().window().minimize();
		
		//Maximize to specific dimension
		
		driver.manage().window().setSize(new Dimension(375,667));
		
		//Maximize to full 
		
		driver.manage().window().maximize();
		
		//Delete all browser cookies
		driver.manage().deleteAllCookies();
		
		//Launch the app for the first time use driver.get, to navigate driver.navigate
		driver.get("https://www.google.com");
		driver.navigate().to("https://store.google.com/in/?utm_source=hp_header&utm_medium=google_ooo&utm_campaign=GS100042&hl=en-IN");
		
		//get title
		String actual = driver.getTitle();
		String expected = "Google Store for Google Made Devices & Accessories";
		
		Assert 
		
		
		

	}

}
