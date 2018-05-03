package Utils;

import io.appium.java_client.service.local.AppiumDriverLocalService;

public class AppiumServer {

    private static AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();

    static void startAppiumServer() {
        service.start();
        System.out.println("Started appium server");
    }

    static void stopAppiumServer() {
        service.stop();
        System.out.println("Stopped appium server");
    }

}

