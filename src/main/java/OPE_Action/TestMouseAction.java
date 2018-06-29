package OPE_Action;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestMouseAction {

	public static String testurl = "http://www.baidu.com";

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", ".\\Tools\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability("chrome.switches", Arrays.asList("--start-maximized"));
		options.addArguments("--test-type", "--start-maximized");
		WebDriver driver = new ChromeDriver(options);
		driver.get(testurl);
		String s = driver.getTitle();
		System.out.println(s);

		if (driver.getTitle().equals("百度一下，你就知道")) {
			System.out.println("判断成功，两者相等！");
		} else {
			System.out.println("判断Failed，两者不等！");
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("==========浏览器在等待=====================================");
		Thread.sleep(10000);

		// 输入macaca
		WebElement search = driver.findElement(By.xpath("//*/input[@id='kw']"));
		search.clear();
		search.sendKeys("输入macaca");

		//*[@id="form"]/div/ul/li[3]
		//*[@id="2"]/div[1]
		//*[@id="form"]/span[1]
		
		WebElement Yaodu_Name = driver.findElement(By.name("tj_settingicon"));
		// 药渡公司名称
		//WebElement Yaodu_Name = driver
				//.findElement(By.xpath("//*/div[@class='bdsug']/ul/li[@data-key='药渡经纬信息科技北京有限公司']"));

		// 基于Actions类创建一个对象
		Actions action = new Actions(driver);

		// 鼠标悬停在药渡公司全称字段上
		action.moveToElement(Yaodu_Name).build().perform();
		// 点击悬停的元素
		Yaodu_Name.click();
		
		WebElement choose = driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[6]/a[2]"));
		choose.click();
		
		
	}

}
