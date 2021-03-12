package Day5.MyStore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductMiniaturePO {
    @FindBy(css = ".product-title")
    private WebElement productTitle;

    @FindBy(css = ".price")
    private WebElement price;

    @FindBy(css = ".thumbnail")
    private WebElement thumbnail;

    @FindBy(css = "tralalala")
    private WebElement toNieZrobiZleTestowi;

    @FindBy(css = ".quick-view")
    private WebElement quickView;

    private WebDriver driver;

    public void clickMe() {
        thumbnail.click();
    }

    public String getProductTitle() {
        return productTitle.getText();
    }

    public double getProductPrice() {
        String priceNumber = price.getText().replace("$", "");
        return Double.valueOf(priceNumber);
    }

    public void clickQuickView(){
        Actions actions = new Actions(driver);
        actions.moveToElement(thumbnail).build().perform();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(quickView));
        quickView.click();
    }

    public ProductMiniaturePO(WebElement productMiniature, WebDriver driver) {
        PageFactory.initElements(new DefaultElementLocatorFactory(productMiniature), this);
        this.driver = driver;
    }
}






//package Day5.MyStore;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
//
//public class ProductMiniaturePO {
//
//    WebDriver driver;
//
//    public ProductMiniaturePO(WebElement productMiniature, WebDriver driver) {
//        PageFactory.initElements(new DefaultElementLocatorFactory(productMiniature), this);
//        this.driver = driver;
//    }
//
//    @FindBy(css = ".product-miniature")
//    private WebElement productMiniature;
//
//    @FindBy(css = ".h3 product-title")
//    private WebElement productTitle;
//
//    @FindBy(css = ".price")
//    private WebElement productPrice;
//
//    @FindBy(css = ".quick-view")
//    private WebElement quickView;
//
//
//    public void clickProductMiniature(){
//        productMiniature.click();
//    }
//
//    public void clickproductTitle(){
//        productTitle.click();
//    }
//
//    public void clickQuickView(){
//        Actions action = new Actions(driver);
//        action.moveToElement(productMiniature);
//        //
//        quickView.click();
//    }
//
//    public int getProductPrice(){
//        String priceText = productPrice.getText();
//        priceText.replace("$", "");
//        return Integer.parseInt(priceText);
//    }
//
//
//}
//
