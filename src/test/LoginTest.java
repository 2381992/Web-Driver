package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.simplilearn.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		
		Thread.sleep(5000);//if steps are taking time
		// STEP 1: Login Link
		
		WebElement LoginLink = driver.findElement(By.linkText("Log in"));
		LoginLink.click();
		
		// STEP 2: Enter Mail Id
		
		WebElement UserName = driver.findElement(By.name("user_login"));
		UserName.sendKeys("abc@xyz");
		
		// STEP 3: Enter Password
		
		WebElement Password = driver.findElement(By.id("password"));
		Password.sendKeys("123567");
		
		// STEP 4: Click Remember Me Check box
		
		WebElement Checkbox = driver.findElement(By.className("rememberMe"));
		Checkbox.click();
		
		// STEP 5: Click on Login Button
		
		WebElement LoginBtn = driver.findElement(By.name("btn_login"));
		LoginBtn.click();
		
		// STEP 6: Validating error on screen
		
		WebElement Error = driver.findElement(By.id("error_box"));
		String ActError = Error.getText();
		String ExpError = "Please enter a valid email address";
		if(ActError.equals(ExpError))
		{
			System.out.println("Test Case Passed");
		}
		else 
		{
			System.out.println("Test Case Failed");
		
		}
		
		List<WebElement> Links = driver.findElements(By.tagName("a"));
		System.out.println("Total number of Links:"+Links.size());
		for(int i=0;i<Links.size();i++) {
			System.out.println(Links.get(i).getAttribute("href"));
		}
		List<WebElement> Links1 = driver.findElements(By.tagName("div"));
		System.out.println("Total number of Links:"+Links1.size());
		
		
		
		
		// STEP 7: Closing Browser
		
		driver.close();
		
		
		
	}	

	}


