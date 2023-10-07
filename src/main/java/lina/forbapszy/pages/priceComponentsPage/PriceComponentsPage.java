package lina.forbapszy.pages.priceComponentsPage;

import lina.forbapszy.pages.BasePage;
import lina.forbapszy.pages.priceComponentsPage.NewItemComponent;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class PriceComponentsPage extends BasePage {

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div/span")
    private WebElement totalPrice;

    @Getter
    private NewItemComponent newItemComponent;

    @Getter
    private BasedPriceComponent basedPriceComponent;

    public PriceComponentsPage(WebDriver driver) {
        super(driver);
        newItemComponent = new NewItemComponent(driver);
        basedPriceComponent = new BasedPriceComponent(driver);
    }

    public EditItemComponent newEditItemComponent(String itemName) {
        return new EditItemComponent(driver, itemName);
    }

    public float getTotalPrice() {
        return Float.parseFloat(totalPrice.getText());
    }

}