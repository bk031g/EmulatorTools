package note;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestWebDriver {
	public static void main(String[] args) throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");

		WebDriver driver = new ChromeDriver();
		driver.get("http://www.google.com/xhtml");
		Thread.sleep(5000); // Let the user actually see something!
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("ChromeDriver");
		searchBox.submit();
		Thread.sleep(5000); // Let the user actually see something!
		driver.quit();
	}
}
