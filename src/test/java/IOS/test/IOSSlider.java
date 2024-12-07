package IOS.test;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import common.TestUtils.IOSBaseTest;
import io.appium.java_client.AppiumBy;

public class IOSSlider extends IOSBaseTest{
	

	@Test
	public void IosSliderTest() throws InterruptedException {
		
		WebElement slider = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeSlider[`label == 'AppElem'`]"));
		slider.sendKeys("0%"); //setValue
		
		Thread.sleep(3000);
		System.out.println(slider.getAttribute("value"));
		
		slider.sendKeys("1%");
		System.out.println(slider.getAttribute("value"));
		
		
	}	

}
