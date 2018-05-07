package Tests;

import ScreenObjects.AndroidShareScreen;
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
        Assert.assertTrue(overviewScreen.getNameText().equals("Bingles Jingleheimer"));
    }

    //Verify that after customizing monster's name and tapping 'Done' the chosen name
    // is displayed on the 'Overview' screen of the app;
    @Test
    public void changedNamePassedToOverviewScreen() {
        String name = "Filipp Kirkorov";
        CustomizeScreen customizeScreen = new CustomizeScreen();
        customizeScreen.setName(name);
        OverviewScreen overviewScreen = customizeScreen.clickDone();
        Assert.assertEquals(overviewScreen.getNameText(), name);
    }

    //Verify that monster name appears in monster's bio on 'Overview' screen;
    @Test
    public void nameIsDisplayedInBio() {
        String name = "Nick Cage";
        CustomizeScreen customizeScreen = new CustomizeScreen();
        customizeScreen.setName(name);
        OverviewScreen overviewScreen = customizeScreen.clickDone();
        Assert.assertTrue(overviewScreen.bioContainsName(name));
    }

    //Verify that Android share menu rolls up when 'share' button on the 'overview' screen gets pushed
    @Test
    public void shareMenuDisplayed() {
        OverviewScreen overviewScreen = new CustomizeScreen().clickDone();
        AndroidShareScreen androidShareScreen = overviewScreen.clickShareButton();
        Assert.assertTrue(androidShareScreen.shareOptionIsDisplayed("Post on reddit"));
    }


}
