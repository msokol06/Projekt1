package Day5.MyStore;

import Day5.BasePO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuPO extends BasePO {
    @FindBy(css = ".user-info .hidden-sm-down")
    private WebElement signInOut;

    @FindBy(css = ".logout")
    private WebElement signOutOnly;

    @FindBy(css = ".account>span.hidden-sm-down")
    private WebElement nameOfLoggedInUser;

    public void clickSignInOutButton(){
        signInOut.click();
    }

    public boolean logoutVisible(){
        return signOutOnly.isDisplayed();
    }

    public String getUserName(){
        return nameOfLoggedInUser.getText();
    }


    public MenuPO(WebDriver driver) {
        super(driver);
    }
}