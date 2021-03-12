package Day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;

public class TableTest extends TestBase {

    @BeforeMethod
    public void openAlertPage() {
        driver.get("https://seleniumui.moderntester.pl/table.php");
    }

    @Test
    public void tableTest() {
        List<WebElement> mountainRows = driver.findElements(By.cssSelector("tbody>tr"));
        List<Mountain> mountains = new ArrayList<>();

        for (WebElement element : mountainRows) {
            mountains.add(new Mountain(element));
        }
        for (Mountain mountain : mountains) {
            if (mountain.getHeight() > 4500 && mountain.getState().contains("Switzerland")) {
                System.out.println(mountain.toString());
            }
        }

//Dopisać asercje


    }


}
