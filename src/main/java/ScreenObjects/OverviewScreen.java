package ScreenObjects;

import ScreenFactories.OverviewScreenFactory;
import Utils.BaseTest;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class OverviewScreen extends BaseTest {

    OverviewScreenFactory overviewScreenFactory = new OverviewScreenFactory();

    public OverviewScreen() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), overviewScreenFactory);
        waitForElementToLoad(overviewScreenFactory.changeButton);
    }

    public boolean changeButtonIsDisplayed() {
        return overviewScreenFactory.changeButton.isDisplayed();
    }

    public CustomizeScreen clickChange() {
        overviewScreenFactory.changeButton.click();
        return new CustomizeScreen();
    }

    public InfoScreen clickInfo() {
        overviewScreenFactory.infoButton.click();
        return new InfoScreen();
    }

    public String getName() {
        return overviewScreenFactory.nameText.getText();
    }

}
