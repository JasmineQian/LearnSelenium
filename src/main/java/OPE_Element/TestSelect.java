package OPE_Element;

import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

public class TestSelect {

	public static String testurl = "D:\\00M_IDEA_Project\\LearnSelenium\\Tools\\Test123456.html";

	public static void main(String args[]) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".\\Tools\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability("chrome.switches", Arrays.asList("--start-maximized"));
		options.addArguments("--test-type", "--start-maximized");
		WebDriver driver = new ChromeDriver(options);
		driver.get(testurl);
		String s = driver.getTitle();
		System.out.println(s);
		System.out.println("======Select Option=======");

		driver.findElement(By.id("jumpMenu")).click();
		WebElement links_dropdown = driver.findElement(By.xpath("//*[@id='jumpMenu']"));
		// WebElement links_dropdown=driver.findElement(By.className("selected"));
		//// *[@id="jumpMenu"]/option[1]

		Select links = new Select(links_dropdown);
		links.selectByValue("http://www.pdsedu.gov.cn/");

		String aaa = driver.getWindowHandle();
		WebElement myLink = driver.findElement(By.linkText("Copyright 2017"));

		try {

			if (myLink.isEnabled()) {
				// scroll to mylink
				JavascriptExecutor scroll = (JavascriptExecutor) driver;
				scroll.executeScript("arguments[0].scrollIntoView();", myLink);
				// open link in a new windows press shift when you click
				Thread.sleep(10000);
				Actions actions = new Actions(driver);
				actions.keyDown(Keys.SHIFT).click(myLink).perform();
				System.out.println("元素被点击");
			}
		} catch (Exception e) {

			System.out.println("点击元素失败。" + e.toString());
		}
		Thread.sleep(10000);
		System.out.println("======Sucess=======");
		driver.close();
	}

}
