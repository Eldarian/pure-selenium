package com.eldarian.pureselenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FormPage extends AbstractPage {
    public FormPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "firstName")
    private WebElement firstName;

    @FindBy(id = "lastName")
    private WebElement lastName;

    @FindBy(id = "gender-radio-1")
    private WebElement maleRadio1;

    @FindBy(id = "userNumber")
    private WebElement userNumber;

    @FindBy(id = "state")
    private WebElement state;


}
