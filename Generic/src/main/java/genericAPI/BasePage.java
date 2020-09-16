package genericAPI;

import org.openqa.selenium.WebDriver;
import utils.Excel;

public class BasePage {

    protected WebDriver driver;
    protected Excel excel;

    /**
     * THIS IS THE CONSTRUCTOR TO INITIALIZE EXCEL READER/WRITER FUNCTIONALITY
     * @param driver
     * @author SamiSheikh
     */
    public BasePage (WebDriver driver) {
        this.driver = driver;
        this.excel = new Excel(System.getProperty("user.dir")+"/src/test/resources/TestData.xlsx");
    }




}
