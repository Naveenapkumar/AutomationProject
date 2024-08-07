package pagepkg;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Searchproduct {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//*[@id=\"search-desktop\"]/input")
    WebElement search;



    @FindBy(xpath = "//div//button[@class='ProductForm__AddToCart Button Button--primary Button--full']")
    WebElement addtocart;

    @FindBy(xpath = "//*[@id='sidebar-cart']/form/div[1]/div[3]/div/div/div/div[2]/div[2]/a")
    WebElement itemremovecart;

    public Searchproduct(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Increase wait time
        PageFactory.initElements(driver, this);
    }

    public void searchForLipBalm() {
        int attempts = 0;
        boolean success = false;

        while (attempts < 3 && !success) {
            try {
                WebElement searchField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='search-desktop']/input")));
                System.out.println("Entering search term: lip balm");
                
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].value = 'lip balm';", searchField);
                searchField.sendKeys(Keys.ENTER);
                
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='searchModal']")));
                success = true;
            } catch (org.openqa.selenium.StaleElementReferenceException e) {
                System.out.println("Caught StaleElementReferenceException. Retrying...");
                attempts++;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                }
            } catch (Exception e) {
                System.out.println("Error during searchForLipBalm operation: " + e.getMessage());
                break;
            }
        }
    }

    


   

    public void clickCartIcon() {
        try {
            // Ensure the add to cart button is clickable
            WebElement addToCartElement = wait.until(ExpectedConditions.elementToBeClickable(addtocart));
            addToCartElement.click();
            
            // Optionally handle removing items from the cart if necessary
            // WebElement removeItem = wait.until(ExpectedConditions.elementToBeClickable(itemremovecart));
            // removeItem.click();
        } catch (Exception e) {
            System.out.println("Error during clickCartIcon operation: " + e.getMessage());
        }
    }
}
