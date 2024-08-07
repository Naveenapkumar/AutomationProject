package pagepkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Deygahomepage {
    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"Header__Wrapper\"]/div[4]/nav/ul/li[1]/div[1]")
    private WebElement accountLink;

    @FindBy(xpath = "//*[@id=\"Header__Wrapper\"]/div[4]/nav/ul/li[1]/div[2]/ul/li[1]/a")
    private WebElement loginLink;

    public Deygahomepage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickAccountLink() {
        accountLink.click();
    }

    public void clickLoginLink() {
        loginLink.click();
    }
}
