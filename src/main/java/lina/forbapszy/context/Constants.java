package lina.forbapszy.context;


public class Constants {
    public static final String WORKING_DIRECTORY = System.getProperty("user.dir");
    public final static String REPORT_DIRECTORY = WORKING_DIRECTORY + "/ExtentReports/AutomationResult.html";
    public final static String PROJECT_NAME = "Your_Project_Name";
    public final static String EXTENT_CONFIG_PATH = WORKING_DIRECTORY + "/src/main/resources/config/extent-config.xml";
    public final static String PROPERTY_FILE_PATH = WORKING_DIRECTORY + "/src/main/resources/config/test.properties";
    public final static String CHROME_DRIVER_PATH = WORKING_DIRECTORY + "/src/main/resources/drivers/chromedriver.exe";
}