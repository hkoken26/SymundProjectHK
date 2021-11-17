package com.symund.pages;

import com.symund.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {


    public LoginPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id = "user")
    public WebElement username;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(id = "submit-form")
    public WebElement login;

    @FindBy(xpath = "//p[contains(text(),'Wrong')]")
    public WebElement Errormsg;

    @FindBy(css = "a.toggle-password")
    public WebElement toggleicon;

    @FindBy(id = "lost-password")
    public WebElement forgetpassword;

    @FindBy(id = "reset-password-submit")
    public WebElement resetbtn;

    @FindBy(xpath = "//*[@type='password']")
    public WebElement dotpass;


    public void login(String userNameStr, String passwordStr) {
        username.sendKeys(userNameStr);
        password.sendKeys(passwordStr);
        login.click();
    }
    public void loginwithoutclick (String userNm, String passWr){
        username.sendKeys(userNm);
        password.sendKeys(passWr);
    }

    public String noticemsg(WebElement element) {
       return element.getAttribute("validationMessage");
    }


}
