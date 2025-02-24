package IOS.test;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import common.TestUtils.IOSBaseTest;
import io.appium.java_client.AppiumBy;

public class IOSPicker extends IOSBaseTest{
	
	@Test
	public void IosPickerTest() throws InterruptedException {
		
	WebElement ele = driver.findElement(AppiumBy.accessibilityId("Picker View"));
		
		Map<String, Object> params = new HashMap<>();
		params.put("direction", "down");
		params.put("element", ((RemoteWebElement)ele).getId());
		
		driver.executeScript("mobile:scroll", params);
		
		driver.findElement(AppiumBy.accessibilityId("Picker View")).click();
		Thread.sleep(2000);
		
		driver.findElement(AppiumBy.accessibilityId("Red color component value")).sendKeys("80");
		driver.findElement(AppiumBy.accessibilityId("Green color component value")).sendKeys("220");
		
		driver.findElement(AppiumBy.iOSNsPredicateString("label == 'Blue color component value'")).sendKeys("105");
		
		String number = driver.findElement(AppiumBy.iOSNsPredicateString("label == 'Blue color component value'")).getText();
		Assert.assertEquals(number, "105");
		
		
		}	

}
