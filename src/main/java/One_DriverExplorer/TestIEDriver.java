package One_DriverExplorer;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestIEDriver {

	public static void main(String args[]) throws InterruptedException {

		System.setProperty("webdriver.ie.driver", ".\\Tools\\IEDriverServer.exe");

		WebDriver driver = new InternetExplorerDriver();
		driver.manage().window().maximize();
		driver.get("http://www.baidu.com");
		String s = driver.getTitle();
		System.out.print(s);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(1000);
		driver.close();

	}
}