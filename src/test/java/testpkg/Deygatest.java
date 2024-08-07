package testpkg;

import org.testng.annotations.Test;
import basepkg.BaseclassDeyga;
import pagepkg.Deygahomepage;
import pagepkg.Deygaloginpage;
import pagepkg.Productlist;
import pagepkg.Searchproduct;
import pagepkg.Shopproduct;
import utilitiespkg.Deygaloginutils;

public class Deygatest extends BaseclassDeyga {

    @Test(priority=1)
    public void verifyLoginWithValidCred() throws Exception {
        Deygahomepage d1 = new Deygahomepage(driver);
        Deygaloginpage d2 = new Deygaloginpage(driver);

        // Reading the data from excel file by the specified path
        String xl = "C:\\Users\\91965\\OneDrive\\Desktop\\Deygalogindata.xlsx";
        String sheet = "Sheet1";

        // Get row count
        int rowCount = Deygaloginutils.getRowCount(xl, sheet);
        System.out.println("Total rows: " + rowCount);

        d1.clickAccountLink();
        d1.clickLoginLink();

        for (int i = 1; i <= rowCount; i++) {
            String userName = Deygaloginutils.getCellValue(xl, sheet, i, 0);
            String pwd = Deygaloginutils.getCellValue(xl, sheet, i, 1);

            // Use the login page methods to set values and perform login
            d2.setValues(userName, pwd);
            d2.clickLoginBtn();

            // Add assertions or checks to verify login success/failure
        }
    }

    @Test(priority=2)
    public void purchaseprod() {
        Shopproduct s1 = new Shopproduct(driver);
        Searchproduct s2 = new Searchproduct(driver);


        s1.purchaseprod();
        s2.searchForLipBalm(); 
        // Search for lip balm products
        s2.clickCartIcon();
    }
    
    @Test(priority=3)
    public void Searchproductlist()
    {
      Productlist p1 = new Productlist(driver);
      p1.clickLastLipBalmProduct();
      p1.clickCart();


    }
}
