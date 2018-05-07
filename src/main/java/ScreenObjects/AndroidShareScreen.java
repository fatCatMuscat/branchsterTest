package ScreenObjects;

import ScreenFactories.AndroidShareScreenFactory;
import Utils.BaseTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;

public class AndroidShareScreen extends BaseTest {

    AndroidShareScreenFactory androidShareScreenFactory = new AndroidShareScreenFactory();

    public AndroidShareScreen() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), androidShareScreenFactory);
        waitForElementToLoad(androidShareScreenFactory.shareOptions.get(0));
    }

    public boolean shareOptionIsDisplayed(String option) {
        HashMap<MobileElement, String> map = new HashMap<MobileElement, String>();
        for (MobileElement me: androidShareScreenFactory.shareOptions) {
            map.put(me, me.getText().toUpperCase().trim());
        }
        return map.containsValue(option.toUpperCase());
    }

}
