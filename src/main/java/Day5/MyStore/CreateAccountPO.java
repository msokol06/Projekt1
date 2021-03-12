package Day5.MyStore;

import Day5.BasePO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAccountPO extends BasePO {
    @FindBy(css = "[name=\"id_gender\"][value=\"1\"]")
    private WebElement mrGenderSelection;

    @FindBy(css = "[name=\"id_gender\"][value=\"2\"]")
    private WebElement mrsGenderSelection;

    @FindBy(name = "firstname")
    private WebElement firstNameTextBox;

    @FindBy(name = "lastname")
    private WebElement lastNameTextBox;

    @FindBy(name = "email")
    private WebElement emailTextBox;

    @FindBy(name = "password")
    private WebElement passwordTextBox;

    @FindBy(name = "birthday")
    private WebElement birthdayTextBox;

    @FindBy(css = ".form-control-submit")
    private WebElement submitButton;

    @FindBy(css = ".alert-danger")
    private WebElement alertInfo;


    public void fillFormAndSubmit(boolean male,
                                  String firstname,
                                  String lastname,
                                  String email,
                                  String password,
                                  String birthday){
        if(male) selectMale();
        else selectFemale();
        fillName(firstname,lastname);
        fillEmail(email);
        fillPassword(password);
        fillBirthday(birthday);
        submit();
    }

    public void submit(){
        submitButton.click();
    }

    public void fillBirthday(String birthday){
        birthdayTextBox.sendKeys(birthday);
    }

    public void fillPassword(String password){
        passwordTextBox.sendKeys(password);
    }

    public void fillEmail(String email){
        emailTextBox.sendKeys(email);
    }

    public void selectMale(){
        mrGenderSelection.click();
    }

    public void selectFemale(){
        mrsGenderSelection.click();
    }

    public void fillName(String firstname, String lastname){
        firstNameTextBox.sendKeys(firstname);
        lastNameTextBox.sendKeys(lastname);
    }

    public String getAlertInfo(){
        return alertInfo.getText();
    }

    public CreateAccountPO(WebDriver driver) {
        super(driver);
        ownURL = "http://5.196.7.235/login?create_account=1";
    }
}