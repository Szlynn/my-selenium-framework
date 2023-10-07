package lina.forbapszy.tests;

import lina.forbapszy.factory.PageInstancesFactory;
import lina.forbapszy.pages.priceComponentsPage.EditItemComponent;
import lina.forbapszy.pages.priceComponentsPage.PriceComponentsPage;
import org.testng.annotations.*;


@Test(testName = "Google search test", description = "Test description")
public class TsetTest extends BaseTest {
    private static final String URL = "http://localhost:3000/";

    private PriceComponentsPage page;

    @DataProvider(name="testdata")
    public Object[][] TestDataFeed(){
        Object [][] data = new Object[5][2];
        data[0][0] = "Alloy surcharge";
        data[0][1] = 2.15f;
        data[1][0] = "Scrap surcharge";
        data[1][1] = 3.14f;
        data[2][0] = "Internal surcharge";
        data[2][1] = 0.7658f;
        data[3][0] = "External surcharge";
        data[3][1] = 1f;
        data[4][0] = "Storage surcharge";
        data[4][1] = 0.3f;
        return data;
    }

    @BeforeClass
    private void config() {
        driver.get(URL);
    }

    @Test
    public void changeBasePriceValueTest() {
        page = PageInstancesFactory.getInstance(PriceComponentsPage.class);

        float price = 5.00f;
        page.getBasedPriceComponent().setBasePrice(Float.toString(price));
        assert price == page.getTotalPrice();
    }

    @Test(dataProvider="testdata")
    public void addNewItemsTest(String label, float price) {
        page = PageInstancesFactory.getInstance(PriceComponentsPage.class);

        page.getNewItemComponent().writeNewItemLabel(label);
        page.getNewItemComponent().writeNewItemValue(Float.toString(price));
        page.getNewItemComponent().addNewItem();
    }

    @Test(dependsOnMethods={"addNewItemsTest"})
    public void removeComponentTest() {
        page = PageInstancesFactory.getInstance(PriceComponentsPage.class);

        EditItemComponent item = page.newEditItemComponent("Internal surcharge");
        item.removeItem();
    }

    @Test(dependsOnMethods={"addNewItemsTest"})
    public void editComponentTest() {
        page = PageInstancesFactory.getInstance(PriceComponentsPage.class);

        EditItemComponent item = page.newEditItemComponent("Storage surcharge");

        item.editItemLabel("T");
    }

}