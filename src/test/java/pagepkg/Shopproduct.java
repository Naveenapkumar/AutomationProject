package pagepkg;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Shopproduct {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//*[@id=\"Header__Wrapper\"]/div[2]/nav/ul/li[5]/a")
    WebElement bestseller;

    @FindBy(xpath = "//*[@id=\"shopify-section-template--16878138360002__main\"]/section/div[4]/div[2]/div/div/div/div[2]/div/div/div[1]/a/div/img[2]")
    WebElement productimg;

    @FindBy(xpath = "//*[@id=\"product_form_1531334951025\"]/div[6]/button")
    WebElement cart;

    @FindBy(xpath = "//*[@id=\"sidebar-cart\"]/form/div[1]/div[3]/div/div/div/div[2]/div[2]/div/div/a[2]")
    WebElement increaseQuantity;

    @FindBy(xpath = "//*[@id=\"sidebar-cart\"]/form/div[2]/div[1]/button")
    WebElement checkoutbttn;

//    @FindBy(xpath = "//div[@id=\"input-wrapper\"]//input[@id=\"phone-input\"]")
//    WebElement mobnumber;
//    
//    @FindBy(xpath = "//*[@id=\"pincode-input\"]")
//    WebElement pincode;
//    
//    @FindBy(xpath = "//*[@id=\"full-name\"]")
//    WebElement fullname;
//    
//    @FindBy(xpath = "//*[@id=\"surveyForm\"]/div[2]/div[2]")
//    WebElement emailId;
//    
//    @FindBy(xpath = "//*[@id=\"address\"]")
//    WebElement address;
// 
//    @FindBy(xpath = "//*[@id=\"3\"]")
//    WebElement radiobttn;
    
    @FindBy(xpath = "//*[@id=\"main\"]/nav/ol/li[1]/a")
    WebElement homelink;
    
    @FindBy(xpath = "//*[@id=\"searchModal\"]/div/div[2]/div[1]/div[2]/div[2]/div[2]/div/div/figure/a/img[2]")
    List<WebElement> lipbalmproducts;
    
    public Shopproduct(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void purchaseprod() {
        wait.until(ExpectedConditions.visibilityOf(bestseller)).click();
        wait.until(ExpectedConditions.visibilityOf(productimg)).click();
        wait.until(ExpectedConditions.visibilityOf(cart)).click();
        wait.until(ExpectedConditions.visibilityOf(increaseQuantity)).click();
        wait.until(ExpectedConditions.visibilityOf(checkoutbttn)).click();
        driver.navigate().refresh();
        wait.until(ExpectedConditions.visibilityOf(homelink)).click();
    }
    
//    public void fillInfo() {
//        wait.until(ExpectedConditions.visibilityOf(mobnumber)).sendKeys("9946937610");
//        wait.until(ExpectedConditions.visibilityOf(pincode)).sendKeys("689545");
//        wait.until(ExpectedConditions.visibilityOf(fullname)).sendKeys("Test");
//        wait.until(ExpectedConditions.visibilityOf(emailId)).sendKeys("testuser@gmail.com");
//        wait.until(ExpectedConditions.visibilityOf(address)).sendKeys("test address");
//        wait.until(ExpectedConditions.elementToBeClickable(radiobttn)).click();
//    }
}
