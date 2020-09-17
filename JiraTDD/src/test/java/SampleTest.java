
import genericAPI.BaseSetup;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SampleTest extends BaseSetup {

    SampleLoginPage loginPage;

    @Test
    public void sampleEnterLoginInfo() {
        loginPage = new SampleLoginPage(driver);
        loginPage.sendKeysToLoginUsername(prop.getProperty("email"));

        String pageTitle = loginPage.clickSubmitButton();
        Assert.assertEquals(pageTitle, "Fail");

    }

}
