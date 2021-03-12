package Day5.MyStore;

import Day5.BasePO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Objects;

public class ArtPO extends BasePO {

    @FindBy(css = ".search-link")
    private List<WebElement> priceFilter;

    @FindBy(css = ".btn-unstyle")
    private WebElement sortBy;

    @FindBy(css = ".select-list")
    private List<WebElement> sortList;

    @FindBy(css = ".filter-block")
    private WebElement activeFilter;



    WebDriverWait wait = new WebDriverWait(driver, 10);

    public ArtPO clickPriceFilter() {
        for (WebElement i : priceFilter) {
            if (i.getText().contains("$8.00 - $10.00")) {
                i.click();
                break;
            }
        }
        wait.until(ExpectedConditions.elementToBeClickable(activeFilter));
        return this;
    }
    public ArtPO selectSortType() {
        sortBy.click();
        for (WebElement i : sortList) {
            if (i.getText().contains("Name, Z to A")) {
                i.click();
                break;
            }
        }
       // wait.until(ExpectedConditions.;
        return this;
    }


    public ArtPO(WebDriver driver) {
        super(driver);
        ownURL = "http://5.196.7.235/9-art";
    }
}
