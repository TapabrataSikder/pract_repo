package tests;

import java.util.List;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import db.DBUtil;
import base.BaseTest;
import pages.ParabankPage;

public class ParabankTest extends BaseTest {
	
	ParabankPage page;
	
	@BeforeMethod
	public void setUp() {
		initializedriver();
		page = new ParabankPage(driver);
	}

    @DataProvider(name = "dbData")
    public Object[][] getData() throws Exception {
        List<Object[]> data = DBUtil.getDBData();
        return data.toArray(new Object[0][0]);
    }

    @Test(dataProvider = "dbData")
    public void testRegistrationFromDB(String f, String l, String adr, String cty, String st, 
                                       String zp, String phn, String ssn, String user, String pwd, String cnfpwd) {
         page.openRegisterPage(); // Remove this if it's already in register()
        page.register(f, l, adr, cty, st, zp, phn, ssn, user, pwd, cnfpwd);
    }
}