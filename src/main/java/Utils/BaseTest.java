package Utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected static AppiumDriver driver;
    static WebDriverWait driverWait;

    protected static boolean elementIsNotPresent(By by) {
        try {
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            return driver.findElements(by).isEmpty();
        } finally {
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        }
    }

    protected boolean elementIsDisplayed(MobileElement mobileElement) {
        return mobileElement.isDisplayed();
    }

    protected void waitForElementToLoad(MobileElement id) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(id));
    }

    protected static boolean waitForAttributeToBeVisible(By by, String attribute, String textToBeVisible) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        return wait.until(ExpectedConditions.attributeToBe(by, attribute, textToBeVisible));
    }

    private void killUiAutomatorServer() throws IOException, InterruptedException {
        Process process = Runtime.getRuntime().exec("adb uninstall io.appium.uiautomator2.server");
        process.waitFor();
        Process process2 = Runtime.getRuntime().exec("adb uninstall io.appium.uiautomator2.server.test");
        process2.waitFor();
    }

    public void switchToWebViewContext() {
        for (Object contextName: driver.getContextHandles()) {
            if (contextName.toString().toUpperCase().contains("WEBVIEW")) {
                driver.context(contextName.toString());
                System.out.println("Switched to WebView context");
            }
        }
    }

    public void switchToNativeContext() {
        driver.context("NATIVE_APP");
    }

    @BeforeSuite(alwaysRun = true)
    public void setUp() throws IOException, InterruptedException {

        AppiumServer.startAppiumServer();
        killUiAutomatorServer();

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Test device");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(AndroidMobileCapabilityType.NO_SIGN, "true");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "io.branch.branchster");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_WAIT_ACTIVITY, ".MonsterCreatorActivity");
        capabilities.setCapability("autoGrantPermissions", "true");
        capabilities.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir") + "/app/base.apk");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 30);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driverWait = new WebDriverWait(driver, 30);
        System.out.println("DEBUG: Starting Appium driver");
    }

    @AfterSuite
    public void tearDown() throws IOException, InterruptedException {
        System.out.println("DEBUG: Stopping Appium driver");
        driver.quit();
        AppiumServer.stopAppiumServer();
    }

}
