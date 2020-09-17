package genericAPI;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BaseSetup {

    public BasePage page;

    public WebDriver driver;
    public static Properties prop = new Properties();
    public static FileInputStream fis = null;

    @BeforeMethod
    public void setUp() {
        try {
            fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/config/config.properties");
        } catch (FileNotFoundException e) {
            e.getMessage();
            e.printStackTrace();
        }

        try{
            prop.load(fis);
        } catch (IOException e) {
            e.getMessage();
            e.printStackTrace();
        }

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

//        if (browser.equals("chrome")) {
//            WebDriverManager.chromedriver().setup();
//            driver = new ChromeDriver();
//        } else if (browser.equals("firefox")) {
//            WebDriverManager.firefoxdriver().setup();
//            driver = new FirefoxDriver();
//        } else if (browser.equals("html")) {
//            driver = new HtmlUnitDriver();
//        }

        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));


        page = new BasePage(driver);

    }

    @AfterMethod
    public void tearDown() {
        driver.close();
        driver.quit();
    }

}
