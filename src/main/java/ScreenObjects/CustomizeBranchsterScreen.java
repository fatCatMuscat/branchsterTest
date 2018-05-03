package ScreenObjects;

import ScreenFactories.CustomizeBranchsterScreenFactory;
import Utils.BaseTest;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class CustomizeBranchsterScreen extends BaseTest {

    CustomizeBranchsterScreenFactory customizeBranchsterScreenFactory =
            new CustomizeBranchsterScreenFactory();

    public CustomizeBranchsterScreen() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), customizeBranchsterScreenFactory);
        waitForElementToLoad(customizeBranchsterScreenFactory.doneButton);
    }



}
