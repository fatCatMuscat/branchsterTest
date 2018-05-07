package ScreenObjects;

import ScreenFactories.OverviewScreenFactory;
import Utils.BaseTest;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class OverviewScreen extends BaseTest {

    private OverviewScreenFactory overviewScreenFactory = new OverviewScreenFactory();

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

    public String getNameText() {
        return overviewScreenFactory.nameText.getText();
    }

    public boolean bioContainsName(String name) {
        String bio = overviewScreenFactory.descriprionText.getText();
        return  bio.contains(name);
    }

    public AndroidShareScreen clickShareButton() {
        overviewScreenFactory.shareButton.click();
        return new AndroidShareScreen();
    }

}
