package OPE_Element;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class TestRadio {

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

		if (driver.getTitle().equals("selenium处理基本页面元素")) {

			System.out.println("判断成功，两者相等！");

		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(10000);

		WebElement selector = driver.findElement(By.id("Selector"));
		Select select = new Select(selector);
		select.selectByIndex(3);
		select.selectByVisibleText("桃子");
		select.selectByValue("apple");

		System.out.println(select.getAllSelectedOptions().toString());
		Thread.sleep(10000);
		WebElement showSelectResult = driver.findElement(By.name("showSelectResult"));
		showSelectResult.click();
		Thread.sleep(10000);
		Alert yourSelect = driver.switchTo().alert();
		Assert.assertTrue(yourSelect.getText().contains("苹果"));
		Thread.sleep(10000);
		yourSelect.accept();

		// for radio Box

		WebElement duRadioBox = driver.findElement(By.cssSelector("div#radio>input.Baidu"));
		WebElement aLiRadioBox = driver.findElement(By.cssSelector("div#radio>input.Alibaba"));
		WebElement TXRadioBox = driver.findElement(By.cssSelector("div#radio>input.Tencent"));
		WebElement MiRadioBox = driver.findElement(By.cssSelector("div#radio>input.Mi"));
		Thread.sleep(10000);
		Assert.assertTrue(TXRadioBox.isSelected());
		Assert.assertTrue(!MiRadioBox.isEnabled());
		Thread.sleep(10000);

		try {

			if (duRadioBox.isEnabled()) {
				duRadioBox.click();
				System.out.println("元素被点击");
			}
		} catch (Exception e) {

			System.out.println("点击元素失败。" + e.toString());
		}

		Assert.assertTrue(duRadioBox.isSelected());
		System.out.println(duRadioBox.isSelected());
		Thread.sleep(10000);

		aLiRadioBox.click();
		Assert.assertTrue(aLiRadioBox.isSelected());
		Thread.sleep(10000);

		// for checkBox

		List<WebElement> webCheckBox = driver.findElements(By.xpath("//input[@type='checkbox']"));

		for (WebElement e : webCheckBox) {
			e.click();
			Assert.assertTrue(e.isSelected());
			Thread.sleep(10000);
		}

		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		System.out.println("等待2秒");

		driver.close();

	}
}