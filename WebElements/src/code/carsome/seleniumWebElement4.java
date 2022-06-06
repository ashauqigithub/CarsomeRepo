package code.carsome;


import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.Select;


public class seleniumWebElement4 {

	public static void main(String[] args) throws InterruptedException {
		//Chrome Browser
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Shauqi\\Downloads\\Selenium java\\chromedriver.exe");
		WebDriver driver = new ChromeDriver ();
		JavascriptExecutor js = (JavascriptExecutor) driver;	
		driver.get("https://www.carsome.my/");
		driver.manage().window().maximize();
		//Thread.sleep(3000);
		
		WebElement searchBox = driver.findElement(By.id("input-60"));
		searchBox.sendKeys("Perodua Axia");
		driver.findElement(By.id("input-60")).sendKeys(Keys.RETURN);
		driver.navigate().refresh();
		Thread.sleep(3000);
		driver.findElement(By.className("list-card__header___sort")).click();
	    driver.findElement(By.id("list-item-469-1")).click();
	    driver.navigate().refresh();
		
		List<WebElement> priceElements = driver.findElements(By.cssSelector("[class='mod-card__price__total']"));
		Map<WebElement, Integer> map = new HashMap<WebElement, Integer>();
		//for(int i=0;i<priceElements.size();i++) {
		for(int i=0;i<2;i++) {
		
			if (priceElements.get(i).getText() != "") {
				//map.put(priceElements.get(i), Integer.parseInt(priceElements.get(i).getText().replace(",", "").replace("RM ", "")));

				Integer priceList = Integer.parseInt(priceElements.get(i).getText().replace(",", "").replace("RM ", ""));
				System.out.println("Price "+i+" = "+priceList);
				
			}	
		}
		
		Integer price1 = Integer.parseInt(priceElements.get(0).getText().replace(",", "").replace("RM ", ""));
		Integer price2 = Integer.parseInt(priceElements.get(1).getText().replace(",", "").replace("RM ", ""));
		
		if(price2 > price1) {
			
			//alert("First car price is lower than second car price. 1st car price = "+price1+". 2nd car price = "+price2);
			js.executeScript("alert('First car price is lower than second car price (Pass!). First car price = "+price1+". 2nd car price = "+price2+"');");
            			
			System.out.println("First car price is lower than second car price (Pass!)");
			
		} else {
			
			//alert("Fail!");
			
			System.out.println("Fail!");
		}
		

		
		//List<Entry<WebElement, Integer>> le = new ArrayList<Map.Entry<WebElement,Integer>>(map.entrySet());
		//le.sort(Entry.comparingByValue());
		
		//for(Entry e: le){
			//System.out.println(e.getValue());
		//}
		
		
		//driver.findElement(By.className("mod-card__wrapper card-1654524866500")).click();
		//driver.findElement(By.className("mod-card__price__total")).click();
		
		//le.get(le.size()-1).getKey().click();  //---highest
		//le.get(0).getKey().click(); // --lowest
	
	    
				

	}

}
