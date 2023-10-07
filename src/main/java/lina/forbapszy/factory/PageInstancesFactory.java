package lina.forbapszy.factory;

import java.lang.reflect.InvocationTargetException;
import lina.forbapszy.context.WebDriverContext;
import lina.forbapszy.pages.BasePage;
import org.openqa.selenium.WebDriver;


public class PageInstancesFactory {
    public static <T extends BasePage> T getInstance(Class<T> type) {
        try {
            return type.getConstructor(WebDriver.class).newInstance(WebDriverContext.getDriver());
        } catch (
                InstantiationException
                | IllegalAccessException
                | IllegalArgumentException
                | InvocationTargetException
                | NoSuchMethodException
                | SecurityException e) {
            e.printStackTrace();
            return null;
        }
    }
}