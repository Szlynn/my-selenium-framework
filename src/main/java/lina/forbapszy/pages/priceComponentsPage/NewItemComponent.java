package lina.forbapszy.pages.priceComponentsPage;

import lina.forbapszy.pages.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewItemComponent extends BasePage {
    public NewItemComponent(WebDriver driver) { super(driver); }

    @FindBy(id = "ghost-label-input")
    private WebElement itemLabel;

    @FindBy(id = "ghost-value-input")
    private WebElement itemValue;

    @FindBy(id = "ghost-check-icon")
    private WebElement itemSubmit;

    public void writeNewItemLabel(String value) {
        itemLabel.click();
        itemLabel.clear();
        itemLabel.sendKeys(value);
    }

    public void writeNewItemValue(String value) {
        itemValue.clear();
        itemValue.sendKeys(value);
    }

    public void increaseNewItemValue() {
        itemValue.sendKeys(Keys.ARROW_UP);
    }

    public void decreaseNewItemValue() {
        itemValue.sendKeys(Keys.ARROW_DOWN);
    }

    public void addNewItem() {
        itemSubmit.click();
    }
}
