package december30;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateAccounts {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//enter the url
		driver.get("https://login.salesforce.com/");
		//Enter the username and password
		driver.findElement(By.id("username")).sendKeys("earth@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Bootcamp@123");
		//click the login button
		driver.findElement(By.id("Login")).click();
		//click the toggle button
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		//click the view all button
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		//click the sales option
		driver.findElement(By.xpath("//p[text()='Manage your sales process with accounts, leads, opportunities, and...']")).click();
		//click the accounts tab
		WebElement accounts = driver.findElement(By.xpath("//span[text()='Accounts']"));
		 driver.executeScript("arguments[0].click();", accounts);
		 //click the new button
		 driver.findElement(By.xpath("(//div[text()='New'])[1]")).click();
		 //enter the account name
		 Thread.sleep(8000);
		 driver.findElement(By.xpath("(//label[@class='slds-form-element__label slds-no-flex']/following::input)[1]")).sendKeys("Pradeepkumar N");
		 //select ownership 
		 WebElement owner = driver.findElement(By.xpath("(//label[text()='Ownership']/following::input)[1]"));
		 driver.executeScript("arguments[0].click();", owner);
		 WebElement pub = driver.findElement(By.xpath("//span[@title='Public']"));
		 driver.executeScript("arguments[0].click();", pub);
		 //click the save button
		 WebElement save = driver.findElement(By.xpath("//button[@name='SaveEdit']"));
		 driver.executeScript("arguments[0].click();", save);
		 //verify the account name
		 String text = driver.findElement(By.xpath("//span[@class='custom-truncate uiOutputText']")).getText();
		 System.out.println(text);
		 if(text.contains("Pradeepkumar N")) {
			 System.out.println("verified");
		 }else {
			 System.out.println("other");
		 }
		 
		 
	}

}
