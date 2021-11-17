package com.symund.pages;

import com.symund.utilities.BrowserUtils;
import com.symund.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    public BasePage() {

        PageFactory.initElements(Driver.get(), this);
    }

    public static String pageTitle() {
        BrowserUtils.waitFor(3);
        String actualTitle = Driver.get().getTitle();
        return actualTitle;
    }
}
