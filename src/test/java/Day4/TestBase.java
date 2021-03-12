package Day4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.List;
import java.util.Random;

public class TestBase {
    protected WebDriver driver; // bez protected będzie niewidoczny dla Day5

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("disable-extensions");
        driver = new ChromeDriver(options);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }  //wyłącza przeglądarkę

    public WebElement getRandomElement(List<WebElement> elements) {
        Random rnd = new Random();
        int randomnumber = rnd.nextInt(elements.size() - 1);

        return elements.get(randomnumber);
    }

    public int getRandomNumber(int max) {
        Random rnd = new Random();
        int randomNumber = rnd.nextInt(max) + 1;
        return randomNumber;
    }

    protected void veryBadSleep() {
        try {
            Thread.sleep(500);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
