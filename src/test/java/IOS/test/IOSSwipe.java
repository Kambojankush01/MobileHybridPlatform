package IOS.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import common.TestUtils.IOSBaseTest;
import io.appium.java_client.AppiumBy;

public class IOSSwipe extends IOSBaseTest{
	

	@Test
	public void IosSwipeTest() throws InterruptedException {
		
		
		
		Map<String,String> params = new HashMap<String,String>();
		params.put("bundleId", "com.apple.mobileslideshow");
		driver.executeScript("mobile:launchApp", params);
		
		driver.findElement(AppiumBy.iOSNsPredicateString("label == 'All Photos'")).click();
		List<WebElement> allPhotos = driver.findElements(AppiumBy.iOSClassChain("**/XCUIElementTypeCell"));
		System.out.println(allPhotos.size());
		
		driver.findElement(By.xpath("//XCUIElementTypeCell[1]")).click();
		
		for(int i=0; i<allPhotos.size();i++) {
		System.out.println(driver.findElement(By.xpath("//XCUIElementTypeNavigationBar")).getAttribute("name"));	
		Map<String,Object> params1 = new HashMap<String,Object>();
		params1.put("direction", "left");
		
		driver.executeScript("mobile:swipe", params1);
		}
		driver.navigate().back();
		driver.findElement(AppiumBy.accessibilityId("Albums")).click(); 		// cleanup
	}	

}
