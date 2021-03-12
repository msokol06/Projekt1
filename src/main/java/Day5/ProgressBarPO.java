package Day5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProgressBarPO extends BasePO{
    //wypelnienie PO
    //zrobienie metody, ktora czeka na wypelnienie progress Baru

    @FindBy(css = ".ui-progressbar-complete")
    private WebElement completeProgressBar;

    public boolean progressBarIsComplete(){
        return completeProgressBar.isDisplayed();
    }

    public ProgressBarPO(WebDriver driver) {
        super(driver);
        ownURL = "https://seleniumui.moderntester.pl/progressbar.php";
    }
}


//package Day5;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//public class ProgressBarPO extends BasePO {
//    //wypelnienie PO
//    //zrobienie metody, ktora czeka na wypelnienie progress Baru
//
//
//    @FindBy(css = ".progress-label")
//    private WebElement barStatus;
//
//
//    public void checkForComplete(){
//        WebDriverWait wait = new WebDriverWait(driver,10);
//            wait.until(ExpectedConditions.textToBePresentInElement(barStatus,"Complete!"));
//
//    }
//
//
//    public ProgressBarPO(WebDriver driver) {
//        super(driver);
//        ownURL = "https://seleniumui.moderntester.pl/progressbar.php";
//    }
//
//
//}


