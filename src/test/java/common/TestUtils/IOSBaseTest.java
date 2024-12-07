package common.TestUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import pageObjects.ios.HomePage;
import utils.AppiumUtils;

public class IOSBaseTest extends AppiumUtils {
	
	public AppiumDriverLocalService service;
	public IOSDriver driver;
	public HomePage homePage;
	
	@BeforeMethod
	public void ConfigureAppium() throws MalformedURLException, IOException {
		
		Properties prop= new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		String ipAddress = prop.getProperty("ipAddress");
		String port = prop.getProperty("port");
		service = startAppiumServer(ipAddress,Integer.parseInt(port));
		
		XCUITestOptions options = new XCUITestOptions();
		options.setDeviceName("simulator");
		options.setApp("path of app");
		options.setPlatformName("15.5");
		options.setWdaLaunchTimeout(Duration.ofSeconds(20));
//		caps.setCapability("xcodeOrgId","xxxxx"); //Given by Team
//		 caps.setCapability("xcodeSigningId","iPhone Developer");
//		 caps.setCapability("udid","xxxx"); //it is tied up to real device
//		 caps.setCapability("updateWDABundleId","xxxx"); //Given by Team
//
		
		driver = new IOSDriver(service.getUrl(), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		homePage = new HomePage(driver);
		
	}
	
	public Double getFormattedAmount(String amount) {
		Double price = Double.parseDouble(amount.substring(1));
		return price;
	}
	
	@AfterMethod
	public void TearDown() {
		driver.quit();
		service.stop();
	}

}
