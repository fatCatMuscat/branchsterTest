package ScreenObjects;

import ScreenFactories.InfoScreenFactory;
import Utils.BaseTest;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class InfoScreen extends BaseTest {

    InfoScreenFactory infoScreenFactory = new InfoScreenFactory();

    public InfoScreen() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), infoScreenFactory);
        waitForElementToLoad(infoScreenFactory.goToBranchButton);
    }

    public boolean goToBranchButtonIsDisplayed() {
        return infoScreenFactory.goToBranchButton.isDisplayed();
    }

    public void clickGoToBranch() {
        infoScreenFactory.goToBranchButton.click();
    }

}
