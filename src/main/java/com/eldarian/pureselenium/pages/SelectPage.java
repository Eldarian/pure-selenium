package com.eldarian.pureselenium.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SelectPage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(SelectPage.class);

    @FindBy(id = "select-demo")
    private WebElement selectorElement;

    @FindBy(xpath = "//select[@name='States']")
    private WebElement multiSelectElement;

    private Select selector;

    private Select multiSelect;

    @FindBy(className = "selected-value")
    private WebElement selectedDay;

    @FindBy(xpath = "//a[@title='Close']")
    private WebElement closePopupButton;

    @FindBy(id = "printMe")
    private WebElement firstSelectedButton;

    @FindBy(className = "getall-selected")
    private WebElement selectedValue;

    public void closePopup() {
        closePopupButton.click();
    }


    public SelectPage(WebDriver driver) {
        super(driver);
    }

    public void select(int option) {
        LOGGER.info("selector is " + selectorElement);
        selector = new Select(selectorElement);
        selector.selectByIndex(option);
    }

    public void select(String value) {
        selector.selectByValue(value);
    }

    public String getSelectedDay() {
        return selectedDay.getText().substring(16);
    }

    public void selectMultiple(int... args) {
        multiSelect = new Select(multiSelectElement);
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.COMMAND);
        if (multiSelect.isMultiple()) {
            for (int i = 0; i < args.length; i++) {
                multiSelect.selectByIndex(args[i]);
            }
        }
        actions.keyUp(Keys.COMMAND);
    }

    public String getFirstSelected() {
        firstSelectedButton.click();
        multiSelect.getOptions().stream().filter(WebElement::isSelected).forEach(option -> LOGGER.info(option.getText()));
        return selectedValue.getText();
    }

}
