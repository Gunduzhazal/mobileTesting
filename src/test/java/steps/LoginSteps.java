package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.CommonMethods;
import utils.ConfigReader;

import java.net.MalformedURLException;

public class LoginSteps extends CommonMethods {

    @Given("the user is able to launch apk file in android device")
    public void the_user_is_able_to_launch_apk_file_in_android_device() throws MalformedURLException {
        launchApplication();
    }
    @When("user enters username and password")
    public void user_enters_username_and_password() throws InterruptedException {
        //System.out.println("test passed");
        loginPage.usernameField.clear();
        loginPage.usernameField.sendKeys(ConfigReader.getPropertyValue("usernamekey"));
        Thread.sleep(2000);

        loginPage.passwordField.clear();
        loginPage.passwordField.sendKeys(ConfigReader.getPropertyValue("passwordkey"));
        Thread.sleep(2000);
    }
    @When("user clicks on login button")
    public void user_clicks_on_login_button() throws InterruptedException {
        //System.out.println("test passed");
        loginPage.loginButton.click();
        Thread.sleep(2000);
    }
    @Then("user should be able to see homepage")
    public void user_should_be_able_to_see_homepage() {

        System.out.println("test passed");
    }

}
