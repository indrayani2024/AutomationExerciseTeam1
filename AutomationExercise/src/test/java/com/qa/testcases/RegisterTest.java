package com.qa.testcases;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import java.util.Date;

public class RegisterTest {
	WebDriver driver;
	
	@BeforeMethod
	public void setup()
	{
		String browserName="chrome";
		if(browserName.equals("chrome")) {
			driver=new ChromeDriver();
		}else if(browserName.equals("edge")) {
			driver=new EdgeDriver();
		}else if(browserName.equals("firefox")) {
			driver=new FirefoxDriver();
		}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
			driver.get("https://automationexercise.com/");
			driver.findElement(By.xpath("//i[@class='fa fa-lock']")).click();
	}
	@Test
	public void VerifyRegisterSignup()
	{
		driver.findElement(By.name("name")).sendKeys("Raj");
		driver.findElement(By.xpath("//input[@data-qa=\"signup-email\"]")).sendKeys("Raj"+generateemailwithtimestamp()+"@gmail.com");
		driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();
	}
	public String generateemailwithtimestamp()
	{
		Date date=new Date();
	    return date.toString().replace(" ","_").replace(":","_");
	}
	public void VerifyRegisterAccountwithMandatoryFields() {
		driver.switchTo("https://automationexercise.com/signup");
		 driver.findElement(By.name("name")).sendKeys("Raj");
		 driver.findElement(By.xpath("//input[@data-qa=\"signup-email\"]")).sendKeys("Raj"+generateemailwithtimestamp()+"@gmail.com");
		 //driver.findElement(By.xpath("//input[@id='id_gender1']")).isSelected();
		 driver.findElement(By.xpath("input[@data-qa='password']"));
		 driver.findElement(By.id("first_name")).sendKeys("Indrayani");
		 driver.findElement(By.id("last_name")).sendKeys("Sutar");
		 driver.findElement(By.id("address1")).sendKeys("Pimple Gurav");
		 
		 
		//input[@data-qa='password']
 	}
	public void test()
	{
		System.out.println("Indrayani");
		}
	
}
