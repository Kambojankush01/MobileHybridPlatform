package pageObjects.android;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utils.AndroidActions;

public class FormPage extends AndroidActions{
	UiAutomator2Options options;
	AndroidDriver driver;
	
	public FormPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	private WebElement nameField;
	
	@AndroidFindBy(xpath="//android.widget.RadioButton[@text='Female']")
	private WebElement femaleOption;
	
	@AndroidFindBy(xpath="//android.widget.RadioButton[@text='Male']")
	private WebElement maleOption;

	@AndroidFindBy(id="android:id/text1")
	private WebElement countrySelection;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
	private WebElement shopButton;
	
	
	
	public void setNameField(String name) {
		nameField.sendKeys(name);
		driver.hideKeyboard();
	}
	
	public void setGender(String gender) {
		if (gender.contains("female"))
			femaleOption.click();
		else
			maleOption.click();
	}
	
	public void setCountrySelection(String countryName) {
		
		countrySelection.click();
		scrollToText(countryName);
		driver.findElement(By.xpath("//android.widget.TextView[@text='"+countryName+"']")).click();
		
	}

	public ProductCatalogue submitForm() {
		shopButton.click();
		return new ProductCatalogue(driver);
	}

	public void setActivity() {
		
		Activity activity = new Activity("com.androidsample.generalstore","com.androidsample.generalstore.MainActivity");
//		((JavascriptExecutor)driver).executeScript("mobile: startActivity",ImmutableMap.of("intent","com.androidsample.generalstore//com.androidsample.generalstore.MainActivity"));
		((JavascriptExecutor)driver).executeScript("mobile: startActivity",ImmutableMap.of("appPackage", "com.androidsample.generalstore",
			    "appActivity", "com.androidsample.generalstore.MainActivity"));
//	options.setCapability("appium:appPackage", "com.androidsample.generalstore");
//	options.setCapability("appium:appActivity", "com.androidsample.generalstore.MainActivity");
//		
	}
	
	





















}
