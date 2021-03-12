package Day5;

import Day4.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

public class FirstPOTest extends TestBase {

    @Test
    public void firstTest() {
        //given
        FormPO formPO = new FormPO(driver);
        formPO.openMe();
        //when
        formPO.fillName("Bogdan", "Boner");
        formPO.fillEmail("test@test.com");
        formPO.setSex();
        formPO.setAge("15");
        formPO.setYearsOfExpirience();
        formPO.setProfession();
        formPO.setContinents();
        formPO.setCommands();
        File file = new File("src/main/resources/emptyFile.txt");
        formPO.uploadFile(file);
        formPO.addAdditionalInfo("Test");
        formPO.clickSignIn();
        //then
        //      String validationMessage = driver.findElement(By.id("validator-message")).getText();
//                Assert.assertEquals(validationMessage, "Form send with success");
        Assert.assertEquals(formPO.getValidatorMessageText(), "Form send with success");
    }


    @Test
    public void progressBarTest() {
        ProgressBarPO progressBarPO = new ProgressBarPO(driver);
        progressBarPO.openMe();
        Assert.assertTrue(progressBarPO.progressBarIsComplete());
    }

    @Test
    public void testDelayedAlert() {
        AlertPO alertPO = new AlertPO(driver);
        alertPO.openMe();
        alertPO.clickDelayedAlertButton();
        alertPO.waitForAlertAndAccept();
        Assert.assertEquals(alertPO.getDelayedAlertLabelText(), "OK button pressed");
    }


    @Test
    public void alternativeFormTest() {
        FormAlternativePO formPO = new FormAlternativePO(driver);
        formPO.openMe();
        formPO
                .fillName("Bogdan", "Boner")
                .fillEmail("test@test.pl")
                .setAge(25);
    }

}
