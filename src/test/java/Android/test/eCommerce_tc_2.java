package Android.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import common.TestUtils.AndroidBaseTest;
import io.appium.java_client.AppiumBy;

public class eCommerce_tc_2 extends AndroidBaseTest{

	//com.androidsample.generalstore/com.androidsample.generalstore.AllProductsActivity
	
	@Test(priority=0)
	public void verifyProductAddedToCart() throws InterruptedException {
//		Activity activity = new Activity("com.androidsample.generalstore","com.androidsample.generalstore.AllProductsActivity");
//		((JavascriptExecutor) driver).executeScript("mobile:startActivity", 
//				ImmutableMap.of("intent","com.androidsample.generalstore/com.androidsample.generalstore.AllProductsActivity"));

		// Above code doesn't workout due to security reason
		
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("BP12345677_#");
		driver.hideKeyboard();
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		Thread.sleep(2000);
		
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan 6 Rings\"));"));

		int productCount = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
		
		for(int i=0;i<productCount;i++) {
			String productName = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
			if(productName.equalsIgnoreCase("Jordan 6 Rings")) {
				driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
			}
		}
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Thread.sleep(2000);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title"))
				, "text", "Cart"));
		
		
		String lastPageProduct = driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
		Assert.assertEquals(lastPageProduct, "Jordan 6 Rings");
		
	}
}
