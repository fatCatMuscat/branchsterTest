package ScreenFactories;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class OverviewScreenFactory {

    @AndroidFindBy (id = "io.branch.branchster:id/cmdChange")
    public MobileElement changeButton;

    @AndroidFindBy (id = "io.branch.branchster:id/infoButton")
    public MobileElement infoButton;

    @AndroidFindBy (id = "io.branch.branchster:id/txtName")
    public MobileElement nameText;

    @AndroidFindBy (id = "io.branch.branchster:id/txtDescription")
    public MobileElement descriprionText;

    @AndroidFindBy (id = "io.branch.branchster:id/share_btn")
    public MobileElement shareButton;

}
