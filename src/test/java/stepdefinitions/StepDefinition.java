package stepdefinitions;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utilities.AppiumDriver;

public class StepDefinition {
    public AndroidDriver driver;


    @Given("open to app")
    public void open_to_app(){
        //AppiumDriver.setUp();
        driver = AppiumDriver.getDriver();
        driver.findElement(AppiumBy.id("android:id/button1")).click();
        // driver.findElement(AppiumBy.id("com.android.permissioncontroller:id/permission_allow_button")).click();
    }

    @Given("Scroll to the end of the page")
    public void scrollToTheEndOfThePage() {
        driver.findElement(new AppiumBy.ByAndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).flingToEnd(5)"));

    }

    @When("Click My List,History and Nearby icons")
    public void clickMyListHistoryAndNearbyIcons() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("My lists")).click();
        Thread.sleep(3000);
        driver.findElement(AppiumBy.accessibilityId("History")).click();
        Thread.sleep(3000);
        driver.findElement(AppiumBy.accessibilityId("Nearby")).click();
        Thread.sleep(3000);
    }

    @When("Click Browse icon")
    public void clickBrowseIcon() {
        driver.findElement(AppiumBy.accessibilityId("Explore")).click();
    }

    @And("Scroll to the top of the page")
    public void scrollToTheTopOfThePage() {
        driver.findElement(new AppiumBy.ByAndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).flingToBeginning(5)"));
    }


    @Given("the user enters {string} in the search bar")
    public void the_user_enters_in_the_search_bar(String string) throws Exception {
        driver = AppiumDriver.getDriver();
        Thread.sleep(2000);
        driver.findElement(AppiumBy.id("org.wikipedia.alpha:id/fragment_feed_header")).click();
        Thread.sleep(1000);
        string = "New York";
        driver.findElement(AppiumBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys(string);
    }
    @Then("the search bar expands with the returned results")
    public void the_search_bar_expands_with_the_returned_results() throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(AppiumBy.id("org.wikipedia.alpha:id/fragment_search_results")).isDisplayed());
    }
    @When("the user double clicks on the close search button")
    public void the_user_double_clicks_on_the_close_search_button(){

        driver.findElement(AppiumBy.accessibilityId("Clear query")).click();
        driver.findElement(AppiumBy.accessibilityId("Clear query")).click();
    }

    @Given("Click on setting")
    public void click_on_setting() throws Exception {
        driver = AppiumDriver.getDriver();
        driver.findElement(AppiumBy.id("org.wikipedia.alpha:id/menu_overflow_button")).click();
        Thread.sleep(2000);
        driver.findElement(AppiumBy.id("org.wikipedia.alpha:id/explore_overflow_settings")).click();
    }
    @When("Disable all options")
    public void disable_all_options() {
        driver.findElement(AppiumBy.xpath("(//android.widget.Switch)[1]")).click();
        driver.findElement(AppiumBy.xpath("(//android.widget.Switch)[2]")).click();
        driver.findElement(AppiumBy.xpath("(//android.widget.Switch)[3]")).click();
        driver.findElement(AppiumBy.xpath("(//android.widget.Switch)[4]")).click();
    }
    @When("Back to home page")
    public void back_to_home_page() {
        driver.findElement(AppiumBy.accessibilityId("Navigate up")).click();
    }

}
