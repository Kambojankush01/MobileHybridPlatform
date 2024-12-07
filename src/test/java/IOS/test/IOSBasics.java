package IOS.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import common.TestUtils.IOSBaseTest;
import io.appium.java_client.AppiumBy;
import pageObjects.ios.AlertViews;

public class IOSBasics extends IOSBaseTest{

	@Test
	public void IOSBasicsTest(){
		//xpath, classname, IOS, IOSClassChain, IOSPredicateString, accessibility id, id
		
		AlertViews alertViews = homePage.selectAlertViews();
		alertViews.fillTextLabel("Hello World");
		String actualMessage = alertViews.getConfirmMessage();
		Assert.assertEquals(actualMessage, "A message should be a short, complete sentence.");
	}
}
