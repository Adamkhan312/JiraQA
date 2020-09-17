import genericAPI.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SampleLoginPage extends BasePage {

    @FindBy (id = "username")
    public WebElement inputUsername;

    @FindBy (id = "login-submit")
    public WebElement buttonSubmit;

    public SampleLoginPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void sendKeysToLoginUsername (String keys) {
        inputUsername.sendKeys(keys);
    }

    public String clickSubmitButton() {

        try {
            buttonSubmit.click();
        } catch (Exception e) {
            e.getMessage();
        }

        String pageTitle = driver.getTitle();

        return pageTitle;
    }

}
