package Tests;

import ScreenObjects.CustomizeScreen;
import ScreenObjects.InfoScreen;
import ScreenObjects.OverviewScreen;
import Utils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Acceptance extends BaseTest {

    // 1 - Verify that 'Overview' screen opens when 'Done' button gets pushed;
    @Test
    public void clickDoneVerifyOverviewScreenOpens() {
        CustomizeScreen customizeScreen = new CustomizeScreen();
        OverviewScreen overviewScreen =  customizeScreen.clickDone();
        Assert.assertTrue(overviewScreen.changeButtonIsDisplayed());
    }

    // 2 - Verify that 'Customize' screen opens when 'change' button gets pushed;
    @Test
    public void clickChangeVerifyCustomizeScreenOpens() {
        OverviewScreen overviewScreen = new CustomizeScreen().clickDone();
        CustomizeScreen customizeScreen = overviewScreen.clickChange();
        Assert.assertTrue(customizeScreen.doneButtonIsDisplayed());
    }

    // 3 - Verify that 'Info' screen opens when 'Info' button gets pushed;
    @Test
    public void clickInfoVerifyInfoScreenOpens() {
        OverviewScreen overviewScreen = new CustomizeScreen().clickDone();
        InfoScreen infoScreen = overviewScreen.clickInfo();
        Assert.assertTrue(infoScreen.goToBranchButtonIsDisplayed());
    }


    // 4 - Verify that when user doesn't customize name and just taps 'done'
    // default name value "Bingles Jingleheimer" is displayed on the 'Overview' screen of the app;
    @Test
    public void defaultNameIsDisplayed() {
        OverviewScreen overviewScreen = new CustomizeScreen().clickDone();
        Assert.assertTrue(overviewScreen.getName().equals("Bingles Jingleheimer"));
    }

    //Verify that after customizing monster's name and tapping 'Done' the chosen name
    // is displayed on the 'Overview' screen of the app;
    @Test
    public void changedNamePassedToOverviewScreen() {
        OverviewScreen overviewScreen = new CustomizeScreen().clickDone();
        overviewScreen.
    }




    @Test
    public void test() {
        System.out.println("Vlad" + driver.getContext());
        System.out.println("Vlad" + driver.getContext());
        switchToNativeContext();
        System.out.println("Vlad" + driver.getContext());

    }

}
