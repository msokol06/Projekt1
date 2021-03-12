package Day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IframeTest extends TestBase {

    @BeforeMethod
    public void openIframePage(){
        driver.get("https://seleniumui.moderntester.pl/iframes.php");
    }


    @Test
    public void iframeTest(){
        driver.switchTo().frame("iframe1");
        String firstname = "Jan";
        String surname = "Kowalski";
        driver.findElement(By.id("inputFirstName3")).sendKeys(firstname);
        driver.findElement(By.id("inputSurname3")).sendKeys(surname);

        driver.switchTo().defaultContent();
        driver.switchTo().frame("iframe2");

        driver.findElement(By.id("inputLogin")).sendKeys("kgendig@gmail.com");

        driver.findElement(By.id("inputPassword")).sendKeys("secret");

        Select selectContinents = new Select(driver.findElement(By.id("inlineFormCustomSelectPref")));
        selectContinents.selectByVisibleText("Europe");

        WebElement radioExpirience = driver.findElement(By.id("gridRadios7"));
        radioExpirience.click();
    }
}
