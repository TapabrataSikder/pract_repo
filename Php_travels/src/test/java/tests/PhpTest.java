package tests;

import java.util.Scanner;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.PhpPage;

public class PhpTest extends base.BaseTest{
	
	pages.PhpPage page;
	
	@BeforeMethod
	public void setup() {
		page=new PhpPage(driver);
	}
	
	@DataProvider(name="regData")
	public Object[][] regData() throws Exception{
		return utils.CSVUtil.getCSVData("src/test/resources/data/php_reg_data.csv");
	}
	

	
	@Test(dataProvider = "regData")
	public void userReg(String fn, String ln, String em, String pd)
	{
		page.clickSignup();
		page.register(fn, ln, em, pd);
		
		System.out.println("Please solve the CAPTCHA manually...");
		
		Scanner scanner = new Scanner(System.in);
	    scanner.nextLine();
	    
	    page.submitRegistration();
	    
		System.out.println("Registered: "+ em);
	}
	
}
