package Android.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import common.TestUtils.AndroidBaseTest;
import pageObjects.android.CartPage;
import pageObjects.android.ProductCatalogue;

public class eCommerce_tc_4_Hybrid extends AndroidBaseTest {
	
//	
//	@BeforeMethod()
//	public void preSetup() { 
//		formPage.setActivity();
//		
//	}

	@Test(priority = 0,dataProvider="getData",groups= {"Smoke"})
	public void DealingWithHybridApp(HashMap<String,String> input) throws InterruptedException {
//		formPage.setActivity();
		formPage.setNameField(input.get("name"));
		formPage.setGender(input.get("gender"));
		formPage.setCountrySelection(input.get("country"));
		
		ProductCatalogue productCatalogue = formPage.submitForm();
		
		productCatalogue.addItemToCartByIndex(0);
		productCatalogue.addItemToCartByIndex(0);
		
		CartPage cartPage = productCatalogue.goToCartPage();
		

		double totalSum = cartPage.getProductsSum();
		double displayFormattedSum = cartPage.getTotalAmountDisplayed();
		System.out.println("The Total price of the product added to the cart is : " + displayFormattedSum);
		Assert.assertEquals(totalSum, displayFormattedSum);
		
		cartPage.acceptTermsConditions();
		cartPage.submitOrder();
		
	
	}

	
	
	@DataProvider
	public Object[][] getData() throws IOException {
		List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir")+"//src//test//java//testData//eCommerce.json");
		return new Object [][] {{data.get(0)},{data.get(1)}};
	}
}
