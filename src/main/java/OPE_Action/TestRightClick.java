package OPE_Action;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestRightClick {

	public static String testurl = "http://www.baidu.com";

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", ".\\Tools\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(testurl);


		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("==========浏览器在等待=====================================");
		Thread.sleep(1000);
		WebElement baidu_logo = driver.findElement(By.xpath("//*[@id='lg']/img"));

		Actions action = new Actions(driver);
		action.contextClick(baidu_logo).perform();
		String a = action.contextClick(baidu_logo).sendKeys(Keys.ARROW_UP).toString();
		System.out.println("======================================"+a);
		
		action.contextClick(baidu_logo).sendKeys(Keys.ARROW_UP).build().perform();
	}

}
