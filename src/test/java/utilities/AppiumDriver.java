package utilities;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.URL;

public class AppiumDriver {
    public static AndroidDriver driver;
    static File appDir = new File("src/app");
    static File app = new File(appDir, "WikipediaSample.apk");

    public static void setUp() throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:deviceName", "emulator-5554");
        caps.setCapability("appium:app", "/Users/alperenbigin/IdeaProjects/upwork-mobile-automation/src/app/WikipediaSample.apk");
        caps.setCapability("appium:platformVersion","15");
        caps.setCapability("appium:automationName", "UiAutomator2");
        caps.setCapability("appium:appPackage", "org.wikipedia.alpha");
        caps.setCapability("appium:appActivity", "org.wikipedia.main.MainActivity");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);

    }
    public static AndroidDriver getDriver() {
        return driver;
    }

}
