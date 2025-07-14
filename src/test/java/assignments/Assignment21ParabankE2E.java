package assignments;


import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Assignment21ParabankE2E {

	static WebDriver driver;
	static WebElement webElement;

	public static void main(String[] args) throws InterruptedException {

//		1. Launch browser window

		driver = new ChromeDriver();

//		2. Maximize the browser window

		driver.manage().window().maximize();

//		3. Delete all the cookies

		driver.manage().deleteAllCookies();

//		4. Enter URL and Launch the application (https://parabank.parasoft.com/parabank/index.htm)

		driver.get("https://parabank.parasoft.com/parabank/index.htm");

		Thread.sleep(3000);

//		5. Verify application title

		String actualTitle = driver.getTitle();
		String expectedTitle = "ParaBank | Welcome | Online Banking";
		Assert.assertTrue(actualTitle.equals(expectedTitle), "Actual title not matched with the Expected title");

//		6. Verify application logo

		WebElement parabankLogo = driver.findElement(By.xpath("//img[@class='logo']"));

		Assert.assertTrue(parabankLogo.isDisplayed(), "Logo is not displayed");

//		7. Verify application caption

		WebElement appCaption = driver.findElement(By.xpath("//p[@class='caption']"));
		String actualCaption = appCaption.getText();
		String expCaption = "Experience the difference";
		Assert.assertEquals(actualCaption, expCaption, "Excepted Caption not displayed");

//		8. Enter Invalid credentials in Username and Password textboxes

		WebElement usernameInput = driver.findElement(By.xpath("//input[@name='username']"));
		WebElement passwordInput = driver.findElement(By.xpath("//input[@name='password']"));

		// Clear and enter values

		usernameInput.clear();
		passwordInput.clear();

		usernameInput.sendKeys("");
		passwordInput.sendKeys("");

//		9. Click on Login Button

		WebElement loginButton = driver.findElement(By.xpath("//input[@value='Log In']"));
		loginButton.click();

//		10. Verify error message is displayed (The username and password could not be verified.)

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		WebElement errorMessage = driver.findElement(By.xpath("//p[@class='error']"));

		wait.until(ExpectedConditions.visibilityOf(errorMessage));

		String errorMessagetext = errorMessage.getText();

		System.out.println("Error message text = " + errorMessagetext);

//		11. Click on Adminpage link

		WebElement adminpageLink = driver.findElement(By.xpath("//ul[@class='leftmenu']//li//a[@href='admin.htm']"));

		adminpageLink.click();

//		12. Wait for admin page

		WebElement adminPageTitle = driver.findElement(By.xpath("//h1[contains(text(),'Admin')]"));

		wait.until(ExpectedConditions.visibilityOf(adminPageTitle));

//		13. Select Data access mode as ' SOAP'

		selectAccessMode("soap");

		// driver.quit();

//		14. Scrolldown till Loan provider

		WebElement loanProviderDropdown = driver.findElement(By.xpath("//select[@name='loanProvider']"));

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView(true)", loanProviderDropdown);

//		15. Select Loanprovider as 'Web Service'

		Select select = new Select(loanProviderDropdown);

		select.selectByVisibleText("Web Service");

//		16. Click on Submit button

		WebElement adminFormSubmitButton = driver
				.findElement(By.xpath("//form[@id='adminForm']//input[@value='Submit']"));

		adminFormSubmitButton.click();

//		17.wait for Successful submission message

		WebElement successfulSubMessage = driver.findElement(By.xpath("//div[@id='rightPanel']/p/b"));

		wait.until(ExpectedConditions.visibilityOf(successfulSubMessage));

		System.out.println(successfulSubMessage.getText());

//		18.Click on Services Link

		WebElement servicesLink = driver.findElement(By.xpath("//ul[@class='leftmenu']//li//a[@href='services.htm']"));

		servicesLink.click();

//		19.Wait for Services page

		WebElement bookstoreSOAPtitle = driver.findElement(By.xpath("//span[@class='heading']"));

		wait.until(ExpectedConditions.visibilityOf(bookstoreSOAPtitle));

		System.out.println(bookstoreSOAPtitle.getText());

//		20.Scrolldown till Bookstore services

		WebElement bookStoreTable = driver.findElement(By.xpath("//span[text()='Bookstore services:']"));

		js.executeScript("arguments[0].scrollIntoView(true)", bookStoreTable);

		System.out.println(bookStoreTable.getText());

//		21.Get total rows, columns in the bookstore service table

		List<WebElement> bookstoreServicetableRows = driver
				.findElements(By.xpath("//span[text()='Bookstore services:']/following-sibling::table[1]//tr"));
		List<WebElement> bookstoreServicetableColumns = driver
				.findElements(By.xpath("//span[text()='Bookstore services:']/following-sibling::table[1]//tr[1]//td"));

		System.out.println("Book service Table Rows = " + bookstoreServicetableRows.size());
		System.out.println("Book service Table Columns = " + bookstoreServicetableColumns.size());


		//		22.Get Column headers of book store services table


			for (int cols = 1; cols <= bookstoreServicetableColumns.size(); cols++) {

				WebElement columnsHeader = driver
						.findElement(By.xpath("//span[text()='Bookstore services:']/following-sibling::table[1]//tr[1]//td[" + cols + "]"));
				
				
				System.out.println("Columns Header values are "+columnsHeader.getText());
				
			}




//		23.Get all the data from book store service table

		for (int r = 1; r <= bookstoreServicetableRows.size(); r++) {

			for (int c = 1; c <= bookstoreServicetableColumns.size(); c++) {

				WebElement cell = driver
						.findElement(By.xpath("//span[text()='Bookstore services:']/following-sibling::table[1]//tr["
								+ r + "]//td[" + c + "]"));

				System.out.println("Cell value of " + r + " and " + c + " is " + cell.getText());

			}

		}

//		24.Close browser window

		driver.quit();

		System.out.println("Execution completed");

	}

	public static void selectAccessMode(String Accessmodetype) {

		// soap, restxml, restjson, jdbc

		WebElement radiobutton = driver.findElement(By.xpath("//input[@value='" + Accessmodetype + "']"));

		radiobutton.click();

	}

}
