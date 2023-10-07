package lina.forbapszy.pages;

import java.time.Duration;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;


public class BasePage {
    protected WebDriver driver;

    protected FluentWait<WebDriver> waiter;

    public BasePage(WebDriver driver) {
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waiter = new FluentWait<WebDriver>(driver).ignoring(NoSuchElementException.class, WebDriverException.class)
                .withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(2));
    }

    protected void mouseOver(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }

}