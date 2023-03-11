package MiniProject1;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Adaction1 {
	
	
	 public static WebDriver driver;
	
	public static void BrowserLaunch() {
		 driver= new ChromeDriver();
    	 driver.get("https://adactinhotelapp.com/");
    	 driver.manage().window().maximize();

	}
	
	
	public static void SearchHotel(WebElement we,String i) {
		Select s=new Select(we);
	      s.selectByValue(i);
	}
	
	public static void ExistingUser() throws Throwable  {
		WebElement user = driver.findElement(By.id("username"));
		user.sendKeys("aswinkumar799");
		WebElement pass = driver.findElement(By.id("password"));
		pass.sendKeys("dcc123");
		WebElement log = driver.findElement(By.id("login"));
		Thread.sleep(2000);
		log.click();
		
		SearchHotel(driver.findElement(By.id("location")),"Sydney");
		SearchHotel(driver.findElement(By.id("hotels")),"Hotel Creek");
		SearchHotel(driver.findElement(By.id("room_type")),"Double");
		SearchHotel(driver.findElement(By.id("room_nos")),"2");
		WebElement element = driver.findElement(By.name("datepick_in"));
		element.clear();
		element.sendKeys("01/02/2023");
		WebElement element1 = driver.findElement(By.name("datepick_out"));
		element1.clear();
		element1.sendKeys("05/02/2023");
		SearchHotel(driver.findElement(By.name("adult_room")),"2");
		SearchHotel(driver.findElement(By.id("child_room")),"3");
		WebElement search = driver.findElement(By.name("Submit"));
		Thread.sleep(2000);
		search.click();
		WebElement radio = driver.findElement(By.id("radiobutton_0"));
		radio.click();
		WebElement continue1 = driver.findElement(By.id("continue"));
		continue1.click();
		
	}
	public static void BookaHotel() throws Throwable  {
		driver.findElement(By.name("first_name")).sendKeys("John");
		driver.findElement(By.name("last_name")).sendKeys("Smith");
		driver.findElement(By.name("address")).sendKeys("15243,Glen Circle");
		driver.findElement(By.name("cc_num")).sendKeys("2435676756564343");
		SearchHotel(driver.findElement(By.id("cc_type")),"VISA");
		SearchHotel(driver.findElement(By.id("cc_exp_month")),"4");
		SearchHotel(driver.findElement(By.id("cc_exp_year")),"2022");
		driver.findElement(By.name("cc_cvv")).sendKeys("5654");
		driver.findElement(By.name("book_now")).click();
		Thread.sleep(6000);
		WebElement element6 = driver.findElement(By.name("my_itinerary"));
		element6.click();
	}

	public static void Itenary() throws Throwable {
		driver.findElement(By.name("check_all")).click();
		Thread.sleep(5000);
		driver.findElement(By.name("cancelall")).click();
	}
	

	  public static void ConfirmAlert(String s) {
		   Alert alert = driver.switchTo().alert();
	       if (s.equalsIgnoreCase("accept")) {
	    	   alert.accept();
			
		} else {
	           alert.dismiss();
		   }
	  }
	  public static void logout() {
		  driver.findElement(By.name("logout")).click();
	}
	  public static void screenShot(String s) throws IOException {
			TakesScreenshot ts = (TakesScreenshot)driver;//driver class variable
			File screenshotAs = ts.getScreenshotAs(OutputType.FILE);
			File f = new File("C:\\Users\\Kavin\\eclipse-workspace\\Selenium\\Google\\"+s+".png");
	        FileUtils.copyFile(screenshotAs, f);		


	}
	  
}



