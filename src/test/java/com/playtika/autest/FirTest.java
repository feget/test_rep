package com.playtika.autest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;


public class FirTest {
	@Test
	public void NavigateToSlotsPreprod() throws Exception {


		//System.setProperty("webdriver.gecko.driver", "C:\\Test\\geckodriver.exe");
		//System.setProperty("webdriver.gecko.driver", "sourses/geckodriver.exe");
		//запускаем гекодрайвер необходимый для работы с FireFox57 Selenium 3
		System.setProperty("webdriver.chrome.driver", "sourses/chromedriver.exe");
		WebDriver driver = new ChromeDriver(); //инициализируем Веб драйвер Firefox
		driver.manage().window().maximize();    //раскрыть окно браузера на весь экран
		driver.get("https://www.slotspreprod.com");  //переходим по URL

		String homePage = driver.getWindowHandle();//узнаем хендл текущего окна
		System.out.println(homePage);

		WebElement playFbBtn = driver.findElement(By.id("play-facebook"));
		playFbBtn.click();

		Set<String> handles = driver.getWindowHandles();
		System.out.println(handles.size());

		Iterator iterator = handles.iterator();
		String currentWindowId;
		while (iterator.hasNext()) {
			currentWindowId = iterator.next().toString();
			System.out.println(currentWindowId);

			if (!currentWindowId.equals(homePage)) {
				driver.switchTo().window(currentWindowId);
				WebElement searchFieldForEmail = driver.findElement(By.id("email"));
				searchFieldForEmail.clear();
				searchFieldForEmail.sendKeys("blabla");
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

				WebElement searchFieldForPass = driver.findElement(By.id("pass"));
				searchFieldForPass.clear();
				searchFieldForPass.sendKeys("pauho6eeJe1");
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

				WebElement loginFbBtn = driver.findElement(By.id("u_0_0"));
				loginFbBtn.click();

				driver.switchTo().window(homePage);
			}



		}
		Thread.sleep(5000);
		driver.switchTo().frame("content_fr");





	}
}


