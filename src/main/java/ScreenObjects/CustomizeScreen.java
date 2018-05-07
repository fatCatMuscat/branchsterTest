package ScreenObjects;

import ScreenFactories.CustomizeScreenFactory;
import Utils.BaseTest;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class CustomizeScreen extends BaseTest {

    CustomizeScreenFactory customizeScreenFactory =
            new CustomizeScreenFactory();

    public CustomizeScreen() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), customizeScreenFactory);
        waitForElementToLoad(customizeScreenFactory.doneButton);
    }

    public OverviewScreen clickDone() {
        customizeScreenFactory.doneButton.click();
        return new OverviewScreen();
    }

    public boolean doneButtonIsDisplayed() {
        return customizeScreenFactory.doneButton.isDisplayed();
    }

    public void setName(String name) {
        customizeScreenFactory.nameTextField.clear();
        customizeScreenFactory.nameTextField.sendKeys(name);
        driver.hideKeyboard();
    }


}
