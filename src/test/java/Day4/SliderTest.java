package Day4;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SliderTest extends TestBase {
    @BeforeMethod
    public void openAlertPage() {
        driver.get("https://seleniumui.moderntester.pl/slider.php");
    }

    @Test
    public void sliderTest() {
        moveTo(50);
        moveTo(20);
        moveTo(20);
        moveTo(100);
    }

    public void moveTo(int expectedSliderValue) {
        int actualSliderValue = getSliderValue();
        if (actualSliderValue > expectedSliderValue) {
            moveSlider(expectedSliderValue, Keys.ARROW_LEFT);
        } else if (actualSliderValue < expectedSliderValue) {
            moveSlider(expectedSliderValue, Keys.ARROW_RIGHT);
        }
    }

    public void moveSlider(int expectedSliderValue, Keys key) {
        while (getSliderValue() != expectedSliderValue) {
            driver.findElement(By.id("custom-handle")).sendKeys(key);
        }
    }

    public int getSliderValue() {
        return Integer.parseInt(driver.findElement(By.id("custom-handle")).getText());
    }
}
