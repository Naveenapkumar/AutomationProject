package pagepkg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Deygaloginpage {
    WebDriver driver;

    // Locating Login button
    public By loginBtn = By.xpath("//*[@id='customer_login']/button");
    // Locating Email id Text box
    By emailIdField = By.name("customer[email]");
    // Locating password Text box
    By psswd = By.name("customer[password]");
    By newField = By.xpath("//*[@id=\"Header__Wrapper\"]/div[2]/nav/ul/li[5]/a");
    By prodimg = By.xpath("//*[@id=\"shopify-section-template--16878138360002__main\"]/section/div[4]/div[2]/div/div/div/div[2]/div/div/div[1]/a/div/img[2]");
    By cart= By.xpath("//*[@id=\"product_form_1531334951025\"]/div[6]/button");
    By qtyincrease= By.xpath("//*[@id=\"sidebar-cart\"]/form/div[1]/div[3]/div/div/div/div[2]/div[2]/div/div/a[2]\r\n");
    By checkoutbttn= By.xpath("//*[@id=\"sidebar-cart\"]/form/div[2]/div[1]/button");
    

    
    // Initializing the Objects
    public Deygaloginpage(WebDriver driver) {
        this.driver = driver;
    }

    // Clicking on Login button
    public void clickLoginBtn() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.elementToBeClickable(loginBtn)).click();
    }

    // Specifying email and password
    public void setValues(String UN, String PWD) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(emailIdField)).sendKeys(UN);
        System.out.println("Email field is visible and value is set: " + UN);

        wait.until(ExpectedConditions.visibilityOfElementLocated(psswd)).sendKeys(PWD);
        System.out.println("Password field is visible and value is set: " + PWD);
         
       



    }
}
