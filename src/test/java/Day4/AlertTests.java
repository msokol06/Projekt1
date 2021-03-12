package Day4;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertTests extends TestBase{

    @BeforeMethod
    public void openAlertPage(){ driver.get("https://seleniumui.moderntester.pl/alerts.php");}

    @Test
    public void simpleAlert(){
        driver.findElement(By.id("simple-alert")).click();
        driver.switchTo().alert().accept();
        String validationMessage = driver.findElement(By.id("simple-alert-label")).getText();
        Assert.assertEquals(validationMessage, "OK button pressed");
    }

//    @Test
//    public void promptAlert(){
//        String textToSend = "Jan Kowalski";
//        driver.findElement(By.id("prompt-alert")).click();
//        driver.switchTo().alert().sendKeys(textToSend);
//        driver.switchTo().alert().accept();
//        String validationMessage = driver.findElement(By.id("prompt-label")).getText();
//        Assert.assertEquals(validationMessage, "Hello "+ textToSend +"! How are you today?");
//    }

    @Test
    public void promptAlertAccept() {
        String text = "Gwidon Ryba";
        driver.findElement(By.id("prompt-alert")).click();
        driver.switchTo().alert().sendKeys(text);
        driver.switchTo().alert().accept();

        String message = driver.findElement(By.id("prompt-label")).getText();
        Assert.assertEquals(message, "Hello "+text+"! How are you today?");

    }

    @Test
    public void promptAlertCancel() {
        driver.findElement(By.id("prompt-alert")).click();
        driver.switchTo().alert().dismiss();

        String message = driver.findElement(By.id("prompt-label")).getText();
        Assert.assertEquals(message, "User cancelled the prompt.");
    }


    @Test
    public void confirmAlertBoxOk() {
        driver.findElement(By.id("confirm-alert")).click();
        driver.switchTo().alert().accept();

        String message = driver.findElement(By.id("confirm-label")).getText();
        Assert.assertEquals(message, "You pressed OK!");
    }

    @Test
    public void confirmAlertBoxCancel() {
        driver.findElement(By.id("confirm-alert")).click();
        driver.switchTo().alert().dismiss();

        String message = driver.findElement(By.id("confirm-label")).getText();
        Assert.assertEquals(message, "You pressed Cancel!");
    }

}
