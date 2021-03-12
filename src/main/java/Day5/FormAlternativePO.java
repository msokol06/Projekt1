package Day5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.List;

public class FormAlternativePO extends BasePO{
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

    public FormAlternativePO fillName(String firstname, String lastname) {
        inputFirstname.sendKeys(firstname);
        inputLastname.sendKeys(lastname);
        return this;
    }

    public FormAlternativePO fillEmail(String email) {
        inputEmail.sendKeys(email);
        return this;
    }


    public FormAlternativePO setSex() {
        sex.click();
        return this;
    }

    public FormAlternativePO setAge(int newAge) {

        age.sendKeys(String.valueOf(newAge));
        return this;
    }

    public FormAlternativePO setYearsOfExpirience() {
        getRandomElement(yearsOfExpirience).click();
        return this;
    }

    public FormAlternativePO setProfession() {

        profession.click();
        return this;
    }

    public FormAlternativePO setContinents() {
        Select continents = new Select(continentsElements);
        List<WebElement> continentsOptions = continents.getOptions();
        WebElement randomOption = getRandomElement(continentsOptions);
        continents.selectByVisibleText(randomOption.getText());
        return this;
    }

    public FormAlternativePO setCommands() {
        Select commandsSelect = new Select(commandsElement);
        List<WebElement> commandsOptions = commandsSelect.getOptions();
        int howManyOption = getRandomNumber(commandsOptions.size());
        for (int i = 0; i < howManyOption; i++) {
            commandsSelect.selectByIndex(i);
        }
        return this;
    }

    public FormAlternativePO uploadFile(File file) {

        fileInput.sendKeys(file.getAbsolutePath());
        return this;
    }

    public FormAlternativePO addAdditionalInfo(String info) {
        additionalInfo.sendKeys(info);
        return this;
    }

    public FormAlternativePO clickSignIn() {
        signIn.click();
        return this;
    }

    public FormAlternativePO(WebDriver driver) {
        super(driver);
        ownURL = "https://seleniumui.moderntester.pl/form.php";
    }

    public String getValidatorMessageText() {
        return validatorMessage.getText();
    }
}
