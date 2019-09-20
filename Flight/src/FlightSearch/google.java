package FlightSearch;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import jxl.read.biff.BiffException;

public class google {
	WebDriver driver;
	
	@BeforeClass
	public void Openbrowser() throws BiffException, IOException {
		
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		driver=new ChromeDriver();
		
	}

	@Test
	public void test() throws InterruptedException {
			driver.get("https://www.google.com/flights");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.xpath("(//div[contains(@class,'flt-input gws-flights-form__input-container')])[1]")).click();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//div[@class='sbib_b']//input[1]")).clear();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//div[@class='sbib_b']//input[1]")).sendKeys("Toronto");
			driver.findElement(By.xpath("(//span[@class='fsapp-option-city-name'])[2]")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//div[@jsan='0.data-flt-ve,22.jsaction,t-ch-jmKqQoDY,7.flt-input,7.gws-flights-form__input-container,7.gws-flights__flex-box,7.gws-flights-form__airport-input,7.gws-flights-form__empty,7.gws-flights-form__swapper-left,0.role,21.jssc']")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//div[@class='sbib_b']//input[1]")).sendKeys("LHR");
			driver.findElement(By.className("fsapp-option-city-name")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//div[@class='gws-flights-form__search-button-wrapper']//floating-action-button[1]")).click();
			Thread.sleep(5000);
			String word = driver.findElement(By.xpath("//span[text()='Best departing flights']")).getText();
			System.out.println("Text Obtained is"+word);
			
			if(word.contains("Best departing flights")) {
				System.out.println("Expected text is obtained");
			}
			else {
				System.out.println("Expected text is not obtained");
			}
			
			
			
			
		
	}
	
	@AfterClass
	public void Closebrowser() {
		driver.close();
	}
}
