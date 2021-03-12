package Day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.List;
import java.util.Random;

public class FormPO extends BasePO {
    //   WebDriver driver;
    //   String ownURL = "https://seleniumui.moderntester.pl/form.php";

    @FindBy(id = "inputFirstName3")
    private WebElement inputFirstname;

    @FindBy(id = "inputLastName3")
    private WebElement inputLastname;

    @FindBy(css = "#inputEmail3")   //szukanie po id używając składni css
    private WebElement inputEmail;

    @FindBy(css = "input[value='male']")
    private WebElement sex;


    @FindBy(css = "#inputAge3")
    private WebElement age;

    @FindBy(name = "gridRadiosExperience")
    private List<WebElement> yearsOfExpirience;

    @FindBy(id = "gridCheckManulTester")
    private WebElement profession;

    @FindBy(id = "selectContinents")
    private WebElement continentsElements;

    @FindBy(id = "selectSeleniumCommands")
    private WebElement commandsElement;

    @FindBy(id = "chooseFile")
    private WebElement fileInput;

    @FindBy(css = "#additionalInformations")
    private WebElement additionalInfo;

    @FindBy(css = "button[type='submit']")
    private WebElement signIn;

    @FindBy(id = "validator-message")
    private WebElement validatorMessage;

    public void fillName(String firstname, String lastname) {
        inputFirstname.sendKeys(firstname);
        inputLastname.sendKeys(lastname);
    }

    public void fillEmail(String email) {
        inputEmail.sendKeys(email);
    }

    public void openMe() {
        driver.get(ownURL);
    }

    public void setSex() {
        sex.click();
    }

    public void setAge(String newAge) {
        age.sendKeys(newAge);
    }

    public void setYearsOfExpirience() {
        getRandomElement(yearsOfExpirience).click();
    }

    public void setProfession() {
        profession.click();
    }

    public void setContinents() {
        Select continents = new Select(continentsElements);
        List<WebElement> continentsOptions = continents.getOptions();
        WebElement randomOption = getRandomElement(continentsOptions);
        continents.selectByVisibleText(randomOption.getText());
    }

    public void setCommands() {
        Select commandsSelect = new Select(commandsElement);
        List<WebElement> commandsOptions = commandsSelect.getOptions();
        int howManyOption = getRandomNumber(commandsOptions.size());
        for (int i = 0; i < howManyOption; i++) {
            commandsSelect.selectByIndex(i);
        }
    }

    public void uploadFile(File file) {
        fileInput.sendKeys(file.getAbsolutePath());
    }

    public void addAdditionalInfo(String info) {
        additionalInfo.sendKeys(info);
    }

    public void clickSignIn() {
        signIn.click();
    }

    public FormPO(WebDriver driver) {
        super(driver);
        ownURL = "https://seleniumui.moderntester.pl/form.php";
    }

    public String getValidatorMessageText() {
        return validatorMessage.getText();
    }


}
