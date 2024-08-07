package pagepkg;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Productlist {

    private WebDriver driver;
    private WebDriverWait wait;
    private Actions action;

    private By lipbalmProductLocator = By.xpath("//*[@id='searchModal']/div/div[2]/div[1]/div[2]/div[2]/div[2]/div/div/figure");

    @FindBy(xpath = "//div[@class=\"ProductForm__BuyButtons\"]/button")
    private WebElement addtocart;

    @FindBy(xpath = "//*[@id='sidebar-cart']/form/div[2]/div[1]/button")
    private WebElement checkoutbttn;

    @FindBy(xpath = "//*[@id=\"Header__Wrapper\"]/div[4]/nav/ul/li[1]")
    private WebElement account;
    
    @FindBy(xpath = "//div[@class=\"list_wrapper\"]//ul[@class=\"account_list\"]//li[3]//a")
    private WebElement logout;

    public Productlist(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        this.action = new Actions(driver); // Initialize Actions here
        PageFactory.initElements(driver, this);
    }

    public void clickLastLipBalmProduct() {
        int attempts = 0;
        boolean success = false;

        while (attempts < 3 && !success) {
            try {
                List<WebElement> lipbalmproducts = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(lipbalmProductLocator));

                if (!lipbalmproducts.isEmpty()) {
                    WebElement lastProduct = lipbalmproducts.get(lipbalmproducts.size() - 1);
                    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", lastProduct);
                    wait.until(ExpectedConditions.elementToBeClickable(lastProduct)).click();
                    success = true;
                } else {
                    System.out.println("No lip balm products found.");
                    success = true;
                }
            } catch (org.openqa.selenium.StaleElementReferenceException e) {
                System.out.println("Caught StaleElementReferenceException. Retrying...");
                attempts++;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                }
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
                break;
            }
        }
    }

    public void clickCart() {
        int attempts = 0;
        boolean success = false;

        while (attempts < 3 && !success) {
            try {
                // Wait for the add to cart button to be clickable and click it
                WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(addtocart));
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addToCartButton);
                addToCartButton.click();
                System.out.println("Add to Cart button clicked.");
                
                driver.navigate().refresh();
                System.out.println("Page refreshed.");

                // Locate the <li> element that contains the account information
                WebElement accountListItem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".HorizontalList__Item.account_list")));
                System.out.println("Account list item located.");

                // Use Actions to hover over the <li> element
                action.moveToElement(accountListItem).perform();
                System.out.println("Hovered over account list item.");

                // Wait for the "Log Out" link to be visible and clickable
                WebElement logoutLink = wait.until(ExpectedConditions.elementToBeClickable(logout));
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", logoutLink);
                try {
                    logoutLink.click();
                    System.out.println("Log Out link clicked.");
                } catch (Exception clickException) {
                    System.out.println("Standard click failed. Trying JavaScript click.");
                    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", logoutLink);
                    System.out.println("Log Out link clicked via JavaScript.");
                }

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
                System.out.println("An error occurred: " + e.getMessage());
                e.printStackTrace();
                break;
            }
        }

        if (!success) {
            System.out.println("Failed to click Log Out after " + attempts + " attempts.");
        }
    }

}
