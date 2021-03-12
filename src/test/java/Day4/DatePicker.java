package Day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;

public class DatePicker extends TableTest {

    @BeforeMethod
    public void openDatepicker() {
        driver.get("https://seleniumui.moderntester.pl/datepicker.php");
    }

    @Test
    public void calendarTest() {
        selectDate("1", "October", 2019);
        Assert.assertEquals(getSelectedDate(), "10/01/2019");
    }

    private void selectDate(String expectedDate, String expectedMonth, int expectedYear) {
        driver.findElement(By.id("datepicker")).click();
        String actualMonth = getMonth();
        int actualYear = getYear();

        if (actualYear < expectedYear) goNext(expectedMonth, expectedYear);
        else if (actualYear > expectedYear) goPrev(expectedMonth, expectedYear);
        else {
            while (!expectedMonth.equals(actualMonth)) {
                driver.findElement(By.cssSelector(".ui-datepicker-next")).click();
                actualMonth = getMonth();
                actualYear = getYear();
                if (actualYear > expectedYear) {
                    goPrev(expectedMonth, expectedYear);
                    actualMonth = getMonth();
                }

            }
        }
        // .ui-state-default:not(.ui-priority-secondary) - znajduje dni tylko z aktualnego miesiąca
        List<WebElement> dayList = driver.findElements(By.cssSelector(".ui-state-default"));
        for (int i = 0; i < dayList.size() - 1; i++) {
            if (dayList.get(i).getText().equals(expectedDate) && Integer.parseInt(dayList.get(i).getText()) <= i + 1) {
                dayList.get(i).click();
                break;
            }
        }
    }

    private String getSelectedDate() {
        return driver.findElement(By.id("datepicker")).getAttribute("value");

    }

    public String getMonth() {
        return driver.findElement(By.cssSelector(".ui-datepicker-month")).getText();
    }

    public int getYear() {
        return Integer.parseInt(driver.findElement(By.cssSelector(".ui-datepicker-year")).getText());
    }

    public void goNext(String expectedMonth, int expectedYear) {
        while (!expectedMonth.equals(getMonth()) || expectedYear != getYear()) {
            driver.findElement(By.cssSelector(".ui-datepicker-next")).click();
            veryBadSleep();
        }
    }

    public void goPrev(String expectedMonth, int expectedYear) {
        while (!expectedMonth.equals(getMonth()) || expectedYear != getYear()) {
            driver.findElement(By.cssSelector(".ui-datepicker-prev")).click();
            veryBadSleep();
        }
    }
}
