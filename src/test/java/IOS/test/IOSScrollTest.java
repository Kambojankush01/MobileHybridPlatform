package IOS.test;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import common.TestUtils.IOSBaseTest;
import io.appium.java_client.AppiumBy;

public class IOSScrollTest extends IOSBaseTest{
	
	@Test
	public void IosScrollTestDemo() throws InterruptedException {
		
		WebElement ele = driver.findElement(AppiumBy.accessibilityId("Web View"));
		
		Map<String, Object> params = new HashMap<>();
		params.put("direction", "down");
		params.put("element", ((RemoteWebElement)ele).getId());
		
		driver.executeScript("mobile:scroll", params);
		
		driver.findElement(AppiumBy.accessibilityId("Web View")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//XCUIElementTypeButton='UIKitCatalog'")).click();
		
		}	

}
