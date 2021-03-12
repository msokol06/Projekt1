package Day4;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SelectableTest extends TestBase{
    @BeforeMethod
    public void openIframePage(){
        driver.get("https://seleniumui.moderntester.pl/selectable.php");
    }

    @Test
    public void shouldSelectItem(){
        List<WebElement> items = driver.findElements(By.cssSelector(".ui-widget-content"));
        int index = getRandomNumber(items.size()-2);
        items.get(index).click();

        Assert.assertEquals(driver.findElement(By.id("select-result")).getText(), "#"+index);

    }

    @Test
    public void shouldSelectMultiple(){
        List<WebElement> items = driver.findElements(By.cssSelector(".ui-widget-content"));
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.LEFT_CONTROL)
                .click(items.get(3))
                .click(items.get(4))
                .click(items.get(0))
                .keyUp(Keys.LEFT_CONTROL)
                .build()    //jeśli potrzebujemy zbudować i przechować duży element
                .perform(); //używamy od razu

        Assert.assertEquals(driver.findElement(By.id("select-result")).getText(), "#1 #4 #5");


    }

}
