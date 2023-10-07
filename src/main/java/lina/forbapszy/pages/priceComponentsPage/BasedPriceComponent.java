package lina.forbapszy.pages.priceComponentsPage;

import lina.forbapszy.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasedPriceComponent extends BasePage {
    public BasedPriceComponent(WebDriver driver) { super(driver); }

    @FindBy(id = "BasePrice")
    private WebElement itemRow;

    @FindBy(xpath = "//*[@id=\"BasePrice\"]/div[3]/div")
    private WebElement itemPrice;

    @FindBy(id = "base-edit-icon")
    private WebElement editPriceIcon;

    @FindBy(id = "base-value-input")
    private WebElement itemPriceInput;

    @FindBy(id = "base-check-icon")
    private WebElement itemSubmit;

    public float getBasedPriceValue() {
        return Float.parseFloat(itemPrice.getText());
    }

    public void setBasePrice(String value) {
        mouseOver(itemRow);
        editPriceIcon.click();
        itemPriceInput.clear();
        itemPriceInput.sendKeys(value);
        itemSubmit.click();
    }
}
