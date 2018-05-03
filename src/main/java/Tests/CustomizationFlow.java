package Tests;

import Utils.BaseTest;
import io.appium.java_client.MobileElement;
import org.testng.annotations.Test;

public class CustomizationFlow extends BaseTest {

    @Test
    public void openActivity() {
        waitForElementToLoad((MobileElement) driver.findElementById("io.branch.branchster:id/cmdDone"));
        MobileElement rightButton = (MobileElement)driver.findElementById("io.branch.branchster:id/cmdRight");
        rightButton.click();
        rightButton.click();
        rightButton.click();
    }


}
