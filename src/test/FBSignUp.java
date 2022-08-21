package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FBSignUp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		//String Xpath= "//h2[starts-with(text(),' Facebook helps you')]";
		//WebElement FB = driver.findElement(By.xpath(Xpath));
		//FB.click();
		
		WebElement SignUp = driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"));
		SignUp.click();
		WebElement FirstName = driver.findElement(By.xpath("//input[@name='firstname']"));
		WebElement LastName = driver.findElement(By.xpath("//input[@name='lastname']"));
		WebElement Mobile = driver.findElement(By.xpath("//input[@name='reg_email__']"));
		WebElement Password = driver.findElement(By.xpath("//input[@name='reg_passwd__']"));
		FirstName.sendKeys("Abcd");
		LastName.sendKeys("Xyz");
		Mobile.sendKeys("123456789");
		Password.sendKeys("abc@123");
		
		WebElement Day = driver.findElement(By.name("birthday_day"));
		Select dbDay = new Select(Day);
		dbDay.selectByVisibleText("23");
		
		WebElement Month = driver.findElement(By.name("birthday_month"));
		Select dbMonth = new Select(Month);
		dbMonth.selectByVisibleText("Nov");//Uncomment this line to get line 42
		
		System.out.println("The selected month is:"+dbMonth.getFirstSelectedOption().getText());//to get Current month that is displaying
		
		
		WebElement Year = driver.findElement(By.name("birthday_year"));
		Select dbYear = new Select(Year);
		dbYear.selectByVisibleText("1992");
		
		List<WebElement> Months = dbMonth.getOptions();//getoptions is a method
		for(WebElement elm: Months) {
			System.out.println(elm.getText());//same methods for dates and 
			
			
		}
			
		/*List<WebElement> AllMonths= driver.findElements(By.xpath("//select[@name='birthday_month']/option[@selected='1']"));
		for(WebElement elme: AllMonths) {
				System.out.println(elme.getText());//same methods for dates and year
				
				
	     }
		List<WebElement> AllMonths= driver.findElements(By.xpath("//select[@name='birthday_month']/parent::span"));
		//If you are not sure of parent you can use *
		for(WebElement elme: AllMonths) {
				System.out.println(elme.getText());//same methods for dates and year	
				
		} */
		
		String Gender="Female";
		
/*		WebElement Female= driver.findElement(By.xpath("//input[@type='radio' and @value='1']"));
		WebElement Male= driver.findElement(By.xpath("//input[@type='radio' and @value='2']"));
		WebElement Custom= driver.findElement(By.xpath("//input[@type='radio' and @value='-1']"));
		if(Gender=="Female") {   //Gender=="Female" (or) Gender.equals("Female")
			Female.click();
		}
		else if(Gender=="Male") {
			Male.click();
		}
		else{
			Custom.click();
		}*/
		
		//Dynamic Xpath [read from above Gender]
		
		WebElement GenderButton= driver.findElement(By.xpath("//label[text()='"+ Gender +"']/following-sibling::input"));//3 strings are present
		GenderButton.click();
		
   //     String Xpath = "//label[text()='" + Gender + "']/following-sibling::input";
        
   //     WebElement GendgerRadioBtn = driver.findElement(By.xpath(Xpath));
   //     GendgerRadioBtn.click();
		
		
		WebElement Signup = driver.findElement(By.xpath("//button[@name='websubmit']"));
		Signup.click();
		
		driver.close();		
	}
}

				
				
				
		
		
		
	


