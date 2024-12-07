package Android.test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import common.TestUtils.AndroidBaseTest;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;

public class eCommerce_tc_1 extends AndroidBaseTest {
	
//	@BeforeMethod
//	public void preSetup() {
//		// Screen to home page
//		Activity activity = new Activity("com.androidsample.generalstore", "com.androidsample.generalstore.MainActivity");
//		((JavascriptExecutor)driver).executeScript("mobile:startActivity", ImmutableMap.of("intent","com.androidsample.generalstore/com.androidsample.generalstore.MainActivity"));
//		
//	}
//	
	@Test(priority=0)
	public void FillForm() throws InterruptedException {
	
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("BP123456777");
		driver.hideKeyboard();
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		Thread.sleep(3000);
	
	}
	
	@Test(priority=1)
	public void HandleToastMessage () throws InterruptedException {
		
//		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("BP123456777");
		driver.hideKeyboard();
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		String toastMessage = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
		Assert.assertEquals(toastMessage, "Please enter your name");
		
	}
}
