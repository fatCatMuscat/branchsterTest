package ScreenFactories;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;

public class AndroidShareScreenFactory {

    @AndroidFindBy (className = "android.widget.TextView")
    public List<MobileElement> shareOptions;

}
