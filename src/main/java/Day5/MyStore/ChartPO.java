package Day5.MyStore;

import Day5.BasePO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChartPO extends BasePO {

    @FindBy(css = ".cart-summary-line .value")
    private WebElement totalPrice;

    @FindBy(css = ".js-subtotal")
    private WebElement allElements;

    public double getTotalPrice() {
        String priceNumber = totalPrice.getText().replace("$", "");
        return Double.valueOf(priceNumber);
    }

    public int getAllElements(){
        String itemsNumber = allElements.getText().replace(" items", "");
        return Integer.parseInt(itemsNumber);
    }


    public ChartPO(WebDriver driver) {
        super(driver);
    }
}
