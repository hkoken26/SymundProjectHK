package com.symund.step_definitions;

import com.symund.pages.LoginPage;
import com.symund.utilities.BrowserUtils;
import com.symund.utilities.ConfigurationReader;
import com.symund.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class LoginPageStepDefs {
    public WebElement element = null;

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        Driver.get().get(ConfigurationReader.get("url"));
    }

    @When("the user enters the valid information")
    public void the_user_enters_the_valid_information() {
        String username = ConfigurationReader.get("valid_username");
        String password = ConfigurationReader.get("valid_password");

        LoginPage loginPage = new LoginPage();
        loginPage.login(username, password);

    }

    @Then("Dashboard page should be displayed")
    public void dashboard_page_should_be_displayed() {
        Assert.assertEquals("Dashboard - Symund - QA", LoginPage.pageTitle());
    }
    @When("user enters invalid {string} or {string}")
    public void user_enters_invalid_or(String userName, String passWord) {
       LoginPage loginPage =new LoginPage();
       loginPage.login(userName, passWord);
    }

    @Then("user should not login and should see error message {string}")
    public void user_should_not_login_and_should_see_error_message(String msg) {
        Assert.assertEquals("verify that error message displayed correctly", msg, new LoginPage().Errormsg.getText());
    }

    @When("user enters empty {string} or {string}")
    public void user_enters_empty_or(String username, String password) {
        LoginPage loginPage =new LoginPage();
        loginPage.login(username, password);

        if (username.isEmpty()){
            element = loginPage.username;
        } else if (password.isEmpty()){
            element = loginPage.password;
        }
    }

    @Then("user should not login and should see notice message {string}")
    public void user_should_not_login_and_should_see_notice_message(String noticemsg) {
        Assert.assertEquals("verify that error message displayed correctly", noticemsg, new LoginPage().noticemsg(element));
    }

    @When("the user enters the valid information without click")
    public void the_user_enters_the_valid_information_without_click() {
        String username = ConfigurationReader.get("valid_username");
        String password = ConfigurationReader.get("valid_password");

        LoginPage loginPage = new LoginPage();
        loginPage.loginwithoutclick(username, password);
        }
    @Then("user should see only dots in password fields")
    public void user_should_see_only_dots_in_password_fields() {
        Assert.assertTrue(new LoginPage().password.getAttribute("type").equals("password"));
    }
    @When("the user click on the eye icon")
    public void the_user_click_on_the_eye_icon() {
        new LoginPage().toggleicon.click();
        BrowserUtils.waitFor(3);
    }
    @Then("user should see the password explicitly on fields")
    public void user_should_see_the_password_explicitly_on_fields() {
        String expectedValue = "text";
        Assert.assertEquals(expectedValue, new LoginPage().password.getAttribute("type"));
    }

    @When("the user click on the Forgot password")
    public void the_user_click_on_the_Forgot_password() {
        new LoginPage().forgetpassword.click();
    }
    @Then("user should see the {string} button")
    public void user_should_see_the_button(String resetbutton) {
        BrowserUtils.waitFor(5);
        Assert.assertEquals(resetbutton, new LoginPage().resetbtn.getAttribute("value"));
    }

    @Then("user should see {string} and {string} text on Username and Password fields")
    public void user_should_see_and_text_on_Username_and_Password_fields(String userfield, String passfield) {
        Assert.assertEquals(userfield, new LoginPage().username.getAttribute("placeholder"));
        Assert.assertEquals(passfield, new LoginPage().password.getAttribute("placeholder"));
    }

}
