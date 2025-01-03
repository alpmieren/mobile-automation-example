import io.appium.java_client.android.AndroidStartScreenRecordingOptions;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import utilities.AppiumDriver;

import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Base64;

import static utilities.AppiumDriver.driver;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-reports.html"},
        features = "src/test/resources/features",
        glue = "stepdefinitions",
        dryRun = false,
        publish = true

)
public class Runner {
    @BeforeClass
    public static void beforeAllTests() throws Exception {
        AppiumDriver.setUp();
        driver = AppiumDriver.getDriver();
        driver.startRecordingScreen(
                new AndroidStartScreenRecordingOptions()
                        .withTimeLimit(Duration.ofMinutes(10))
                        .withVideoSize("1280x720")
                        .withBitRate(4000000) // 4Mbps
                        .enableBugReport()
        );
    }

    @AfterClass
    public static void afterAllTests() throws Exception {
        String base64Video = driver.stopRecordingScreen();
        byte[] decodedVideo = Base64.getDecoder().decode(base64Video);
        Path destinationPath = Paths.get("target", "screenRecording", "test.mp4");
        try (OutputStream out = Files.newOutputStream(destinationPath)) {
            out.write(decodedVideo);
        }
        driver.quit();
    }
}