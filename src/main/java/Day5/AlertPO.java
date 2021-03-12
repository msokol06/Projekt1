package Day5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AlertPO extends BasePO {
    //click "delayed alert"
    //wait for allert
    // close alert
    //assert text

    @FindBy(id = "delayed-alert")
    private WebElement delayedAlertButton;

    @FindBy(id = "delayed-alert-label")
    private WebElement delayedAlertLabel;

    public void clickDelayedAlertButton(){
        delayedAlertButton.click();
    }

    public String getDelayedAlertLabelText(){
        return delayedAlertLabel.getText();
    }

    public void waitForAlertAndAccept(){
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }


    public AlertPO(WebDriver driver) {
        super(driver);
        ownURL = "https://seleniumui.moderntester.pl/alerts.php";
    }
}