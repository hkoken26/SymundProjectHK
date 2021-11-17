package com.symund.step_definitions;

import com.symund.pages.LoginPage;
import com.symund.pages.LogoutPage;
import com.symund.utilities.BrowserUtils;
import com.symund.utilities.ConfigurationReader;
import com.symund.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LogOutStepDefs {
    @Given("the user logged in")
    public void the_user_logged_in() {
        Driver.get().get(ConfigurationReader.get("url"));
        String username = ConfigurationReader.get("valid_username");
        String password = ConfigurationReader.get("valid_password");
        new LoginPage().login(username, password);
    }

    @When("the user open the user option window")
    public void the_user_open_the_user_option_window() {
        LogoutPage useroption = new LogoutPage();
        useroption.useroptions.click();
    }

    @Then("the user should be able to logout")
    public void the_user_should_be_able_to_logout() {
        LogoutPage logout = new LogoutPage();
        logout.logoutbtn.click();

        Assert.assertEquals("Symund - QA", LogoutPage.pageTitle());
    }

    @Then("the user should not be able to Dashboard page by using step back button")
    public void the_user_should_not_be_able_to_Dashboard_page_by_using_step_back_button() {
        Driver.get().navigate().back();

        Assert.assertEquals("Symund - QA", LogoutPage.pageTitle());


    }
}
