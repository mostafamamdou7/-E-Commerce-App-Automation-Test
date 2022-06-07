package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.asserts.SoftAssert;
import pages.P02_loginPage;
import pages.P03_homePage;

public class SD02_user_login {

    P02_loginPage P02 = new P02_loginPage(Hooks.driver);
    P03_homePage P03 = new P03_homePage(Hooks.driver);

    @Given("Click on Login tab")
    public void clickLoginTab(){
        P03.loginTab.click();
    }

    @When("^User enter \"(.*)\" and \"(.*)\"$")
    public void enterLoginCredentials(String email, String password){
        P02.enterLogin(email, password);
    }

    @And("Click on login button")
    public void clickLoginButton(){
        P02.loginButton.click();
        Hooks.rest();
    }

    @Then("User could login successfully")
    public void loginAssertion(){
        SoftAssert loginAssertion = new SoftAssert();
        loginAssertion.assertEquals(Hooks.driver.getCurrentUrl(), "https://demo.nopcommerce.com/");
        loginAssertion.assertTrue(P03.myAccountTab.isDisplayed());
        loginAssertion.assertAll();
    }


}
