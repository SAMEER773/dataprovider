package Test;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Utiliti.ExcelUtilites;

public class Login {
	@Test(dataProvider = "getTextData1",dataProviderClass = ExcelUtilites.class)
	public void loginTest(Map<String, String> ma) throws IOException {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\win10\\eclipse-workspace\\Sample\\Executables\\chromedriver.exe");

		WebDriver driver=new ChromeDriver();

		driver.get("https://itera-qa.azurewebsites.net/Login");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.id("Username")).sendKeys(ma.get("UserName"));
		driver.findElement(By.id("Password")).sendKeys(ma.get("Password"));
		driver.findElement(By.name("login")).click();

		WebElement we=driver.findElement(By.xpath("//h1[text()=\"Dashboard\"]"));
		System.out.println(we.getText());
		Assert.assertEquals(we.getText(), "Dashboard");

		TakesScreenshot st=(TakesScreenshot) driver;

		File fi=st.getScreenshotAs(OutputType.FILE);

		File fil=new File("C:\\Users\\win10\\Desktop\\screenShot\\"+System.currentTimeMillis()+"abcd.png");

		FileUtils.copyFile(fi, fil);

		driver.findElement(By.linkText("Log out")).click();

		driver.quit();




	}

}



