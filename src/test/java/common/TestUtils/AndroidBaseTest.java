package common.TestUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import pageObjects.android.FormPage;
import utils.AppiumUtils;

public class AndroidBaseTest extends AppiumUtils{
	
	public AppiumDriverLocalService service ;
	public AndroidDriver driver;
	public FormPage formPage;
	public UiAutomator2Options options;
	public Properties prop;
	
	
	
	
	@BeforeSuite(alwaysRun=true)
	public void ConfigureAppium() throws IOException {
		// Code to start the Appium server
				prop= new Properties();
				FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
				prop.load(fis);
				String ipAddress = prop.getProperty("ipAddress");
				String port = prop.getProperty("port");
				
				
				service = startAppiumServer(ipAddress,Integer.parseInt(port));
				
				
				options = new UiAutomator2Options();
				options.setChromedriverExecutable(System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
				options.setDeviceName(prop.getProperty("AndroidDeviceName"));
				options.setApp("./src\\test\\resources\\General-Store.apk");
//				options.setApp(System.getProperty("user.dir")+"\\src\\test\\resources\\General-Store.apk");
				
				
				driver = new AndroidDriver(service.getUrl(),options);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				formPage = new FormPage(driver);
				
	}
	
	@BeforeMethod(alwaysRun=true)
	public void preSetup() {
//		options = new UiAutomator2Options();
//		options.setChromedriverExecutable(System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
//		options.setDeviceName(prop.getProperty("AndroidDeviceName"));
//		options.setCapability("appium:appPackage", "com.androidsample.generalstore");
//		options.setCapability("appium:appActivity", "com.androidsample.generalstore.MainActivity");
//		
//		
//		driver = new AndroidDriver(service.getUrl(),options);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		formPage = new FormPage(driver);
		Activity activity = new Activity("com.androidsample.generalstore","com.androidsample.generalstore.MainActivity");
		((JavascriptExecutor)driver).executeScript("mobile: startActivity",ImmutableMap.of("intent","com.androidsample.generalstore/com.androidsample.generalstore.MainActivity"));
//		((JavascriptExecutor)driver).executeScript("mobile: startActivity",ImmutableMap.of("appPackage", "com.androidsample.generalstore",
//			    "appActivity", "com.androidsample.generalstore.MainActivity"));
	}
	
	
	
//	public Double getFormattedAmount(String amount) {
//		Double price = Double.parseDouble(amount.substring(1));
//		return price;
//	}
//	
	@AfterSuite(alwaysRun=true)
	public void TearDown() {
		driver.quit();
		
		//Code to stop the server
		service.stop();
	}

}
