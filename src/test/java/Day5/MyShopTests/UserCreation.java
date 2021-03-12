package Day5.MyShopTests;

import Day4.TestBase;
import Day5.MyStore.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserCreation extends TestBase {

    @Test
    public void testUserRegistration() {
        //given
        String firstName = "Jan";
        String lastname = "Kowalski";
        String email = "test" + System.currentTimeMillis() + "@test.com";
        HomepagePO homepagePO = new HomepagePO(driver);
        homepagePO.openMe();
        MenuPO menuPO = new MenuPO(driver);
        //when
        menuPO.clickSignInOutButton();
        LoginPO loginPO = new LoginPO(driver);
        loginPO.clickCreateAccountLink();
        CreateAccountPO createAccountPO = new CreateAccountPO(driver);
        createAccountPO.fillFormAndSubmit(true,
                firstName,
                lastname,
                email,
                "12345",
                "05/10/2000");
        //then
        Assert.assertTrue(menuPO.logoutVisible());
        Assert.assertEquals(menuPO.getUserName(), firstName + " " + lastname);
    }

    @Test
    public void registrationWithUsedEmail() {
        //given
        String firstName = "Jan";
        String lastname = "Kowalski";
        String email = "test@test.com";
        HomepagePO homepagePO = new HomepagePO(driver);
        homepagePO.openMe();
        MenuPO menuPO = new MenuPO(driver);
        //when
        menuPO.clickSignInOutButton();
        LoginPO loginPO = new LoginPO(driver);
        loginPO.clickCreateAccountLink();
        CreateAccountPO createAccountPO = new CreateAccountPO(driver);
        createAccountPO.fillFormAndSubmit(true,
                firstName,
                lastname,
                email,
                "12345",
                "05/10/2000");
        //then
        Assert.assertEquals(createAccountPO.getAlertInfo(), "The email is already used, please choose another one or sign in");
    }

    @Test
    public void item(){

    }




}