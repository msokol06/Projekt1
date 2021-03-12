package Day5.MyStore;

import Day5.BasePO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class QuickViewPO extends BasePO {
    @FindBy(css = ".col-md-6 .h1")
    private WebElement title;

    @FindBy(id = "quantity_wanted")
    private WebElement quantity;

    @FindBy(css = ".current-price")
    private WebElement singlePrice;

    @FindBy(css = ".add-to-cart")
    private WebElement chartButton;

    @FindBy(css = ".cart-content-btn a")
    private WebElement proceedButton;

    @FindBy(css = ".cart-content-btn .btn-secondary")
    private WebElement continueButton;

    @FindBy(id = "blockcart-modal")
    private WebElement blockcart;

    public void setQuantity(int rand) {
        String s = String.valueOf(rand);
        quantity.clear();
        quantity.sendKeys(s);
    }

    public double getSinglePrice() {
        String priceNumber = singlePrice.getText().replace("$", "").replace(" SAVE 20%", "");
        return Double.parseDouble(priceNumber);
    }

    public void clickChartButton() {
        chartButton.click();
    }

    public void clickProceedButton() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(proceedButton));
        proceedButton.click();

    }

    public void clickContinueButton() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(continueButton));
        continueButton.click();
        wait.until(ExpectedConditions.invisibilityOf(blockcart));
    }

    public String getTitle() {
        return title.getText();
    }

    public QuickViewPO(WebDriver driver) {
        super(driver);
    }
}