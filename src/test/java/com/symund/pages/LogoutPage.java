package com.symund.pages;

import com.symund.utilities.BrowserUtils;
import com.symund.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage extends BasePage {
    public LogoutPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy (xpath ="//div[@class ='avatardiv avatardiv-shown']/img")
    // id="expand"
    public WebElement useroptions;

    @FindBy (xpath = "//li[@data-id='logout']")
    public WebElement logoutbtn;

    /*public static String pageTitle(){
        BrowserUtils.waitFor(3);
        String actualTitle = Driver.get().getTitle();
        return actualTitle;
    }
*/


}



