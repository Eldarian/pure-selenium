package com.eldarian.pureselenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SelectPage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(SelectPage.class);

    @FindBy(id = "select-demo")
    private Select selector;

    @FindBy(className = "selectedValue")
    private WebElement selectedDay;

    @FindBy(xpath = "//a[@title='Close']")
    private WebElement closePopupButton;

    public void closePopup() {
        closePopupButton.click();
    }


    public SelectPage(WebDriver driver) {
        super(driver);
    }

    public void select(int option) {
        LOGGER.info("selector is " + selector);
        selector.selectByIndex(option);
    }

    public void select(String value) {
        selector.selectByValue(value);
    }

    public String getSelectedDay() {
        return selectedDay.getText().substring(16);
    }

}
