package ScreenFactories;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;

public class CustomizeBranchsterScreenFactory {

    @AndroidFindBy(id = "io.branch.branchster:id/editName")
    public MobileElement pickANameTextField;

    @AndroidFindBy(id = "io.branch.branchster:id/cmdDone")
    public MobileElement doneButton;

    @AndroidFindBy(id = "io.branch.branchster:id/cmdLeft")
    public MobileElement leftArrowButton;

    @AndroidFindBy(id = "io.branch.branchster:id/cmdUp")
    public MobileElement upArrowButton;

    @AndroidFindBy(id = "io.branch.branchster:id/cmdRight")
    public MobileElement rightArrowButton;

    @AndroidFindBy(id = "io.branch.branchster:id/cmdDown")
    public MobileElement downArrowButton;

    @AndroidFindBy(className = "android.widget.RadioButton")
    public List<MobileElement> color;
}
