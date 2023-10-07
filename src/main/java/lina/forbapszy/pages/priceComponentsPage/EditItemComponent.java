package lina.forbapszy.pages.priceComponentsPage;

import lina.forbapszy.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditItemComponent extends BasePage {

    private static final String ROW_OF_THE_ITEM = "//*[ text() = '%s' ]/../..";

    private WebElement rowElement;

    public EditItemComponent(WebDriver driver, String itemName) {
        super(driver);
        rowElement = driver.findElement(By.xpath(String.format(ROW_OF_THE_ITEM, itemName)));
    }

    private void hoverRow() {
        mouseOver(rowElement);
    }

    private void overwriteItemLabel(String itemName) {
        WebElement itemLabel = rowElement.findElement(By.xpath("/div[2]"));
        itemLabel.click();
        itemLabel.clear();
        itemLabel.sendKeys(itemName);
    }

    private void overwriteItemPrice(String price) {
        WebElement itemPrice = rowElement.findElement(By.xpath("/div[3]"));
        itemPrice.click();
        itemPrice.clear();
        itemPrice.sendKeys(price);
    }

    private void submitItem() {
        WebElement itemSubmit = rowElement.findElement(By.xpath("/div[4]"));
        itemSubmit.click();
    }

    private void deleteItem() {
        WebElement itemSubmit = rowElement.findElement(By.xpath("/div[4]"));
        itemSubmit.click();
    }

    public void editItemLabel(String newItemLabel) {
        hoverRow();
        overwriteItemLabel(newItemLabel);
        submitItem();
    }

    public void editItemPrice(String price) {
        hoverRow();
        overwriteItemPrice(price);
        submitItem();
    }

    public void removeItem() {
        hoverRow();
        deleteItem();
    }
}
