package code.carsome;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class seleniumWebElement {

	public static void main(String[] args) throws InterruptedException {
		//Chrome Browser
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Shauqi\\Downloads\\Selenium java\\chromedriver.exe");
		WebDriver driver = new ChromeDriver ();
		
		//Firefox Browser
		//System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\Mozilla Firefox\\geckodriver.exe");
		//WebDriver driver = new FirefoxDriver ();
		
		driver.get("https://www.carsome.my/");
		
		
		
		driver.manage().window().maximize();
	
		
		driver.findElement(By.id("input-60")).sendKeys("Perodua Axia");
		driver.findElement(By.id("input-60")).sendKeys(Keys.RETURN);
		driver.navigate().refresh();
		
		//driver.findElement(By.className("v-input__append-inner")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		Actions act = new Actions(driver);
        act.sendKeys(Keys.PAGE_DOWN).build().perform();
        Thread.sleep(1000);
        act.sendKeys(Keys.PAGE_DOWN).build().perform();
        Thread.sleep(1000);
        act.sendKeys(Keys.PAGE_DOWN).build().perform();
        Thread.sleep(1000);
        act.sendKeys(Keys.PAGE_DOWN).build().perform();
        Thread.sleep(1000);
        act.sendKeys(Keys.PAGE_DOWN).build().perform();
        Thread.sleep(1000);
        act.sendKeys(Keys.PAGE_DOWN).build().perform();//Page Down
        //System.out.println("Scroll down performed");
        Thread.sleep(1000);
		
		//driver.findElement(By.className("component-back-to-top__body")).click();
		
		//js.executeScript("window.scrollBy(0,7000)");
		//js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		//Thread.sleep(5000);
        
		List<WebElement> Total = driver.findElements(By.className("mod-card__content"));		
		//js.executeScript("alert('"+ Total.size()+" Perodua Axia cars available to buy in this page');");
		
	
		
		if(Total.size() > 18){
			
			System.out.println("Fail");
			js.executeScript("alert('"+ Total.size()+" Perodua Axia cars available to buy = Fail');");

	    } 
		else {
			System.out.println("Pass");
			js.executeScript("alert('"+ Total.size()+" Perodua Axia cars available to buy = Pass');");

			}
		//System.out.println("Total Axia:" + Total.size());
		
		//driver.quit();     
		
		
		
		
		//List<WebElement> Total = driver.findElements(By.className("mod-card__content"));
	    //System.out.println("Total Axia:" + Total.size()); 
	    //driver.close();
	    
	   
	    
	
	    
				

	}

}
